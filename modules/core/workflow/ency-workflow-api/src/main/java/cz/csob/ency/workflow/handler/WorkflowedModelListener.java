package cz.csob.ency.workflow.handler;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.BaseModelListener;

public abstract class WorkflowedModelListener<T extends BaseModel<T>> extends BaseModelListener<T> {
    public WorkflowedModelListener() {
        super();
    }
}
