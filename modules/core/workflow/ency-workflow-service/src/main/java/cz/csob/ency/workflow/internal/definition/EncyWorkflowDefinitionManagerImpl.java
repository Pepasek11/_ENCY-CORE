/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.workflow.internal.definition;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.workflow.definition.EncyWorkflowDefinition;
import cz.csob.ency.workflow.service.EncyWorkflowLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        service = EncyWorkflowDefinitionManagerImpl.class
)
public class EncyWorkflowDefinitionManagerImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowDefinitionManagerImpl.class);

    @Activate
    protected void activate(ComponentContext componentContext)
            throws Exception {

        _bundleContext = componentContext.getBundleContext();

        if (_log.isDebugEnabled()) {
            _log.debug("Activating EncyWorkflowLocalService");
        }

        // Register bundle tracker to watch over available Apps
        _serviceTracker = ServiceTrackerFactory.open(
                _bundleContext,
                "(objectClass=" + EncyWorkflowDefinition.class.getName() + ")",
                new EncyWorkflowDefinitionServiceTrackerCustomizer());

        this._initialized = true;
    }

    @Deactivate
    protected void deactivate() {
        if (_log.isDebugEnabled()) {
            _log.debug("Deactivating EncyWorkflowLocalService");
        }
        this._initialized = false;
        if (_bundleContext == null) {
            return;
        }

        if (_serviceTracker != null) {
            _serviceTracker.close();
        }

        _bundleContext = null;
    }

    private final Map<String, ServiceReference<EncyWorkflowDefinition>> _serviceReferences = new HashMap<>();
    private volatile BundleContext _bundleContext;
    @Reference
    private EncyWorkflowLocalService _encyWorkflowLocalService;
    private volatile boolean _initialized;
    private volatile ServiceTracker<EncyWorkflowDefinition, EncyWorkflowDefinition> _serviceTracker;

    private class EncyWorkflowDefinitionServiceTrackerCustomizer
            implements ServiceTrackerCustomizer<EncyWorkflowDefinition, EncyWorkflowDefinition> {

        @Override
        public EncyWorkflowDefinition addingService(ServiceReference<EncyWorkflowDefinition> reference) {
            EncyWorkflowDefinition workflowDefinition = _bundleContext.getService(reference);
            String definitionClass = workflowDefinition.getClass().getName();

            if (_log.isDebugEnabled()) {
                this._log.debug("Adding workflow " + workflowDefinition.getTitle() + " under key " + definitionClass);
            }

            if (_serviceReferences.containsKey(definitionClass)) {
                _serviceReferences.replace(definitionClass, reference);
            } else {
                _serviceReferences.put(definitionClass, reference);
            }

            if(workflowDefinition.isValid()) {
                _encyWorkflowLocalService.saveWorkflow(workflowDefinition);
            }

            return workflowDefinition;
        }

        @Override
        public void modifiedService(ServiceReference<EncyWorkflowDefinition> reference, EncyWorkflowDefinition service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Modifiing service" + reference);
            }

            _serviceReferences.replace(service.getClass().getName(), reference);
        }

        @Override
        public void removedService(ServiceReference<EncyWorkflowDefinition> reference, EncyWorkflowDefinition service) {
            if (_log.isDebugEnabled()) {
                this._log.debug("Removing service" + reference);
            }

            _encyWorkflowLocalService.deactivateWorkflow(service.getClass().getName());
            _serviceReferences.remove(service.getClass().getName());


        }

        private final Log _log = LogFactoryUtil.getLog(EncyWorkflowDefinitionServiceTrackerCustomizer.class);

    }


}