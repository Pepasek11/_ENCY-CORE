package cz.csob.ency.cds.demands.internal.notifications;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.*;
import com.liferay.portal.kernel.util.SubscriptionSender;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.internal.util.UrlHelperUtils;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.common.helpers.UserHelperUtil;
import cz.csob.ency.delegations.service.DelegationLocalServiceUtil;

import java.io.StringWriter;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class CdsDemandNotificationSender {
    private static final String COMMON_MAIL_TEMPLATE = "templates/commonmailtemplate.ftl";
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandNotificationSender.class);

    public CdsDemandNotificationSender(CdsDemand demand) {
        _demand = demand;
        _toSpoc = false;
        _toBan = false;
        _toContact = false;
        _toLorm = false;
        _toRequestor = false;
        _template = COMMON_MAIL_TEMPLATE;
        _mailSubject = "[Ency] Cds Demands Notification";
        _mailInfo = demand.getTitle();
        _mailBody = "";

        try {
            sender(UserLocalServiceUtil.getDefaultUser(demand.getCompanyId()));
        } catch (PortalException e) {
            sender(0);
        }
    }

    public CdsDemandNotificationSender body(String body) {
        _mailBody = body;
        return this;
    }

    public CdsDemandNotificationSender info(String info) {
        _mailInfo = info;
        return this;
    }

    public String renderMailBody(String info, String content, String entryName, String entryLink) {
        String mailHtmlBody = "";
        try {
            URL url = this.getClass().getClassLoader().getResource(COMMON_MAIL_TEMPLATE);
            if (Validator.isNull(url)) {
                _log.warn("There is no template with name " + COMMON_MAIL_TEMPLATE);
                return StringPool.BLANK;
            }

            TemplateResource templateResource =
                    new URLTemplateResource(COMMON_MAIL_TEMPLATE, url);

            Template template = TemplateManagerUtil.getTemplate(
                    TemplateConstants.LANG_TYPE_FTL, templateResource, false);

            // Add the data-models
            template.put("mailInfo", info);
            template.put("mailContent", content);
            template.put("entryName", entryName);
            template.put("entryLink", entryLink);

            StringWriter out = new StringWriter();

            template.processTemplate(out);
            mailHtmlBody = out.toString();

        } catch (TemplateException e1) {
            e1.printStackTrace();
        }

        return mailHtmlBody;
    }

    public void send() {
        String mailBody = renderMailBody(
                _mailInfo, _mailBody, _demand.getTitle(),
                UrlHelperUtils.getViewUrl(_demand));

        SubscriptionSender subscriptionSender = new SubscriptionSender();
        subscriptionSender.setCompanyId(_demand.getCompanyId());
        subscriptionSender.setPortletId(CdsDemandPortletKeys.CDSDEMAND);
        subscriptionSender.setNotificationType(CdsDemandConstants.NOTIFICATION_TYPE_WORKFLOW);

        subscriptionSender.setBody(mailBody);
        subscriptionSender.setSubject(_mailSubject);
        subscriptionSender.setFrom(_senderMail, _senderName);
        subscriptionSender.setMailId("workflow_action", _demand.getDemandId());
        subscriptionSender.setHtmlFormat(true);

        subscriptionSender.setClassName(CdsDemand.class.getName());
        subscriptionSender.setClassPK(_demand.getPrimaryKey());
        subscriptionSender.setEntryTitle(_demand.getTitle());

        _log.debug("Send to BAN [" + _toBan + "]");
        if (_toBan) {
            addSubscriber(_demand.getBanId(), subscriptionSender);

            DelegationLocalServiceUtil.getDelegationsOfUser(
                    _demand.getGroupId(), CdsDemandConstants.DELEGATION_ROLE_BAN_CODE, _demand.getBanId()
            ).forEach(delegation -> addSubscriber(delegation.getDelegatedUserId(), subscriptionSender));
        }

        _log.debug("Send to SPOC [" + _toSpoc + "]");
        if (_toSpoc) {
            addSubscriber(_demand.getSpocId(), subscriptionSender);

            DelegationLocalServiceUtil.getDelegationsOfUser(
                    _demand.getGroupId(), CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE, _demand.getSpocId()
            ).forEach(delegation -> addSubscriber(delegation.getDelegatedUserId(), subscriptionSender));
        }

        _log.debug("Send to requestor [" + _toRequestor + "]");
        if (_toRequestor) {
            addSubscriber(_demand.getRequestorId(), subscriptionSender);
            addSubscriber(_demand.getRequestedForId(), subscriptionSender);
        }

        _log.debug("Send to contact [" + _toContact + "]");
        if (_toContact) {
            addSubscriber(_demand.getContactId(), subscriptionSender);
        }

        _log.debug("Send to LORM [" + _toLorm + "]");
        if (_toLorm) {
            List<User> users = Collections.EMPTY_LIST;
            Role role = RoleLocalServiceUtil.fetchRole(_demand.getCompanyId(), CdsDemandConstants.ROLE_ENCYLORM);
            if (Validator.isNotNull(role)) {
                users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            }
            users.forEach(user -> addSubscriber(user.getUserId(), subscriptionSender));
        }

        subscriptionSender.flushNotificationsAsync();
    }

    public CdsDemandNotificationSender sender(String mail, String name) {
        _senderMail = mail;
        _senderName = name;
        return this;
    }

    public CdsDemandNotificationSender sender(long userId) {
        User u = UserLocalServiceUtil.fetchUser(userId);
        return sender(u);
    }

    public CdsDemandNotificationSender sender(User u) {
        if (Validator.isNotNull(u)) {
            String mail = u.getEmailAddress();
            if (!Validator.isBlank(mail)) {
                _senderMail = mail;
                _senderName = UserHelperUtil.getFormattedUserName(u);
                return this;
            }
        }
        _senderMail = "ency_admins@csob.cz";
        _senderName = "BI-CDS ENCY";
        return this;
    }

    public CdsDemandNotificationSender subject(String subject) {
        _mailSubject = subject;
        return this;
    }

    public CdsDemandNotificationSender targets(boolean toBan, boolean toSpoc,
                                               boolean toRequestor, boolean toContact, boolean toLorm) {
        _toBan = toBan;
        _toSpoc = toSpoc;
        _toRequestor = toRequestor;
        _toContact = toContact;
        _toLorm = toLorm;
        return this;
    }

    public CdsDemandNotificationSender toBan() {
        _toBan = true;
        return this;
    }

    public CdsDemandNotificationSender toContact() {
        _toContact = true;
        return this;
    }

    public CdsDemandNotificationSender toLorm() {
        _toLorm = true;
        return this;
    }

    public CdsDemandNotificationSender toRequestor() {
        _toRequestor = true;
        return this;
    }

    public CdsDemandNotificationSender toSpoc() {
        _toSpoc = true;
        return this;
    }

    protected void addSubscriber(long id, SubscriptionSender subscriptionSender) {
        User user = UserLocalServiceUtil.fetchUser(id);
        if (Validator.isNull(user) || !user.isActive() || Validator.isBlank(user.getEmailAddress())) {
            _log.debug("invalid user " + id);
            return;
        }
        _log.debug("adding subscriber " + UserHelperUtil.getFormattedUserName(user) + "<" + user.getEmailAddress() + ">");

        String mail = user.getEmailAddress();

        if (!Validator.isBlank(mail)) {
            subscriptionSender.addRuntimeSubscribers(
                    mail, UserHelperUtil.getFormattedUserName(user));
        }
    }

    private CdsDemand _demand;
    private String _mailBody;
    private String _mailInfo;
    private String _mailSubject;
    private String _senderMail;
    private String _senderName;
    private String _template;
    private boolean _toBan;
    private boolean _toContact;
    private boolean _toLorm;
    private boolean _toRequestor;
    private boolean _toSpoc;

}
