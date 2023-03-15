package cz.csob.ency.connection;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.connection.engine.DatabaseEngine;
import cz.csob.ency.connection.model.ConnectionDefinition;

public class DefinedConnection extends NamedConnection {
    private static final Log log = LogFactoryUtil.getLog(DefinedConnection.class);

    public DefinedConnection(ConnectionDefinition connDef) throws Exception {
        log.debug("Initializing by definition");
        this.conectionDef = connDef;
        this.databaseEngine = DatabaseEngine.fromJdbcUrl(connDef.getDriver());

        try {
            this.ds = DataSourceFactoryUtil.initDataSource(
                    this.getDriverClass(),
                    getJdbcUrl(),
                    connDef.getUsername(),
                    connDef.getPassword(),
                    ""
            );
        } catch (ClassNotFoundException e) {
            log.error("Driver " + this.getDriverClass() + " from url " + this.getJdbcUrl() +
                    " not found. Add driver to initialize connection.");
            throw e;
        }

        log.debug(String.format("Connection initialized {}", this));
    }
}