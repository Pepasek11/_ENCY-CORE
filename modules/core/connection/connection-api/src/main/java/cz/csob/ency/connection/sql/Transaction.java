package cz.csob.ency.connection.sql;

import java.sql.Connection;
import java.sql.SQLException;

// todo create interface
public class Transaction {
    private Connection _connection;
    
    public Transaction(final Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        this._connection = connection;
    }

    public void commit() throws SQLException {
        _connection.commit();
    }

    public void rollback() throws SQLException {
        _connection.rollback();
    }

    public Connection connection() {
        return this._connection;
    }

    public void close() throws SQLException {
        _connection.close();
    }

    protected void finalize() throws Throwable
    {
        if(_connection != null && !_connection.isClosed()) {
            _connection.close();
        }
        _connection = null;
    }

}
