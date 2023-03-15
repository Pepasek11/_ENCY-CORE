package cz.csob.ency.workflow.internal.manager;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.TransactionConfig;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;
import cz.csob.ency.workflow.exception.NoSuchStateException;
import cz.csob.ency.workflow.exception.NoSuchStateInstanceException;
import cz.csob.ency.workflow.exception.NoSuchTransitionException;
import cz.csob.ency.workflow.handler.EncyWorkflowHandler;
import cz.csob.ency.workflow.handler.EncyWorkflowHandlerRegistry;
import cz.csob.ency.workflow.manager.EncyWorkflowManager;
import cz.csob.ency.workflow.model.*;
import cz.csob.ency.workflow.runtime.action.manager.EncyWorkflowActionManager;
import cz.csob.ency.workflow.service.*;
import cz.csob.ency.workflow.util.WorkflowContextBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.ws.rs.NotSupportedException;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component(
        immediate = true, service = EncyWorkflowManager.class
)
public class EncyWorkflowManagerImpl implements EncyWorkflowManager {
    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowManagerImpl.class);
    private static final TransactionConfig _transactionConfig;

    @Override
    public void deleteWorkflowInstance(String className, long classPK)
            throws PortalException {
        encyWorkflowInstanceLocalService.deleteEncyWorkflowInstance(
                className, classPK);
    }

    @Override
    public List<EncyWorkflowTransition> getAllowedOutgoingTransitions(
            long companyId, long groupId, ClassedModel model, ServiceContext serviceContext) {
        List<EncyWorkflowTransition> outgoingTransitions = getOutgoingTransitions(companyId, groupId, model);

        EncyWorkflowStateInstance wsi =
                getWorkflowStateInstance(companyId, groupId, model.getModelClassName(), (Long) model.getPrimaryKeyObj());

        return outgoingTransitions.stream().filter((EncyWorkflowTransition transition) -> {
            try {
                return encyWorkflowActionManager.isTransitionAllowed(
                        wsi, transition, serviceContext.getUserId(), (EncyWorkflowedModel) model, serviceContext);
            } catch (PortalException e) {
                return false;
            }
        }).collect(Collectors.toList());
    }

    @Override
    public List<EncyWorkflowTransition> getOutgoingTransitions(long companyId, long groupId, ClassedModel model) {
        Serializable pk = model.getPrimaryKeyObj();

        if (!Long.class.isAssignableFrom(pk.getClass())) {
            _log.debug("Only primary keys of the Long type are supported. ");
            throw new NotSupportedException("Only primary keys of the Long type are supported.");
        }
        return getOutgoingTransitions(companyId, groupId, model.getModelClassName(), (Long) pk);
    }

    @Override
    public List<EncyWorkflowTransition> getOutgoingTransitions(
            long companyId, long groupId, String className, long primaryKey) {

        EncyWorkflowStateInstance stateInstance =
                getWorkflowStateInstance(companyId, groupId, className, primaryKey);

        if (Validator.isNull(stateInstance)) {
            _log.debug("No Workflow State Instance for entry " + className + ":" + primaryKey);
            return Collections.emptyList();
        }

        long stateId = stateInstance.getWorkflowState().getStateId();

        return EncyWorkflowTransitionLocalServiceUtil.getOutgoingTransitions(stateId);
    }

    @Override
    public List<String> getOutgoingTransitionsNames(
            long companyId, long groupId, String className, long primaryKey) {
        return getOutgoingTransitions(companyId, groupId, className, primaryKey)
                .stream().map(encyWorkflowTransition -> encyWorkflowTransition.getName())
                .collect(Collectors.toList());

    }

    @Override
    public EncyWorkflow getWorkflow(
            long companyId, long groupId, String className, long primaryKey) {

        EncyWorkflowInstance instance =
                encyWorkflowInstanceLocalService.getWorkflowInstance(
                        companyId, groupId, className, primaryKey);

        if (Validator.isNull(instance)) {
            return null;
        }

        return encyWorkflowLocalService.fetchEncyWorkflow(instance.getWorkflowId());
    }

    @Override
    public EncyWorkflow getWorkflow(EncyWorkflowInstance instance) {
        if (Validator.isNull(instance)) {
            return null;
        }

        return encyWorkflowLocalService.fetchEncyWorkflow(instance.getWorkflowId());
    }

    @Override
    public EncyWorkflowInstance getWorkflowInstance(
            long companyId, long groupId, String className, long primaryKey) {

        return encyWorkflowInstanceLocalService.getWorkflowInstance(
                companyId, groupId, className, primaryKey);
    }

    @Override
    public EncyWorkflowStateInstance getWorkflowStateInstance(
            long companyId, long groupId, ClassedModel model) {
        Serializable pk = model.getPrimaryKeyObj();
        if (!Long.class.isAssignableFrom(pk.getClass())) {
            throw new NotSupportedException("Only primary keys of the Long type are supported.");
        }

        return getWorkflowStateInstance(companyId, groupId, model.getModelClassName(), (Long) pk);

    }

    @Override
    public EncyWorkflowStateInstance getWorkflowStateInstance(
            long companyId, long groupId, String className, long primaryKey) {

        EncyWorkflowInstance workflowInstance =
                encyWorkflowInstanceLocalService.getWorkflowInstance(
                        companyId, groupId, className, primaryKey);

        if (workflowInstance == null) {
            //@todo Pokud entry nema wf, nastartovat jej? Nebo chyba?
            _log.warn("Entry " + className + ":" + primaryKey + " is not under workflow. ");
            return null;
        }

        return encyWorkflowStateInstanceLocalService.getCurrentWorkflowStateInstance(
                workflowInstance.getWorkflowInstanceId());
    }

    @Override
    public <T> T performTransition(long companyId, long groupId, long userId, String className,
                                   long classPK, T model, String transitionName, String comment,
                                   ServiceContext serviceContext, Map<String, Serializable> workflowContext)
            throws PortalException {

        try {
            Callable<T> callable = new Callable<T>() {

                @Override
                public T call() throws Exception {
                    return _performTransition(companyId, groupId, userId, className,
                            classPK, model, transitionName, comment,
                            serviceContext, workflowContext);
                }
            };

            return TransactionInvokerUtil.invoke(_transactionConfig, callable);
        } catch (Throwable throwable) {
            if (throwable instanceof PortalException) {
                throw (PortalException) throwable;
            }

            if (throwable instanceof PortletException) {
                throw (PortalException) throwable;
            }

            throw new PortalException(throwable);
        }
    }

    @Override
    @Transactional
    public <T> T startWorkflowInstance(
            long companyId, long groupId, long userId, String className,
            long classPK, T model, ServiceContext serviceContext,
            Map<String, Serializable> workflowContext)
            throws PortalException {

        if (_log.isDebugEnabled()) _log.debug("Starting workflow instance " +
                "[cId:" + companyId + ",gId:" + groupId + ", uId:" + userId + ", class:" +
                className + ", cPk" + classPK + "]");

        EncyWorkflowHandler<T> workflowHandler =
                encyWorkflowHandlerRegistry.getWorkflowHandler(className);

        if (null == workflowHandler) {
            _log.warn("There is no workflow handler for " + className);
            return model;
        }

        if (_hasWorkflowInstanceInProgress(companyId, groupId, className, classPK)) {
            // Workflow is already present, no need to start new
            if (_log.isDebugEnabled()) _log.debug("There is an active workflow instance already.");
            return model;
        }

        EncyWorkflowLink workflowLink = null;

        workflowLink = workflowHandler.getWorkflowLink(
                companyId, groupId, classPK);

        if (workflowLink == null) {
            if (_log.isDebugEnabled()) _log.debug("Workflow link not found.");
            return model;
        }

        EncyWorkflow workflowEntry =
                EncyWorkflowLocalServiceUtil.getEncyWorkflow(
                        workflowLink.getWorkflowId()
                );

        if (workflowEntry == null) {
            _log.warn("There is Workflow Link (id=" + workflowLink.getWorkflowLinkId() +
                    ") but linked Workflow is missing (id = " + workflowLink.getWorkflowId() + ")");
            return model;
        }

        Map<String, Serializable> wc = WorkflowContextBuilder
                .putAll(workflowContext)
                .putModel((Serializable) model) // before put class name and id !
                .putClassName(className)
                .putClassPk(classPK)
                .putServiceContext(serviceContext) // before put company, group and user
                .putCompanyId(companyId)
                .putGroupId(groupId)
                .putUserId(userId)
                .putEntryType(workflowHandler.getType(LocaleUtil.getDefault()))
                .putWorkflowId(workflowEntry.getWorkflowId())
                .putWorkflowVersion(workflowEntry.getVersion())
                .build();

        if (!workflowEntry.isActive()) {
            if (_log.isDebugEnabled()) _log.debug("Workflow Entry is not active.");

            return model;
        }

        String state = workflowEntry.getInitialStateName();

        if (_log.isDebugEnabled()) {
            _log.debug("Initial workflow [" + workflowEntry.getClassName() +
                    "] state " + state);
        }

        T updatedModel = workflowHandler.updateState(
                model, state, wc);
        wc.put(
                EncyWorkflowConstants.CONTEXT_ENTRY, (Serializable) updatedModel
        );

        if (workflowLink != null) {
//            Map<String, Serializable> tempWorkflowContext =
//                    new HashMap<>(workflowContext);
//
//            TransactionCommitCallbackUtil.registerCallback(
//                    () -> {
            if (!_hasWorkflowInstanceInProgress(
                    companyId, groupId, className, classPK)) {

                EncyWorkflowInstance wi = workflowHandler.startWorkflowInstance(
                        companyId, groupId, userId, classPK, updatedModel,
                        wc);


            }
//
//                        return null;
//                    });
        }

        if (_log.isDebugEnabled()) _log.debug("End of workflow instance create");

        return updatedModel;
    }

    private Function<String, ServiceContext> _createServiceContextFunction(
            final long companyId) {

        return new Function<String, ServiceContext>() {

            @Override
            public ServiceContext apply(String className) {
                ServiceContext serviceContext = new ServiceContext();

                serviceContext.setCompanyId(companyId);

                return serviceContext;
            }

        };
    }

    private boolean _hasWorkflowInstanceInProgress(
            long companyId, long groupId, String className, long classPK) {

        EncyWorkflowInstance workflowInstance =
                encyWorkflowInstanceLocalService.getWorkflowInstance(
                        companyId, groupId, className, classPK);

        // @todo allow 'restart' workflow when complete, or invalid (inactive) state?
        if (Validator.isNotNull(workflowInstance)) {
            return true;
        }

        return false;
    }

    private <T> T _performTransition(long companyId, long groupId, long userId, String className,
                                     long classPK, T model, String transitionName, String comment,
                                     ServiceContext serviceContext, Map<String, Serializable> workflowContext)
            throws PortalException {

        if (_log.isDebugEnabled()) _log.debug("Performing transition  " +
                "[cId:" + companyId + ",gId:" + groupId + ", uId:" + userId + ", class:" +
                className + ", cPk:" + classPK + ", tName:" + transitionName +
                ", comment:" + comment + "]");

        if (Validator.isNull(model)) {
            throw new InvalidParameterException("Expecting model object, but null is passed. ");
        }

        EncyWorkflowHandler<T> workflowHandler =
                encyWorkflowHandlerRegistry.getWorkflowHandler(className);

        if (null == workflowHandler) {
            _log.warn("There is no workflow handler for " + className);
            return model;
        }

        EncyWorkflowStateInstance wsi =
                getWorkflowStateInstance(companyId, groupId, className, classPK);

        if (wsi == null) {
            throw new NoSuchStateInstanceException("Entry " + className
                    + ":" + classPK + " is not under workflow ");
        }

        EncyWorkflowState sourceWS = wsi.getWorkflowState();

        EncyWorkflowTransition wt =
                encyWorkflowTransitionLocalService.fetchEncyWorkflowTransition(
                        sourceWS.getStateId(), transitionName
                );

        if (wt == null) {
            throw new NoSuchTransitionException("Transition `" + transitionName + "` not found ");
        }

        EncyWorkflowState targetWS =
                encyWorkflowStateLocalService.fetchEncyWorkflowState(wt.getTargetStateId());

        if (targetWS == null) {
            throw new NoSuchStateException("State id " + wt.getTargetStateId() + " not found ");
        }

        workflowContext = new HashMap<>(
                workflowContext
        );

        workflowContext = WorkflowContextBuilder
                .putAll(workflowContext)
                .putModel((Serializable) model) // before put class name and id !
                .putClassName(className)
                .putClassPk(classPK)
                .putServiceContext(serviceContext) // before put company, group and user
                .putCompanyId(companyId)
                .putGroupId(groupId)
                .putUserId(userId)
                .putEntryType(workflowHandler.getType(LocaleUtil.getDefault()))
                .putTaskComment(comment)
                .putWorkflowId(wsi.getWorkflowId())
                .build();

        Boolean isTransitionAllowed = encyWorkflowActionManager.isTransitionAllowed(
                wsi, transitionName, userId, (EncyWorkflowedModel) model, workflowContext);

        if (!isTransitionAllowed) {
            _log.warn("User " + userId + " is trying to perform forbidden  transition " + transitionName +
                    " on entry " + model.getClass() + ":" + ((EncyWorkflowedModel<?>) model).getPrimaryKey());
            return model;
        }

        encyWorkflowActionManager.stateExit(wsi, transitionName, workflowContext);

        EncyWorkflowStateInstance closedWsi = encyWorkflowStateInstanceLocalService.completeWorkflowStateInstance(
                wsi.getStateInstanceId(), userId, workflowContext
        );

        EncyWorkflowStateInstance newWsi = encyWorkflowStateInstanceLocalService.startWorkflowStateInstance(
                wt.getTargetStateId(), wsi.getWorkflowId(), wsi.getWorkflowInstanceId(),
                targetWS.getVersion(), wsi.getGroupId(), wsi.getCompanyId(), userId, workflowContext
        );

        encyWorkflowTransitionInstanceLocalService.addEncyWorkflowTransitionInstance(
                wt.getTransitionId(), sourceWS.getStateId(), wsi.getStateInstanceId(),
                wsi.getWorkflowId(), wsi.getWorkflowInstanceId(),
                newWsi.getStateId(), newWsi.getStateInstanceId(),
                wt.getVersion(), groupId, companyId, userId, comment, workflowContext
        );

        T updatedModel = workflowHandler.updateState(model, newWsi.getWorkflowState().getName(), workflowContext);


        workflowContext.put(
                EncyWorkflowConstants.CONTEXT_ENTRY, (Serializable) updatedModel
        );


        encyWorkflowActionManager.stateEntry(newWsi, transitionName, workflowContext);

        updatedModel = workflowHandler.updateModel(updatedModel, serviceContext);

        if(userId==0){
            userId= UserLocalServiceUtil.getDefaultUserId(companyId);
        }

        if (Validator.isNotNull(comment)) {
            CommentManagerUtil.addComment(
                    userId,
                    groupId,
                    className,
                    classPK,
                    StringPool.BLANK,//@todo username
                    StringPool.BLANK,//@todo title
                    comment,
                    _createServiceContextFunction(companyId)
            );
        }

        return updatedModel;
    }

    static {
        TransactionConfig.Builder builder = new TransactionConfig.Builder();

        builder.setPropagation(Propagation.SUPPORTS);
        builder.setRollbackForClasses(Exception.class);
        builder.setReadOnly(false);

        _transactionConfig = builder.build();
    }

    @Reference
    private EncyWorkflowActionManager encyWorkflowActionManager;
    @Reference
    private EncyWorkflowHandlerRegistry encyWorkflowHandlerRegistry;
    @Reference
    private EncyWorkflowInstanceLocalService encyWorkflowInstanceLocalService;
    @Reference
    private EncyWorkflowLocalService encyWorkflowLocalService;
    @Reference
    private EncyWorkflowStateInstanceLocalService encyWorkflowStateInstanceLocalService;
    @Reference
    private EncyWorkflowStateLocalService encyWorkflowStateLocalService;
    @Reference
    private EncyWorkflowTransitionInstanceLocalService encyWorkflowTransitionInstanceLocalService;
    @Reference
    private EncyWorkflowTransitionLocalService encyWorkflowTransitionLocalService;
}
