package cz.csob.ency.connection;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.connection.model.impl.ConnectionDefinitionImpl;

import javax.sql.DataSource;

public class DefaultConnection extends NamedConnection {
    public static final String BASE_CONN_NAME = "master";
    private static final Log log = LogFactoryUtil.getLog(DefaultConnection.class);
    private final Boolean closeable = false;

    public DefaultConnection(DataSource ds) throws Exception {
        log.debug("Initializing default connection by DataSource");

        this.ds = ds;
        this.conectionDef = new ConnectionDefinitionImpl();
        this.conectionDef.setName(BASE_CONN_NAME);
        this.conectionDef.setUrl("Liferay managed");
        this.conectionDef.setUsername("");
        this.conectionDef.setPassword("");
    }

    @Override
    public void closeConnection() {
        // default Liferay connection is not closeable
        return;
    }
}
