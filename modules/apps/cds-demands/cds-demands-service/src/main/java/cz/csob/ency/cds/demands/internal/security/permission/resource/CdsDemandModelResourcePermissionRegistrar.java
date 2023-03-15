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
package cz.csob.ency.cds.demands.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.internal.permission.CdsDemandPermissionLogic;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import cz.csob.ency.workflow.permission.EncyWorkflowPermission;
import cz.csob.ency.workflow.permission.EncyWorkflowedModelPermissionLogic;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

/**
 * CdsDemand Model Resource Permission Registrar
 *
 * @author Miroslav Čermák
 *
 */
@Component(immediate = true, service = {})
public class CdsDemandModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", CdsDemand.class.getName());

        _serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        CdsDemand.class, CdsDemand::getPrimaryKey,
                        _cdsdemandLocalService::getCdsDemand, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(
                                    new StagedModelPermissionLogic<>(
                                            _stagingPermission, CdsDemandPortletKeys.CDSDEMAND,
                                            CdsDemand::getPrimaryKey));
                            consumer.accept(
                                    new EncyWorkflowedModelPermissionLogic<>(
                                            _workflowPermission, modelResourcePermission,
                                            _groupLocalService, CdsDemand::getPrimaryKey));
                            consumer.accept(
                                    new CdsDemandPermissionLogic<>());

                        }),


                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }
    @Reference
    private CdsDemandLocalService _cdsdemandLocalService;
    @Reference
    private GroupLocalService _groupLocalService;
    @Reference(
            target = "(resource.name=" + CdsDemandConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;
    @SuppressWarnings("rawtypes")
    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private EncyWorkflowPermission _workflowPermission;

}