package cz.csob.ency.connection.internal.sql;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.connection.ConnectionFactory;
import cz.csob.ency.connection.DefaultConnection;
import cz.csob.ency.connection.exception.ConnectionDefinitionException;
import cz.csob.ency.connection.sql.SqlUtilsService;
import cz.csob.ency.connection.sql.Transaction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.*;

@Component(
        service = SqlUtilsService.class, immediate = true
)
public class SqlUtilsServiceImpl implements SqlUtilsService {

    private final Log log = LogFactoryUtil.getLog(SqlUtilsServiceImpl.class);

    @Reference
    private ConnectionFactory connectionFactory;

    public Transaction getTransactionOnMaster() throws SQLException, ConnectionDefinitionException {
        return getTransaction(DefaultConnection.BASE_CONN_NAME);
    }

    @Override
    public Transaction getTransaction(final String connName) throws SQLException, ConnectionDefinitionException {
        // Get connection
        final Connection conn = connectionFactory.getConnection(connName);
        return new Transaction(conn);
    }

    @Override
    public List<Map<String, Object>> executeSelectOnMaster(final String sql, final Object... args) {
        return executeSelect(DefaultConnection.BASE_CONN_NAME, sql, args);
    }

    @Override
    public List<Map<String, Object>> executeSelect(final Transaction transaction, final String sql, final Object... args) {
        return executeSelect(transaction.connection(), sql, args);
    }

    @Override
    public List<Map<String, Object>> executeSelect(final String connName, final String sql, final Object... args) {
        Connection conn = null;
        try {
            conn = connectionFactory.getConnection(connName);
            List<Map<String, Object>> result = executeSelect(conn, sql, args);
            conn.close();
            return result;
        } catch (SQLException e) {
            log.error("Error when executing statement.", e);
            return Collections.EMPTY_LIST;
        } catch (Throwable e) {
            log.error("Error when executing statement.", e);
            return Collections.EMPTY_LIST;
        }

    }

    private List<Map<String, Object>> executeSelect(final Connection conn, final String sql, final Object... args) {
        try {
            if(conn == null || conn.isClosed()) {
                return Collections.EMPTY_LIST;
            }
        } catch (SQLException throwables) {
            return Collections.EMPTY_LIST;
        }

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try (
                // Prepare statement
                final PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            // Set sql arguments
            for (int i = 1; i <= args.length; i++) {
                ps.setObject(i, args[i - 1]);
            }

            ResultSet rs = ps.executeQuery();
            List<String> colNames = new ArrayList<>();

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String name = rs.getMetaData().getColumnName(i);
                if (Validator.isBlank(name)) {
                    name = "Column" + i;
                }
                //  log.info("Column " + name + " type:" + rs.getMetaData().getColumnTypeName(i) + " id " + rs.getMetaData().getColumnType(i));
                colNames.add(name);
            }

            while (rs.next()) {
                HashMap<String, Object> row = new HashMap<>();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    switch (rs.getMetaData().getColumnType(i)) {
                        case Types.TIMESTAMP:
                            java.sql.Timestamp ts = (java.sql.Timestamp) rs.getObject(i);
                            LocalDateTime ldt = null;
                            if (ts != null) {
                                ldt = ts.toLocalDateTime();
                            }
                            row.put(colNames.get(i - 1), ldt);
                            break;
                        default:
                            row.put(colNames.get(i - 1), rs.getObject(i));
                            break;

                    }
                }
                result.add(row);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            log.error("Error when executing statement.", e);
            return Collections.EMPTY_LIST;
        } catch (Throwable e) {
            log.error("Error when executing statement.", e);
            return Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public int executeUpdateOnMaster(final String sql, final Object... args) {
        if (log.isDebugEnabled()) {
            log.debug("Execute update on master.");
        }
        return executeUpdate(DefaultConnection.BASE_CONN_NAME, sql, args);
    }

    @Override
    public int executeUpdate(final String connName, final String sql, final Object... args) {
        Connection conn = null;
        try {
            conn = connectionFactory.getConnection(connName);
            int res = executeUpdate(conn, sql, args);
            conn.close();
            return res;
        } catch (SQLException e) {
            log.error("Error when executing statement.", e);
            return -1;
        } catch (Throwable e) {
            log.error("Error when executing statement.", e);
            return -1;
        }

    }

    @Override
    public int executeUpdate(final Transaction transaction, final String sql, final Object... args) {
        return executeUpdate(transaction.connection(), sql, args);
    }

    private int executeUpdate(final Connection conn, final String sql, final Object... args) {
        try (
                // Prepare statement
                final PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            for (int i = 1; i <= args.length; i++) {
                Object o = args[i - 1];
                    /* todo
                    if (o instanceof MultiLangValue) {
                        o = ((MultiLangValue)o).get();
                    }
                    */
                if (o instanceof Date) {
                    ps.setTimestamp(i, new Timestamp(((Date) o).getTime()));
                } else if (o instanceof LocalDateTime) {
                    ps.setObject(i, o, Types.TIMESTAMP);
                } else if (o instanceof Boolean) {
                    ps.setBoolean(i, (Boolean) o);
                } else {
                    ps.setObject(i, o);
                }
            }
            int res = ps.executeUpdate();
            if (ps.getWarnings() != null) {
                log.warn(ps.getWarnings().toString());
            }
            ps.close();
            return res;
        } catch (Exception e) {
            log.error(e);
            /*
            throw new XformsDataException(this.ki18n().tr("Failed when updating data using sql command\n{0}\nand parameters\n{1}", sql, (args != null) ? Arrays.toString(args) : "--"), e);
            @todo
            */
        }
        return -1;
    }
}
