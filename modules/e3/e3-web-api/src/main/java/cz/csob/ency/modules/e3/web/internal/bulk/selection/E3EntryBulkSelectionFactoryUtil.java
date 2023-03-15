package cz.csob.ency.modules.e3.web.internal.bulk.selection;

import com.liferay.bulk.selection.BulkSelection;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Map;

public class E3EntryBulkSelectionFactoryUtil {

    private static final ServiceTracker<E3EntryBulkSelectionFactory, E3EntryBulkSelectionFactory>
            _serviceTracker;

    public static BulkSelection<E3Entry> create(
            Map<String, String[]> parameterMap) {
        return getE3EntryBulkSelectionFactory().create(parameterMap);
    }

    public static E3EntryBulkSelectionFactory getE3EntryBulkSelectionFactory() {
        return _serviceTracker.getService();
    }

    static {
        Bundle bundle = FrameworkUtil.getBundle(E3EntryBulkSelectionFactory.class);

        ServiceTracker<E3EntryBulkSelectionFactory, E3EntryBulkSelectionFactory>
                serviceTracker = new ServiceTracker<E3EntryBulkSelectionFactory, E3EntryBulkSelectionFactory>(
                bundle.getBundleContext(), E3EntryBulkSelectionFactory.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }
/*

    public static E3EntryBulkSelectionFactory getE3EntryBulkSelectionFactory() {
        return _service;
    }

    private static volatile E3EntryBulkSelectionFactory _service;
/***/
}