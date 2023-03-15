package cz.csob.ency.connection;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.connection.engine.DatabaseEngine;
import cz.csob.ency.connection.model.ConnectionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class NamedConnection {
    private static final Log log = LogFactoryUtil.getLog(NamedConnection.class);

    public void closeConnection() throws Exception {
        DataSourceFactoryUtil.destroyDataSource(this.ds);
        this.ds = null;
        this.conectionDef = null;
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    public DatabaseEngine getDatabaseEngine() {
        return this.databaseEngine;
    }

    public String getDatabaseName() {
        return this.conectionDef.getDatabaseName();
    }

    public String getDriver() {
        return this.conectionDef.getDriver();
    }

    public String getDriverClass() {
        return this.databaseEngine.getDriverClass();
    }

    public String getJdbcUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDriver())
                .append("://")
                .append(conectionDef.getServerAddress())
                .append(":")
                .append(conectionDef.getServerPort())
                .append(";");
        if(!Validator.isBlank(conectionDef.getDatabaseName())) {
            sb.append("databaseName=").append(conectionDef.getDatabaseName()).append(";");
        }
        if (isIntegratedSecurity()) {
            sb.append("integratedSecurity=true;");
        }else{
            sb.append("user=").append(conectionDef.getUsername()).append(";");
            sb.append("password=").append(conectionDef.getPassword()).append(";");
        }
        if(!Validator.isBlank(conectionDef.getAdditionalParams())) {
            sb.append(conectionDef.getAdditionalParams()).append(";");
        }
        return sb.toString();
    }

    public String getName() {
        return this.conectionDef.getName();
    }

    public String getServerAddress() {
        return this.conectionDef.getServerAddress();
    }

    public String getServerPort() {
        return this.conectionDef.getServerPort();
    }

    public Boolean isIntegratedSecurity() {
        return this.conectionDef.getIntegratedSecurity();
    }

    public boolean isOpen() {
        try {
            return !this.ds.getConnection().isClosed();
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Connection{" +
                "ConnectionDef=" + this.conectionDef +
                ", Source status=" + (this.ds != null ? "Initialized" : "uninitialized") +
                '}';
    }
    protected ConnectionDefinition conectionDef;
    protected DatabaseEngine databaseEngine;
    protected String driverClass;
    protected DataSource ds;
}