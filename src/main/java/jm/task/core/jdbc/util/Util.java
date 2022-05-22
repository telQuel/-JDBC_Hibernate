package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_USER = "****";
    private static final String DB_PASS = "****";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ex_jdbc";

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(DB_URL, DB_USER,
                DB_PASS);
    }

}
