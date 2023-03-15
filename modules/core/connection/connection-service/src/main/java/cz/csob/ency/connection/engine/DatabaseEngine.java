package cz.csob.ency.connection.engine;

//@todo: refactor to the API
//@todo: add postgress
public enum DatabaseEngine /* implements KarelTranslated */{
    MYSQL {
        public String getDriverClass() {
            return "org.mariadb.jdbc.Driver";
        }
    },
    H2 {
        public String getDriverClass() {
            return "org.h2.Driver";
        }
    },
    ACCESS {
        public String getDriverClass() {
            return "net.ucanaccess.jdbc.UcanaccessDriver";
        }
    },
    DERBY {
        public String getDriverClass() {
            return "org.apache.derby.jdbc.ClientDriver";
        }
    },
    ORACLE {
        public String getDriverClass() {
            return "oracle.jdbc.OracleDriver";
        }
    },
    MSSQL {
        public String getDriverClass() {
            return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
    },
    TERADATA {
        public String getDriverClass() {
            return "com.teradata.jdbc.TeraDriver";
        }
    };

    private DatabaseEngine() {
    }

    public static DatabaseEngine fromJdbcUrl(String jdbcUrl) throws Exception {
        if (jdbcUrl.startsWith("jdbc:mysql:")) {
            return MYSQL;
        } else if (jdbcUrl.startsWith("jdbc:h2:")) {
            return H2;
        } else if (jdbcUrl.startsWith("jdbc:ucanaccess:")) {
            return ACCESS;
        } else if (jdbcUrl.startsWith("jdbc:oracle:")) {
            return ORACLE;
        } else if (jdbcUrl.startsWith("jdbc:derby:")) {
            return DERBY;
        } else if (jdbcUrl.startsWith("jdbc:sqlserver")) {
            return MSSQL;
        } else if (jdbcUrl.startsWith("jdbc:teradata:")) {
            return TERADATA;
        } else {
            //@todo  throw new XformsDataException(ManagerFactory.getInstance().getXformsI18nService().tr("No support for the underlying db engine: {0}", new Object[]{jdbcUrl}));
            throw new Exception("No support for the underlying db engine: "+jdbcUrl);
        }
    }

    public abstract String getDriverClass();
}

