package cz.csob.ency.cds.demands.internal.workflow;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.cds.demands.constants.CdsDemandWorkflowConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.workflow.exception.InvalidEncyWorkflowLinkException;
import cz.csob.ency.workflow.service.EncyWorkflowLinkLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Automatically register workflow for all instances of CdsDemandWorkflow
 *
 * @author Miroslav Čermák
 * @todo register demands workflow instead of the testing barflow
 */

@Component(immediate = true)
public class CdsDemandWorkflowRegistrator {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandWorkflowRegistrator.class);

    @Activate
    public void activate() {

        try {
            _encyWorkflowLinkLocalService.addWorkflowLink(
                    0, 0, 0, CdsDemand.class.getName(),
                    null, 0, CdsDemandWorkflowConstants.WORKFLOW_CLASS_NAME
            );
        } catch (InvalidEncyWorkflowLinkException e) {
            _log.error(e.getMessage());
        }
    }

    @Reference
    private EncyWorkflowLinkLocalService _encyWorkflowLinkLocalService;
}
