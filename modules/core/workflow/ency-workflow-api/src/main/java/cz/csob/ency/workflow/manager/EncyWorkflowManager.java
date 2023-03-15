package cz.csob.ency.workflow.manager;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowInstance;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ProviderType
public interface EncyWorkflowManager {
    void deleteWorkflowInstance(String className, long classPK)
            throws PortalException;

    List<EncyWorkflowTransition> getAllowedOutgoingTransitions(
            long companyId, long groupId, ClassedModel model, ServiceContext serviceContext);

    List<EncyWorkflowTransition> getOutgoingTransitions(long companyId, long groupId, ClassedModel model);

    List<EncyWorkflowTransition> getOutgoingTransitions(
            long companyId, long groupId, String className, long primaryKey);

    List<String> getOutgoingTransitionsNames(
            long companyId, long groupId, String className, long primaryKey);

    EncyWorkflow getWorkflow(
            long companyId, long groupId, String className, long primaryKey);

    EncyWorkflow getWorkflow(EncyWorkflowInstance instance);

    EncyWorkflowInstance getWorkflowInstance(
            long companyId, long groupId, String className, long primaryKey);

    EncyWorkflowStateInstance getWorkflowStateInstance(
            long companyId, long groupId, ClassedModel model);

    EncyWorkflowStateInstance getWorkflowStateInstance(
            long companyId, long groupId, String className, long primaryKey);

    <T> T performTransition(long companyId, long groupId, long userId, String className,
                            long classPK, T model, String transitionName, String comment,
                            ServiceContext serviceContext, Map<String, Serializable> workflowContext)
            throws PortalException;

    <T> T startWorkflowInstance(
            long companyId, long groupId, long userId, String className,
            long classPK, T model, ServiceContext serviceContext,
            Map<String, Serializable> workflowContext)
            throws PortalException;
}
