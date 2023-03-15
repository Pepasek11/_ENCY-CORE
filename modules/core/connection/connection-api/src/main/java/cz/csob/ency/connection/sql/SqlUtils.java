package cz.csob.ency.connection.sql;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.connection.exception.ConnectionDefinitionException;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SqlUtils {
    private static final Log log = LogFactoryUtil.getLog(SqlUtils.class);
    private static final ServiceTracker
            <SqlUtilsService, SqlUtilsService>
            _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(
                SqlUtilsService.class);

        ServiceTracker
                <SqlUtilsService, SqlUtilsService>
                serviceTracker =
                new ServiceTracker
                        <SqlUtilsService,
                                SqlUtilsService>(
                        bundle.getBundleContext(),
                        SqlUtilsService.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }

    public static Transaction getTransactionOnMaster() throws SQLException, ConnectionDefinitionException {
        return getService().getTransactionOnMaster();
    }

    public static Transaction getTransaction(final String connName) throws SQLException, ConnectionDefinitionException {
        return getService().getTransaction(connName);
    }

    public static List<Map<String, Object>> executeSelectOnMaster(final String sql, final Object... args) {
        return getService().executeSelectOnMaster(sql, args);
    }

    public static List<Map<String, Object>> executeSelect(final String connName, final String sql, final Object... args) {
        return getService().executeSelect(connName, sql, args);
    }
    public static List<Map<String, Object>> executeSelect(final Transaction transaction, final String sql, final Object... args) {
        return getService().executeSelect(transaction, sql, args);
    }

    public static int executeUpdateOnMaster(final String sql, final Object... args) {
        return getService().executeUpdateOnMaster(sql, args);
    }

    public static int executeUpdate(final String connName, final String sql, final Object... args) {
        return getService().executeUpdate(connName, sql, args);
    }
    public static int executeUpdate(final Transaction transaction, final String sql, final Object... args) {
        return getService().executeUpdate(transaction, sql, args);
    }

    public static SqlUtilsService getService() {
        return _serviceTracker.getService();
    }
}
