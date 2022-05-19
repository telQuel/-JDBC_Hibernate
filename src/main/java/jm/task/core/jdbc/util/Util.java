package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";

        String dbName = "ex_jdbc";
        String userName = "****";
        String password = "****";

        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection connection = DriverManager.getConnection(connectionURL, userName,
                password);
        connection.setAutoCommit(true);

        return connection;
    }
}
