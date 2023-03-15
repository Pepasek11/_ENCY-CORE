package cz.csob.ency.cds.demands.internal.workflow.runtime;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.EncyWorkflowOnStateEntryAction;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,
        service = EncyWorkflowOnStateEntryAction.class,
        property = {
                "ency.workflow.class.name=" + CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME,
                "ency.workflow.state.name=NONE",
        }
)
public class CdsDemandOnStateEntry implements EncyWorkflowOnStateEntryAction {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandOnStateEntry.class);

    @Override
    public void perform(ExecutionContext executionContext) {
        CdsDemand demand = (CdsDemand) executionContext.getModel();


    }
}
