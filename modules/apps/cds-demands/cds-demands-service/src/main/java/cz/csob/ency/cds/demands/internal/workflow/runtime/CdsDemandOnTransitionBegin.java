package cz.csob.ency.cds.demands.internal.workflow.runtime;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.workflow.runtime.ExecutionContext;
import cz.csob.ency.workflow.runtime.action.EncyWorkflowOnTransitionStartAction;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,
        service = EncyWorkflowOnTransitionStartAction.class,
        property = {
                "ency.workflow.class.name=" + CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME,
                "ency.workflow.transition.name=NONE"
        }
)
public class CdsDemandOnTransitionBegin implements EncyWorkflowOnTransitionStartAction {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandOnTransitionBegin.class);

    @Override
    public void perform(ExecutionContext executionContext) {
        CdsDemand demand = (CdsDemand) executionContext.getModel();
        String transitionName = executionContext.getTransitionName();
    }
}
