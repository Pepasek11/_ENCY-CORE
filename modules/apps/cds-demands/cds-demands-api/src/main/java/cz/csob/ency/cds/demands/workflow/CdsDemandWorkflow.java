package cz.csob.ency.cds.demands.workflow;

import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.workflow.annotation.EncyWorkflow;
import cz.csob.ency.workflow.annotation.EncyWorkflowState;
import cz.csob.ency.workflow.annotation.EncyWorkflowTransition;
import cz.csob.ency.workflow.definition.BaseEncyWorkflowDefinition;
import cz.csob.ency.workflow.definition.EncyWorkflowDefinition;
import org.osgi.service.component.annotations.Component;

@EncyWorkflow(
        title = "CDS Demands Testing Worflow",
        description = "Single approver bar workflow. ",
        nodes = {
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_NAVRH,
                        title = "navrh",
                        isInitial = true,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NAVRH_KE_SCHVALENI,
                                        title = "tr-odeslat-spocovi",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"

                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NAVRH_ZRUSIT,
                                        title = "tr-zrusit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times",
                                        cssIconColor = "danger"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                        title = "revize-spoc",
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_SCHVALIT,
                                        title = "tr-ke-schvaleni-cds",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_VRATIT,
                                        title = "tr-vratit-zadatelovi",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_NAVRH,
                                        cssIcon = "angle-left",
                                        cssIconColor = "info"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_POZASTAVIT,
                                        title = "tr-pozastavit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC,
                                        cssIcon = "pause",
                                        cssIconColor = "warning"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_ZRUSIT,
                                        title = "tr-zrusit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times",
                                        cssIconColor = "danger"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_SPOC_MIMO_CDS,
                                        title = "tr-k-reseni-mimo-cds",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_MIMO_BICDS,
                                        cssIcon = "redo",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_POZASTAVENO_SPOC,
                        title = "pozastaveno-spocem",
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_SPOC_OBNOVIT,
                                        title = "tr-obnovit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                                        cssIcon = "reply",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                        title = "revize-ban",
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALIT,
                                        title = "tr-predat-k-naceneni",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_NACENOVANO,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_SCHVALITUS,
                                        title = "tr-predat-k-naceneni-us",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_NACENOVANO,
                                        cssIcon = "caret-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_VRATIT,
                                        title = "tr-vratit-spocovi",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                                        cssIcon = "angle-left",
                                        cssIconColor = "info"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_POZASTAVIT,
                                        title = "tr-pozastavit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN,
                                        cssIcon = "pause",
                                        cssIconColor = "warning"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_ZAMITNOUT,
                                        title = "tr-zamitnout",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times",
                                        cssIconColor = "danger"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_BAN_MIMO_CDS,
                                        title = "tr-k-reseni-mimo-cds",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_MIMO_BICDS,
                                        cssIcon = "redo",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_POZASTAVENO_BAN,
                        title = "pozastaveno-banem",
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_POZASTAVENO_BAN_OBNOVIT,
                                        title = "tr-obnovit",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                                        cssIcon = "reply",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_MIMO_BICDS,
                        title = "tr-k-reseni-mimo-bicds",
                        isFinal = true,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_VRATIT_CDS,
                                        title = "tr-vratit-cds",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_SPOC,
                                        cssIcon = "reply",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_NACENOVANO,
                        title = "nacenovano",
                        isEditable = false,
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO,
                                        title = "tr-naceneno",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_NACENENO,
                                        cssIcon = "link"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US,
                                        title = "tr-naceneno-us",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REALIZACE,
                                        cssIcon = "link"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO,
                                        title = "tr-zruseno-v-bioe",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_ADM_DO_REVIZE,
                                        title = "tr-admin-do-revize",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                                        cssIcon = "reply",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_NACENENO,
                        title = "naceneno",
                        isEditable = false,
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENENO_SCHVALIT,
                                        title = "tr-realizovat",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REALIZACE,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENENO_ODMITNOUT,
                                        title = "tr-odmitnout",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times",
                                        cssIconColor = "danger"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_NACENENO_SYNC_ZRUSENO,
                                        title = "tr-zruseno-v-bioe",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "times",
                                        cssIconColor = "danger"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_REALIZACE,
                        title = "realizace",
                        isEditable = false,
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REALIZACE_DO_AKCEPTACE,
                                        title = "tr-predat-k-akceptaci",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE,
                                        title = "tr-do-akceptace-v-bioe",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                        cssIcon = "times",
                                        cssIconColor = "info"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO,
                                        title = "tr-zruseno-v-bioe",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "link",
                                        cssIconColor = "info"
                                )             ,
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REALIZACE_TMP_DO_REVIZE_BAN,
                                        title = "tr-admin-zpatky-do-revize-ban",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_BAN,
                                        cssIcon = "anonymize",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                        title = "akceptace",
                        isEditable = false,
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SCHVALIT,
                                        title = "tr-akceptovat",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_ODMITNOUT,
                                        title = "tr-odmitnout",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REVIZE_DODAVKY,
                                        cssIcon = "angle-left",
                                        cssIconColor = "danger"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO,
                                        title = "tr-zruseno-v-bioe",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                                        cssIcon = "link",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_REVIZE_DODAVKY,
                        title = "revize-dodavky",
                        isEditable = false,
                        isFinal = false,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_AKCEPTACE,
                                        title = "tr-vratit-do-akceptace",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_AKCEPTACE,
                                        cssIcon = "angle-right",
                                        cssIconColor = "success"
                                ),
                                @EncyWorkflowTransition(
                                        name = CdsDemandWorkflowConstants.TRANSITION_REVIZE_DODAVKY_DO_REALIZACE,
                                        title = "tr-vratit-do-realizace",
                                        targetStateName = CdsDemandWorkflowConstants.STATE_REALIZACE,
                                        cssIcon = "angle-left",
                                        cssIconColor = "info"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_AKCEPTOVANO,
                        title = "akceptovano",
                        isEditable = false,
                        isFinal = true
                ),
                @EncyWorkflowState(
                        name = CdsDemandWorkflowConstants.STATE_ZRUSENO,
                        title = "zruseno",
                        isEditable = false,
                        isFinal = true
                )
        }
)
@Component(immediate = true, service = EncyWorkflowDefinition.class)
public class CdsDemandWorkflow extends BaseEncyWorkflowDefinition {
}
