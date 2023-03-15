package cz.csob.ency.scheduler.messaging.destination;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.util.HashMapDictionary;
import cz.csob.ency.scheduler.constants.SchedulerConstants;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Component(
    immediate = true,
    service = EncyMessagingConfiguration.class
)
public class EncyMessagingConfiguration {
   private static final Log _log = LogFactoryUtil.getLog(EncyMessagingConfiguration.class);
    private static final int _MAXIMUM_QUEUE_SIZE = 50;
    private final Map<String, ServiceRegistration<Destination>>
        _serviceRegistrations = new HashMap<>();
    @Reference
    private DestinationFactory _destinationFactory;

    private BundleContext _bundleContext;

    @Activate
    protected void activate(BundleContext bundleContext) {
        // Create a DestinationConfiguration for parallel destinations.
        _bundleContext = bundleContext;

        DestinationConfiguration destinationConfiguration =
            new DestinationConfiguration(
                DestinationConfiguration.DESTINATION_TYPE_PARALLEL,
                SchedulerConstants.DYNAMIC_SCHEDULER_DESTINATION
            );

        // Set the DestinationConfiguration's max queue size and
        // rejected execution handler.

        destinationConfiguration.setMaximumQueueSize(_MAXIMUM_QUEUE_SIZE);

        // Create the destination

        Destination destination = _destinationFactory.createDestination(
            destinationConfiguration);

        // Add the destination to the OSGi service registry

        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("destination.name", destination.getName());

        ServiceRegistration<Destination> serviceRegistration =
            _bundleContext.registerService(
                Destination.class, destination, properties);

        // Track references to the destination service registrations

        _serviceRegistrations.put(destination.getName(),
            serviceRegistration);
    }

    @Deactivate
    protected void deactivate() {

        // Unregister and destroy destinations this component unregistered

        for (ServiceRegistration<Destination> serviceRegistration :
            _serviceRegistrations.values()) {

            Destination destination = _bundleContext.getService(
                serviceRegistration.getReference());

            serviceRegistration.unregister();

            destination.destroy();

        }

        _serviceRegistrations.clear();
    }
}