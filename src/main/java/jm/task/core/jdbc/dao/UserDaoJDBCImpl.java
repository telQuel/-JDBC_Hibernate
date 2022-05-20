package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() throws SQLException, ClassNotFoundException {
    }
    private final Connection connection = Util.getConnection();;

    public void createUsersTable() throws SQLException, ClassNotFoundException {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ex_jdbc.user (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL, age TINYINT NOT NULL);");
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS user");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO ex_jdbc.user (`name`, `lastName`, `age`) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setByte(3, age);
        preparedStatement.executeUpdate();
    }

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
            List<User> list = new java.util.ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getByte(4));
            list.add(user);
        }
        return list;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "TRUNCATE TABLE user";
        statement.executeUpdate(sql);
    }
}
