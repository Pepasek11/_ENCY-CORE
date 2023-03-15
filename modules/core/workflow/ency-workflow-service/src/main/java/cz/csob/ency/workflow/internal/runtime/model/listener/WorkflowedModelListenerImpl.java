package cz.csob.ency.workflow.internal.runtime.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import cz.csob.ency.workflow.entry.model.EncyWorkflowedModel;
import cz.csob.ency.workflow.handler.WorkflowedModelListener;
import cz.csob.ency.workflow.manager.EncyWorkflowManagerUtil;
import cz.csob.ency.workflow.model.EncyWorkflowStateInstance;
import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.runtime.action.manager.EncyWorkflowSignalerUtil;
import cz.csob.ency.workflow.util.WorkflowContextBuilder;
import org.osgi.service.component.annotations.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class WorkflowedModelListenerImpl<T extends EncyWorkflowedModel<T>> extends WorkflowedModelListener<T> {
    private static final Log _log = LogFactoryUtil.getLog(
            WorkflowedModelListenerImpl.class);

    public WorkflowedModelListenerImpl() {
        super();
    }

    public WorkflowedModelListenerImpl(Class<T> modelClass) {
        super();
        this._modelClass = modelClass;
    }

    @Override
    public Class<?> getModelClass() {
        return this._modelClass;
    }

    @Override
    public void onAfterUpdate(T originalModel, T model) throws ModelListenerException {
        super.onAfterUpdate(originalModel, model);

        EncyWorkflowStateInstance wsi = EncyWorkflowManagerUtil.getService().getWorkflowStateInstance(
                model.getCompanyId(),
                model.getGroupId(),
                model
        );
        Map<String, Serializable> wc = WorkflowContextBuilder.empty().putModel(model).build();
        EncyWorkflowTransition transition = EncyWorkflowSignalerUtil.getService().getAutoTransition(
                wsi,
                model,
                wc
        );

        if (transition != null) {
            //auto transiton is defined. so perform it.

            // register after commit
            ServiceContext sc = new ServiceContext();
            sc.setScopeGroupId(originalModel.getGroupId());

            TransactionCommitCallbackUtil.registerCallback(
                    () -> {
                        try {

                            EncyWorkflowManagerUtil.getService().performTransition(
                                    model.getCompanyId(),
                                    model.getGroupId(),
                                    0, model.getModelClassName(),
                                    model.getPrimaryKey(),
                                    model,
                                    transition.getName(),
                                    "Auto transition", sc, new HashMap<>()
                            );
                        } catch (PortalException e) {
                            e.printStackTrace();
                        }

                        return null;
                    });
        }

    }

    private Class<T> _modelClass;

}
