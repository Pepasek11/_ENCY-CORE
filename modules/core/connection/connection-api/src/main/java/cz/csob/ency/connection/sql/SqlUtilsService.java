package cz.csob.ency.connection.sql;

import aQute.bnd.annotation.ProviderType;
import cz.csob.ency.connection.exception.ConnectionDefinitionException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@ProviderType
public interface SqlUtilsService {
    Transaction getTransactionOnMaster() throws SQLException, ConnectionDefinitionException;

    Transaction getTransaction(final String connName) throws SQLException, ConnectionDefinitionException;

    List<Map<String, Object>> executeSelectOnMaster(final String sql, final Object... args);

    List<Map<String, Object>> executeSelect(final String connName, final String sql, final Object... args);

    List<Map<String, Object>> executeSelect(final Transaction transaction, final String sql, final Object... args);

    int executeUpdateOnMaster(final String sql, final Object... args);

    int executeUpdate(String connName, String sql, Object... args);

    int executeUpdate(final Transaction transaction, final String sql, final Object... args);
}
