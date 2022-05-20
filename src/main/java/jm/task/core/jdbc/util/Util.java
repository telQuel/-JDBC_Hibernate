package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String userName = "****";
    private static final String password = "****";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/ex_jdbc";

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(connectionURL, userName,
                password);
    }

}
