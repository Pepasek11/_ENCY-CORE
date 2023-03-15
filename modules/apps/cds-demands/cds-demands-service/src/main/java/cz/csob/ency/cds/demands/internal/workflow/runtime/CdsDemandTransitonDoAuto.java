package cz.csob.ency.cds.demands.internal.workflow.runtime;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.cds.demands.constants.CdsDemandType;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.connection.sql.SqlUtils;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.EncyWorkflowTransitionDoAutoAction;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Map;

@Component(immediate = true,
        service = EncyWorkflowTransitionDoAutoAction.class,
        property = {
                "ency.workflow.class.name=" + CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_NACENENO_SYNC_ZRUSENO,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO,
                "ency.workflow.transition.name=" + CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE,
        }
)
public class CdsDemandTransitonDoAuto implements EncyWorkflowTransitionDoAutoAction<CdsDemand> {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandTransitonDoAuto.class);

    @Override
    public boolean perform(ExecutionContext<CdsDemand> executionContext) {
        CdsDemand demand = executionContext.getModel();
        String transitionCode = executionContext.getTransitionName();

        if (Validator.isNull(demand)) {
            _log.warn("Demand is null");
            return false;
        }
        if (Validator.isBlank(transitionCode)) {
            _log.warn("transitionName is blank");
            return false;
        }

        //_log.warn("checking auto trandition ["+transitionCode+"] for entry "+demand);
        switch (transitionCode) {
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_NACENENO_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_ZRUSENO:
            case CdsDemandWorkflowConstants.TRANSITION_AKCEPTACE_SYNC_ZRUSENO:
                if (demand.getBioeStateId() == 99) {
                    return true;
                }
                break;


            case CdsDemandWorkflowConstants.TRANSITION_REALIZACE_SYNC_DO_AKCEPTACE:
                // Taky stav 11-akceptovano, at se to pohne v ency z realizace a byznys ma moznost schvalit
                int pendingState = _getPendingSyncState(demand.getPrimaryKey());
                // Pokud je v sync tabulce cekajici sync do jineho stavu nez 8 a 10, nedelat prechod
                // Pokud neni, je to ok a muzem prechod udelat dle dat z bioe
                if (pendingState == 0 && (demand.getBioeStateId() == 8 || demand.getBioeStateId() == 11)
                        || pendingState == 8 || pendingState == 11) {

                    return true;
                }
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO:
                if (demand.getWorkEstimate() > 0
                        && demand.getExpectedDelivery() != null
                        && demand.getType() == CdsDemandType.TYPE_BS) {
                    return true;
                }
                break;
            case CdsDemandWorkflowConstants.TRANSITION_NACENOVANO_NACENENO_US:
                if (demand.getWorkEstimate() > 0
                        && demand.getExpectedDelivery() != null
                        && demand.getType() == CdsDemandType.TYPE_US) {
                    return true;
                }
                break;
        }
        return false;
    }

    private int _getPendingSyncState(long entryId) {
        String sql = " SELECT TOP (1) [Status], [createddate], [sync_date], [target_state]\n" +
                "  FROM [BIOE].[dbo].[DX_NEW_ENCY_SYNCHRO]\n" +
                "  WHERE Status=0 and xid=?\n" +
                "  ORDER BY createddate desc";

        try {
            List<Map<String, Object>> res =
                    SqlUtils.executeSelect("bioe", sql, entryId);

            if (res.size() > 0) {
                return GetterUtil.getInteger(res.get(0).get("target_state"), 0);
            }
        } catch (Exception e) {
            _log.error(e);
        }

        return 0;
    }
}
