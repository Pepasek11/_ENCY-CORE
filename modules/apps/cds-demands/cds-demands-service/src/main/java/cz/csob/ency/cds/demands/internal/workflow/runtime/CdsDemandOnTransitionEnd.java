package cz.csob.ency.cds.demands.internal.workflow.runtime;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.internal.notifications.CdsDemandNotificationSender;
import cz.csob.ency.cds.demands.internal.util.UrlHelperUtils;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandGdprInfoLocalServiceUtil;
import cz.csob.ency.common.helpers.UserHelper;
import cz.csob.ency.connection.sql.SqlUtils;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.EncyWorkflowOnTransitionEndAction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(immediate = true,
        service = EncyWorkflowOnTransitionEndAction.class,
        property = {
                "ency.workflow.class.name=" + CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME,
                "ency.workflow.transition.name=ALL"
        }
)
public class CdsDemandOnTransitionEnd implements EncyWorkflowOnTransitionEndAction<CdsDemand> {
    private static final long SEND2BAN = 1 << 1;
    private static final long SEND2CONTACT = 1 << 3;
    private static final long SEND2LORM = 1 << 4;
    private static final long SEND2REQUESTOR = 1 << 2;
    private static final long SEND2SPOC = 1;

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandOnTransitionEnd.class);
    private static final String mailSubjectPREFIX = "[BI CDS - Požadavky]";

    @Override
    public void perform(ExecutionContext<CdsDemand> executionContext) {

        CdsDemand demand = executionContext.getModel();
        String transitionCode = executionContext.getTransitionName();
        ServiceContext serviceContext = executionContext.getServiceContext();

        if (demand != null) {
            // _log.warn("Transition end " + transitionCode + " for " + demand.getTitle());
        } else {
            _log.warn("Demand is null");
            return;
        }

        long userId = Long.parseLong(
                executionContext.getWorkflowContext().getOrDefault(
                                WorkflowConstants.CONTEXT_USER_ID, 0)
                        .toString());

        long companyId = Long.parseLong(
                String.valueOf(
                        executionContext.getWorkflowContext().getOrDefault(
                                WorkflowConstants.CONTEXT_COMPANY_ID, 0)));

        User user = UserLocalServiceUtil.fetchUser(userId);
        if (user == null) {
            try {
                user = UserLocalServiceUtil.fetchUser(serviceContext.getGuestOrUserId());
            } catch (PortalException e) {
            }
        }

        String comment = executionContext.getWorkflowContext().getOrDefault(
                WorkflowConstants.CONTEXT_TASK_COMMENTS, "").toString();

        // Jméno požadavku
        String demandName = demand.getTitle();

        // Odkaz na požadavek
        String demandLink = UrlHelperUtils.getViewUrl(demand);

        // Jmeno aktera
        String userName = Validator.isNull(user) ? "Ency System" : userHelper.getFormattedUserName(user);

        long requestorId = demand.getRequestedForId();
        String requestorName = demand.getRequestedForName();
        if (requestorId == 0) {
            requestorId = demand.getRequestorId();
            requestorName = demand.getRequestorName();
        }

        // Jméno BANa
        String banName = demand.getBanName();


        String mailContent = "";
        String mailInfo = "";
        String mailSubject = "";

        long towho = 0;
        switch (transitionCode) {
            case CdsDemandWorkflowConstants.TRANSITION_NAVRH_ZRUSIT:
                // Neni potrba informovat pokud si zadatel rusi svuj pozadavek
                return;
            case CdsDemandWorkflowConstants.TRANSITION_NAVRH_KE_SCHVALENI:
                towho = SEND2SPOC;
                mailInfo = "Nový požadavek čeká na schválení";
                mailSubject = mailSubjectPREFIX + " Nový požadavek '" + demandName + "' čeká na Vaše schválení";
                mailContent = String.format(
                        "<b>%s</b> založil(a) nový požadavek <a href=\"%s\">%s</a> " +
                                " a odeslal Vám ho ke schválení, protože máte přirazenou roli SPOCa."
                        , userName, demandLink, demandName);
                break;

            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_SCHVALIT:
                towho = SEND2BAN;
                mailInfo = "Požadavek čeká na revizi zadání";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' čeká na revizi zadání";
                mailContent = String.format(
                        "SPOC <b>%s</b> schválil(a) požadavek <a href=\"%s\">%s</a>" +
                                " a odeslal Vám ho k revizi zadání a schválení pro realizaci, " +
                                " protože máte přirazenou roli BANa."
                        , userName, demandLink, demandName);
                break;

            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_VRATIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl vrácen SPOCEm";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' čeká na úpravu zadání";
                mailContent = String.format(
                        "SPOC <b>%s</b> vrátil(a) požadavek <a href=\"%s\">%s</a>" +
                                " k úpravě zadání."
                        , userName, demandLink, demandName);
                break;

            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_MIMO_CDS:
                towho = SEND2REQUESTOR;
                mailInfo = "Požadavek schválen SPOCem k řešení mimo BI CDS";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl schválen SPOCem k řešení mimo BI CDS";
                mailContent = String.format(
                        "SPOC <b>%s</b> schválil(a) požadavek <a href=\"%s\">%s</a> k řešení mimo BI CDS."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_POZASTAVIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl pozastaven SPOCem";
                mailSubject = mailSubjectPREFIX + " Pozastavení požadavku '" + demandName + "' SPOCem";
                mailContent = String.format(
                        "SPOC <b>%s</b> pozastavil(a) Váš požadavek <a href=\"%s\">%s</a>."
                        , userName, demandLink, demandName);

                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_ZRUSIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl zamítnut SPOCem";
                mailSubject = mailSubjectPREFIX + " Zamítnutí požadavku '" + demandName + "'";
                mailContent = String.format(
                        "SPOC <b>%s</b> zamítnul(a) Váš požadavek <a href=\"%s\">%s</a>." +
                                "<br /><br />" +
                                "Zamítnutý požadavek bude automaticky smazán po 14ti dnech od zamítnutí."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_SPOC_OBNOVIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl obnoven SPOCem";
                mailSubject = mailSubjectPREFIX + " Obnovení požadavku '" + demandName + "'";
                mailContent = String.format(
                        "SPOC <b>%s</b> obnovil(a) Váš požadavek <a href=\"%s\">%s</a>."
                        , userName, demandLink, demandName);
                break;

            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALIT:
                towho = SEND2REQUESTOR | SEND2CONTACT | SEND2LORM;
                mailInfo = "Požadavek byl schválen BANem a posunut k nacenění";
                mailSubject = mailSubjectPREFIX + " Schválení požadavku '" + demandName + "'";
                mailContent = String.format(
                        "BAN <b>%s</b> schválil(a) Váš požadavek <a href=\"%s\">%s</a>" +
                                " a předal(a) ho k nacenění."
                        , userName, demandLink, demandName);

                insert2BIOE(demand);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALITUS:
                towho = SEND2REQUESTOR | SEND2CONTACT | SEND2LORM;
                mailInfo = "US požadavek byl schválen BANem";
                mailSubject = mailSubjectPREFIX + " Schválení US požadavku '" + demandName + "'";
                mailContent = String.format(
                        "BAN <b>%s</b> schválil(a) Váš Ultraspeed požadavek <a href=\"%s\">%s</a>" +
                                " a předal(a) ho k nacenění a stanovení termínu dodání. "
                        , userName, demandLink, demandName);

                insert2BIOE(demand);

                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_POZASTAVIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl pozastaven BANem";
                mailSubject = mailSubjectPREFIX + " Pozastavení požadavku '" + demandName + "' BANem";
                mailContent = String.format(
                        "BAN <b>%s</b> pozastavil(a) Váš požadavek <a href=\"%s\">%s</a>."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_VRATIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl vrácen BANem";
                mailSubject = mailSubjectPREFIX + " Vrácení požadavku '" + demandName + "'";
                mailContent = String.format(
                        "BAN <b>%s</b> vrátil(a) Váš požadavek <a href=\"%s\">%s</a>. " +
                                "Před opětovným odesláním BANovi upravte požadavek dle připomínek. "
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_ZAMITNOUT:
                towho = SEND2SPOC | SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl zamítnut BANem";
                mailSubject = mailSubjectPREFIX + " Zamítnutí požadavku '" + demandName + "'";
                mailContent = String.format(
                        "BAN <b>%s</b> zamítnul(a) Váš požadavek <a href=\"%s\">%s</a>." +
                                " Požadavek bude ponechán v Ency kvůli evidenci."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_BAN_OBNOVIT:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl obnoven BANem";
                mailSubject = mailSubjectPREFIX + " Obnovení požadavku '" + demandName + "'";
                mailContent = String.format(
                        "BAN <b>%s</b> obnovil(a) Váš požadavek <a href=\"%s\">%s</a>."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_VRATIT_CDS:
                //tmp technicky
                return;

            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO:
                towho = SEND2SPOC;
                mailInfo = "Požadavek byl naceněn";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' je již naceněn";
                mailContent = String.format(
                        "nacenili jsme požadavek  <a href=\"%s\">%s</a> a čekáme na " +
                                "Vaše schválení pracnosti a termínu dodání.<br /><br />" +
                                "<b>${requestorName}</b> čeká na Vaši reakci."
                        , demandLink, demandName, requestorName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "US požadavek byl posunut k implementaci";
                mailSubject = mailSubjectPREFIX + " Posunutí US požadavku do implementace'" + demandName + "'";
                mailContent = String.format(
                        "nacenili jsme Váš Ultraspeed požadavek <a href=\"%s\">%s</a>" +
                                " a předali ho k implementaci."
                        , demandLink, demandName);
                if (Validator.isNull(demand.getAcceptedDelivery())) {
                    demand.setAcceptedDelivery(demand.getExpectedDelivery());
                }
                if (demand.getAcceptedWorkEstimate() <= 0) {
                    demand.setAcceptedWorkEstimate(demand.getWorkEstimate());
                }
                _log.warn("Entry" + demand);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_ADM_DO_REVIZE:
                //technicky prechod adminem, typicky pro opravu nebo ladeni
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO:
                towho = SEND2SPOC | SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek byl zrušenen během naceňování";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl zrušenen v CDS";
                mailContent = String.format(
                        "požadavek  <a href=\"%s\">%s</a> byl zrušenen v CDS.<br /><br />" +
                                "S případnými dotazy Vám pomůže BAN <b>%s</b>."
                        , demandLink, demandName, banName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_ODMITNOUT:
                towho = SEND2REQUESTOR | SEND2CONTACT | SEND2BAN;
                mailInfo = "Naceněný požadavek byl odmítnut SPOCem";
                mailSubject = mailSubjectPREFIX + " Naceněný požadavek '" + demandName + "' byl odmítnut SPOCem";
                mailContent = String.format(
                        "SPOC <b>%s</b> odmítnul(a) realizaci požadavku <a href=\"%s\">" +
                                "%s</a> s uvedeným naceněním a termínem dodání."
                        , userName, demandLink, demandName);
                sync2bioe(demand, 99, serviceContext);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_SCHVALIT:
                towho = SEND2REQUESTOR | SEND2CONTACT | SEND2BAN;
                mailInfo = "Požadavek byl schválen SPOCem a posunut do vývoje";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl posunut do vývoje";
                mailContent = String.format(
                        "SPOC <b>%s</b> schválil(a) k realizaci naceněný požadavek <a href=\"%s\">" +
                                "%s</a> a posunul ho tím do vývoje."
                        , userName, demandLink, demandName);

                if (Validator.isNull(demand.getAcceptedDelivery())) {
                    demand.setAcceptedDelivery(demand.getExpectedDelivery());
                }
                if (demand.getAcceptedWorkEstimate() <= 0) {
                    demand.setAcceptedWorkEstimate(demand.getWorkEstimate());
                }
                _log.warn("Entry" + demand);
                sync2bioe(demand, 7, serviceContext);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_DO_AKCEPTACE:
                sync2bioe(demand, 8, serviceContext);
                // no break, chceme aby se vykonal i case "vrealizaci_dotestu"
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE:
                towho = SEND2REQUESTOR | SEND2CONTACT | SEND2SPOC;
                mailInfo = "Požadavek byl dokončen a čeká na otestování a akceptaci";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' je připraven k otestování a akceptaci";
                mailContent = String.format(
                        "Váš požadavek <a href=\"%s\">%s</a> je připraven a čeká na Vaše otestování a akceptaci." +
                                "<br /><br /> Pro akceptaci požadavku klikněte na tlačítko AKCEPTOVAT DODÁVKU v Ency."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SCHVALIT:
                towho = SEND2BAN;
                mailInfo = "Požadavek byl akceptován";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl akceptován";
                mailContent = String.format(
                        "<b>%s</b> akceptoval(a) řešení požadavku " +
                                "<a href=\"%s\">%s</a>. Akceptace požadavku v BIOE proběhne automaticky."
                        , userName, demandLink, demandName);
                sync2bioe(demand, 11, serviceContext);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_ODMITNOUT:
                towho = SEND2BAN;
                mailInfo = "Řešení požadavku nebylo akceptováno ";
                mailSubject = mailSubjectPREFIX + " Řešení požadavku '" + demandName + "' nebylo akceptováno";
                mailContent = String.format(
                        "<b>%s</b> odmítl(a) řešení požadavku " +
                                "<a href=\"%s\">%s</a>. Posuďte důvody odmítnutí a vraťte požadavek do vývoje, nebo do akceptace."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_AKCEPTACE:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Řešení požadavku bylo posouzeno jako vyhovujúci a vráceno do akceptace";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl vrácen do akceptace";
                mailContent = String.format(
                        "BAN <b>%s</b>  zamítl reklamaci řešení požadavku " +
                                "<a href=\"%s\">%s</a> a vrátil Vám ho k opětovnému otestování."
                        , userName, demandLink, demandName);
                break;
            case CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_REALIZACE:
                towho = SEND2REQUESTOR | SEND2CONTACT;
                mailInfo = "Požadavek vrácen do vývoje";
                mailSubject = mailSubjectPREFIX + " Požadavek '" + demandName + "' byl BANem vrácen do vývoje";
                mailContent = String.format(
                        "BAN <b>%s</b> akceptoval(a) reklamaci řešení požadavku " +
                                "<a href=\"%s\">%s</a> a vrátil jej do vývoje. <br />"
                        , userName, demandLink, demandName);

                sync2bioe(demand, 7, serviceContext);
                break;

            default:
                _log.warn("Unknown transition_code [" + transitionCode + "].");
                return;
        }

        if (!Validator.isBlank(comment)) {
            mailContent += "<br/>Komentář:<br/><br/><i>" + comment + "</i><br/>";
        }

        CdsDemandNotificationSender sender = new CdsDemandNotificationSender(demand);
        sender
                .info(mailInfo)
                .body(mailContent)
                .subject(mailSubject)
                .sender(user)
                .targets(
                        (towho & SEND2BAN) != 0,
                        (towho & SEND2SPOC) != 0,
                        (towho & SEND2REQUESTOR) != 0,
                        (towho & SEND2CONTACT) != 0,
                        false
                ).send();

        _notifyLorm(demand, user, demandLink);
    }

    private void _notifyLorm(CdsDemand entry, User user, String demandLink) {
        boolean hasGDPRInfo = entry.getIsGDPR();
        if (!hasGDPRInfo) {
            try {
                hasGDPRInfo =
                        CdsDemandGdprInfoLocalServiceUtil.getAllInDemandId(entry.getPrimaryKey()).size() > 0;
            } catch (Exception ex) {
                _log.error(ex);
            }
        }
        if (!hasGDPRInfo) return;

        String mailSubject = mailSubjectPREFIX + " Požadavek označen pro GDPR";
        String mailBody = "";


        mailBody = String.format("Dobrý den, <br/><br/> " +
                        "BAN <b>%s</b> akceptoval(a) požadavek <a href=\"%s\">%s</a>, " +
                        "jehož výstup by měl obsahovat osobní údaje." +
                        " Jakožto LORM můžete zadané informace pro GDPR zkontrolovat nebo upravit.<br/><br/>" +
                        " S přáním hezkého dne,<br/>Ency",
                userHelper.getFormattedUserName(user), demandLink, entry.getTitle());

        CdsDemandNotificationSender sender = new CdsDemandNotificationSender(entry);
        sender
                .info("Požadavek označen pro GDPR")
                .body(mailBody)
                .subject(mailSubject)
                .sender(user)
                .toLorm()
                .send();

    }

    /**
     * Vlozeni pozadavku do BIOE
     *
     * @param entry
     * @return
     */
    private void insert2BIOE(CdsDemand entry) {
        long entryId = entry.getPrimaryKey();

        User ban = UserLocalServiceUtil.fetchUser(entry.getBanId());
        if (Validator.isNull(ban)) {
            _log.error("unable to get BAN user for banId " + entry.getBanId());
            //throw new PortalException("unable to get BAN user for banId "+entry.getBanId());
            return;
        }

        String banEN = String.valueOf(ban.getExpandoBridge().getAttribute("employee_number"));
        if (Validator.isBlank(banEN)) {
            banEN = ban.getScreenName();
        }

        long requestorId = entry.getRequestedForId() == 0 ? entry.getRequestorId() : entry.getRequestedForId();
        User requestor = UserLocalServiceUtil.fetchUser(requestorId);
        if (Validator.isNull(requestor)) {
            _log.error("unable to get requestor user for requestorId " + requestorId);
            //throw new PortalException("unable to get requestor user for requestorId "+requestorId);
            return;
        }
        String requestorEN = String.valueOf(requestor.getExpandoBridge().getAttribute("employee_number"));
        if (Validator.isBlank(requestorEN)) {
            requestorEN = requestor.getScreenName();
        }

        String fiveTracksStr = String.join(",",
                Arrays.stream(
                        entry.getFiveTracksArray()).mapToObj(
                        i -> String.valueOf(i)).collect(
                        Collectors.toList()));
        String plainDescription = HtmlUtil.stripHtml(entry.getDescription());

        try {
            // Safety check, if record exist
            List<Map<String, Object>> res =
                    SqlUtils.executeSelect("bioe",
                            "SELECT TOP 1 [id] FROM  [dbo].[DX_NEW_ENCY] WHERE id=?",
                            String.valueOf(entryId)
                    );

            // record already exists, do not try to add
            if (res.size() > 0) {
                _log.debug("Entry [" + entryId + "] already has " + res.size() + " record(s) in DX table");
                return;
            }

            long ures = SqlUtils.executeUpdate("bioe",
                    "insert into DX_NEW_ENCY (" +
                            "[username], " +
                            "[Status], " +
                            "[createddate], " +
                            "[description], " +
                            "[id], " +
                            "[summary], " +
                            "[demandtype], " +
                            "[priorita_zakaznika]," +
                            "[pozadovany_termin]," +
                            "[banname]," +
                            "[strategic_tracks_ids]" +
                            ") values (?,0,GETDATE(),?,?,?,?,?,?,?,?)"
                    , requestorEN
                    , plainDescription
                    , entry.getPrimaryKey()
                    , entry.getTitle()
                    , entry.getType()
                    , entry.getPriority()
                    , new java.sql.Timestamp(entry.getRequestedDelivery().getTime())
                    , banEN
                    , fiveTracksStr
            );

            _log.warn("Added " + ures + " records");

            /*
            try {
                if (requestorLogin == null || requestorLogin == '' || requestorLogin.toLowerCase().equals("unknown")) {
                    log.error("$LOGHEAD: Requestor with empty osc sent into BIOE!!! : $entry")
                    // Zadatel nema osobni cislo, co je buga, dej vedet MHE a EncyAdminom
                    def body = "Z Ency byl do BIOE odoslán CDS požadavek ${entry.getAbsoluteLink()} , kterého žadatel má neplatné/neznáme osobní číslo. <br><br>" +
                            "Podívejte se na to, jinak se požadavek nezaloži v BIOE. <br><br>Vaše Ency"

                    ms.sendMail(new EmailRecipient('HEJNA Michal', 'mihejna@csob.cz'), "MAILHEADERPREFIX - Založen požadavek s neplatným os.č. žadatele", body)
                    ms.sendMail(new EmailRecipient('Ency Administrators', 'ency_admins@csob.cz'), "$MAILHEADERPREFIX - Založen požadavek s neplatným os.č. žadatele", body)
                }
            } catch (Exception e) {
                log.error("$LOGHEAD: Exception occured when notifiing about requestor without osc. $e")
            }
             */
        } catch (Exception e) {
            _log.error("Exception occured when inserting task into BIOE :", e);
        }
    }

    /**
     * Synchronizace stavu do BIOE
     *
     * @param entry       Entry, ktera se synchronizuje
     * @param targetState Cilovy stav, ktery se ma v BIOE nastavit
     * @return
     */
    private void sync2bioe(CdsDemand entry, int targetState, ServiceContext serviceContext) {
        String login = "";//@todo
        long uid = serviceContext.getUserId();
        if (uid > 0) {
            User u = UserLocalServiceUtil.fetchUser(uid);
            if (u != null) {
                login = u.getScreenName();
            }
        }

        long xid = entry.getPrimaryKey();
        try {
            SqlUtils.executeUpdate("bioe",
                    "INSERT INTO [dbo].[DX_NEW_ENCY_SYNCHRO]\n" +
                            "(" +
                            "   [username] " +
                            "   ,[Status]" +
                            "   ,[createddate]" +
                            "   ,[sync_date]" +
                            "   ,[xid]" +
                            "   ,[target_state]" +
                            "   ,[Poznamka]" +
                            "   ,[os_c])\n" +
                            " VALUES\n" +
                            "(?,0,GETDATE(),null ,?,?,null,null)",
                    login, xid, targetState);
        } catch (Exception e) {
            _log.error("Exception occured when inserting task into BIOE :", e);
            // throw new XformsException("Nepovedlo se uložit požadavek do BIOE databáze")
        }
    }

    @Reference
    UserHelper userHelper;
}
