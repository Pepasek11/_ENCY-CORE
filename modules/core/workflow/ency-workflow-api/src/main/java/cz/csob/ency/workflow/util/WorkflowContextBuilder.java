package cz.csob.ency.workflow.util;

import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.BaseMapBuilder;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.workflow.constants.EncyWorkflowConstants;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WorkflowContextBuilder extends BaseMapBuilder {
    WorkflowContextBuilder() {
    }

    public static WorkflowContextBuilder.WorkflowContextWrapper empty() {
        WorkflowContextBuilder.WorkflowContextWrapper workflowContextWrapper =
                new WorkflowContextBuilder.WorkflowContextWrapper();
        return workflowContextWrapper;
    }

    public static WorkflowContextBuilder.WorkflowContextWrapper fromServiceContext(ServiceContext serviceContext) {
        WorkflowContextBuilder.WorkflowContextWrapper workflowContextWrapper =
                new WorkflowContextBuilder.WorkflowContextWrapper();
        return workflowContextWrapper.putServiceContext(serviceContext);
    }

    public static WorkflowContextBuilder.WorkflowContextWrapper put(String key, Serializable value) {
        WorkflowContextBuilder.WorkflowContextWrapper workflowContextWrapper =
                new WorkflowContextBuilder.WorkflowContextWrapper();
        return workflowContextWrapper.put(key, value);
    }

    public static WorkflowContextBuilder.WorkflowContextWrapper putAll(Map<String, Serializable> inputMap) {
        WorkflowContextBuilder.WorkflowContextWrapper workflowContextWrapper =
                new WorkflowContextBuilder.WorkflowContextWrapper();
        return workflowContextWrapper.putAll(inputMap);
    }

    public static class WorkflowContextWrapper {
        WorkflowContextWrapper() {
            this._hashMap = new HashMap<>();
        }

        public WorkflowContextWrapper(int initialCapacity) {
            this._hashMap = new HashMap(initialCapacity);
        }

        public WorkflowContextWrapper(int initialCapacity, float loadFactor) {
            this._hashMap = new HashMap(initialCapacity, loadFactor);
        }

        public WorkflowContextWrapper(Map<? extends String, ? extends Serializable> map) {
            this._hashMap = new HashMap(map);
        }

        public Map<String, Serializable> build() {
            return this._hashMap;
        }

        public WorkflowContextWrapper put(String key, Serializable value) {
            this._hashMap.put(key, value);
            return this;
        }

        public WorkflowContextWrapper putAll(Map<String, Serializable> inputMap) {
            this._hashMap.putAll(inputMap);
            return this;
        }

        public WorkflowContextWrapper putClassName(String value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, value);
            return this;
        }

        public WorkflowContextWrapper putClassName(Class<?> value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, value.getName());
            return this;
        }

        public WorkflowContextWrapper putClassPk(long value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, String.valueOf(value));
            return this;
        }

        public WorkflowContextWrapper putClassPk(Object value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, String.valueOf(value));
            return this;
        }

        public WorkflowContextWrapper putCompanyId(long value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_COMPANY_ID, String.valueOf(value));
            return this;
        }

        public WorkflowContextWrapper putEntryType(String value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_ENTRY_TYPE, value);
            return this;
        }

        public WorkflowContextWrapper putGroupId(long value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_GROUP_ID, String.valueOf(value));
            return this;
        }

        public WorkflowContextWrapper putModel(Serializable value) {

            this._hashMap.put(EncyWorkflowConstants.CONTEXT_ENTRY, value);
            if (ClassedModel.class.isAssignableFrom(value.getClass())) {
                putClassName(((ClassedModel) value).getModelClassName());
                putClassPk(((ClassedModel) value).getPrimaryKeyObj());
            }
            return this;
        }

        public WorkflowContextWrapper putServiceContext(ServiceContext value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_SERVICE_CONTEXT, value);
            putCompanyId(value.getCompanyId());
            putGroupId(value.getScopeGroupId());
            putUserId(value.getUserId());
            return this;
        }

        public WorkflowContextWrapper putTaskComment(String value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_TASK_COMMENTS, value);
            return this;
        }

        public WorkflowContextWrapper putUserId(long value) {
            this._hashMap.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(value));
            this._hashMap.put(EncyWorkflowConstants.CONTEXT_USER_NAME,
                    WorkflowHelperUtils.getUserName(value));
            return this;
        }

        public WorkflowContextWrapper putWorkflowId(long value) {
            this._hashMap.put(EncyWorkflowConstants.CONTEXT_WORKFLOW_ID, String.valueOf(value));
            return this;
        }

        public WorkflowContextWrapper putWorkflowVersion(long value) {
            this._hashMap.put(EncyWorkflowConstants.CONTEXT_WORKFLOW_VERSION, String.valueOf(value));
            return this;
        }

        private HashMap<String, Serializable> _hashMap;
    }
}
