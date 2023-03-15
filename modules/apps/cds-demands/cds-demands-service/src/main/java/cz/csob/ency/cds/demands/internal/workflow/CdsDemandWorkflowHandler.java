// 
/*   */
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
/*  */


package cz.csob.ency.cds.demands.internal.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import cz.csob.ency.workflow.handler.BaseEncyWorkflowHandler;
import cz.csob.ency.workflow.handler.EncyWorkflowHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * CdsDemand Workflow Handler
 *
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
        service = EncyWorkflowHandler.class
)
public class CdsDemandWorkflowHandler extends BaseEncyWorkflowHandler<CdsDemand> {

    @Override
    public Class<?> getModelClass() {
        return CdsDemand.class;
    }

    @Override
    public String getType(Locale locale) {
        return ResourceActionsUtil.getModelResource(locale, getModelClassName());
    }

    /*
        @Override
        public CdsDemand updateState(String state, Map<String, Serializable> workflowContext) throws PortalException {
            long userId = GetterUtil.getLong(
                (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
            long classPK = GetterUtil.getLong(
                (String)workflowContext.get(
                    WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

            ServiceContext serviceContext = (ServiceContext)workflowContext.get(
                "serviceContext");

            return _cdsDemandLocalService.updateState(
                userId, classPK, state, serviceContext, workflowContext);
        }
    */
    @Override
    public CdsDemand updateModel(CdsDemand model, ServiceContext serviceContext) throws PortalException {
        return _cdsDemandLocalService.updateEntry(model, serviceContext);
    }

    @Reference(unbind = "-")
    protected void setCdsDemandLocalService(
            CdsDemandLocalService cdsDemandLocalService) {

        _cdsDemandLocalService = cdsDemandLocalService;
    }

    private CdsDemandLocalService _cdsDemandLocalService;

}