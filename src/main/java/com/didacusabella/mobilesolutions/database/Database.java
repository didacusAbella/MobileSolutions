package com.didacusabella.mobilesolutions.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author Domenico Antonio Tropeano on 14/02/2018 at 11:06
 * @project MobileSolutions
 */
public class Database {private static String protocol;
    private static String hostname;
    private static String port;
    private static String username;
    private static String password;
    private static String dbName;
    private static Properties userInfo;
    private static String mySqlUrl;
    private static List<Connection> freeDbConnections;
    static final String driver = "com.mysql.cj.jdbc.Driver";
    // private static final boolean DEBUG = false;
    private static final boolean LOCAL = false;

    static {
        protocol = "jdbc:mysql://";

        if (LOCAL) {
            hostname = "localhost:";
            port = "3306/";
            dbName = "mobilesolutions";
            mySqlUrl = protocol + hostname + port + dbName;
            username = "root";
            password = "root";
            userInfo = new Properties();
            userInfo.put("user", username);
            userInfo.put("password", password);

        } else {
            hostname = "mysql1.gear.host:";
            port = "3306/";
            dbName = "mobilesolutions";
            mySqlUrl = protocol + hostname + port + dbName;

            /**********************************/
            username = "mobilesolutions";
            password = "P@ssw0rd";
            userInfo = new Properties();
            userInfo.put("user", username);
            userInfo.put("password", password);
        }

        freeDbConnections = new LinkedList<Connection>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found:" + e.getMessage());
        }
    }

    /**
     * Inizializza le connessioni
     *
     * @return
     * @throws SQLException
     * @author Tropeano Domenico Antonio & Diego Avella
     */

    private static synchronized Connection createDBConnection() throws SQLException {

        Connection newConnection = null;
        newConnection = DriverManager.getConnection(mySqlUrl, userInfo);
        newConnection.setAutoCommit(false);
        return newConnection;
    }

    /**
     * Fornisce una connessione al database
     *
     * @return
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        Connection connection;

        if (!freeDbConnections.isEmpty()) {
            connection = (Connection) freeDbConnections.get(0);
            freeDbConnections.remove(0);

            try {
                if (connection.isClosed())
                    connection = getConnection();
            } catch (SQLException e) {
                connection.close();
                connection = getConnection();
            }
        } else {
            connection = createDBConnection();
        }

        return connection;
    }

    /**
     * Rilascia la connessione
     *
     * @param connection
     *            rappresenta la connessione rilasciata e ri-aggiunta al pool di
     *            connessioni.
     * @author Tropeano Domenico Antonio & Diego Avella
     */

    public static synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null)
            freeDbConnections.add(connection);
    }
}