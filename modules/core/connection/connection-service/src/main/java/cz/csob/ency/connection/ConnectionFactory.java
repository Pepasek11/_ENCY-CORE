package cz.csob.ency.connection;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import cz.csob.ency.connection.exception.ConnectionUnavailableException;
import cz.csob.ency.connection.exception.NoSuchConnectionDefinitionException;
import cz.csob.ency.connection.model.ConnectionDefinition;
import cz.csob.ency.connection.model.ConnectionDefinitionModel;
import cz.csob.ency.connection.service.ConnectionDefinitionLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component(
        service = {ConnectionFactory.class, ModelListener.class}
)
public class ConnectionFactory extends BaseModelListener<ConnectionDefinition> {
    private static final Log log = LogFactoryUtil.getLog(ConnectionFactory.class);

    public ConnectionFactory() {
        log.debug("Creating connection factory");

    }

    public Connection getConnection(String name) throws SQLException, ConnectionUnavailableException {
        NamedConnection nc = this.getNamedConnection(name);
        if (null == nc) throw new ConnectionUnavailableException("Named connection " + name + " is not available. ");
        return nc.getConnection();
    }

    public Connection getDbConnection() throws SQLException, ConnectionUnavailableException {
        log.debug("Getting main connection");
        return this.getConnection(DefaultConnection.BASE_CONN_NAME);
    }

    public boolean isConnectionOpen(String name) {
        NamedConnection nc = this.getNamedConnection(name, false);
        if (null == nc) {
            return false;
        }

        return nc.isOpen();
    }

    public List<String> listAllConnectionNames() {
        return connectionDefinitionLocalService
                .getConnectionDefinitions(1, connectionDefinitionLocalService.getConnectionDefinitionsCount())
                .stream().map(ConnectionDefinitionModel::getName).collect(Collectors.toList());
    }

    @Override
    public void onBeforeRemove(ConnectionDefinition model) throws ModelListenerException {
        log.info("Handling before remove");
        deactivate(this.getNamedConnection(model.getName()));
        super.onAfterRemove(model);
    }

    @Override
    public void onBeforeUpdate(ConnectionDefinition originalModel, ConnectionDefinition model) throws ModelListenerException {
        log.info("Handling before update");
        deactivate(this.getNamedConnection(model.getName()));
        super.onAfterUpdate(originalModel, model);
    }

    @Deactivate
    protected void deactivate() {
        log.info("Deactivating");
        this.connectionsCache.forEach((s, namedConnection) -> {
            try {
                namedConnection.closeConnection();
            } catch (Exception e) {
                log.error(e);
            }
        });
        this.connectionsCache.clear();
    }

    private void deactivate(NamedConnection namedConnection) {
        if (namedConnection == null) return;
        try {
            this.connectionsCache.remove(namedConnection.getName());
            namedConnection.closeConnection();
        } catch (Exception e) {
            log.error(e);
        }
    }

    private NamedConnection getNamedConnection(String name, boolean create) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("Getting connection [%s]", name));
        }
        if (this.connectionsCache.containsKey(name))
            return this.connectionsCache.get(name);

        if (create) {
            if (log.isDebugEnabled()) {
                log.debug("Connection is not in cache, creating new");
            }

            try {
                if (DefaultConnection.BASE_CONN_NAME.equals(name)) {
                    if (log.isDebugEnabled()) {
                        log.debug("We have base connection");
                    }

                    DefaultConnection conn =
                            new DefaultConnection(
                                    connectionDefinitionLocalService.getBasePersistence().getDataSource()
                            );
                    this.connectionsCache.put(conn.getName(), conn);
                } else {
                    ConnectionDefinition found =
                            connectionDefinitionLocalService.getConnectionDefinition(name);

                    if (found == null) {
                        log.info(String.format("Connection [%s] not found in db defs.", name));
                        throw new NoSuchConnectionDefinitionException(
                                String.format("Connection [%s] is not defined.", name)
                        );
                    }
                    DefinedConnection conn = new DefinedConnection(found);
                    log.info("Connection " + name + " prepared");
                    this.connectionsCache.put(name, conn);
                }
            } catch (Exception e) {
                log.error(e);
                return null;
            }
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Connection is not in cache, do not create new");
            }
            return null;
        }

        return this.connectionsCache.get(name);
    }

    private NamedConnection getNamedConnection(String name) {
        return getNamedConnection(name, true);
    }

    private final Map<String, NamedConnection> connectionsCache = new HashMap();
    @Reference
    protected ConnectionDefinitionLocalService connectionDefinitionLocalService;

}

