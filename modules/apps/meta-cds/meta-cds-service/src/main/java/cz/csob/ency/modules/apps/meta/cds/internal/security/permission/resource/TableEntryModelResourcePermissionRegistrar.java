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
package cz.csob.ency.modules.apps.meta.cds.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.TableEntryConstants;
import cz.csob.ency.modules.apps.meta.cds.model.TableEntry;
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

/**
 * TableEntry Model Resource Permission Registrar
 *
 * @author Miroslav Čermák
 *
 */
@Component(immediate = true, service = {})
public class TableEntryModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", TableEntry.class.getName());

        _serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        TableEntry.class, TableEntry::getPrimaryKey,
                        _tableentryLocalService::getTableEntry, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(
                                    new StagedModelPermissionLogic<>(
                                            _stagingPermission, MetaCdsPortletKeys.METACDS,
                                            TableEntry::getPrimaryKey));

                            consumer.accept(
                                    new WorkflowedModelPermissionLogic<>(
                                            _workflowPermission, modelResourcePermission,
                                            _groupLocalService, TableEntry::getPrimaryKey));
                        }),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference(
            target = "(resource.name=" + TableEntryConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;
    @SuppressWarnings("rawtypes")
    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
    @Reference
    private StagingPermission _stagingPermission;
    @Reference
    private TableEntryLocalService _tableentryLocalService;
    @Reference
    private WorkflowPermission _workflowPermission;

}