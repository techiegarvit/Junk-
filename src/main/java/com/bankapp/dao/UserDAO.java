package com.bankapp.dao;

import com.bankapp.model.User;
import java.sql.*;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/OnlineBankingSystem";
    private String jdbcUserName = "root";
    private String jdbcPassword = "root";
    private Connection jdbcConnection;

    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    private void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Users WHERE username = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
        }

        rs.close();
        statement.close();
        disconnect();
        return user;
    }

    public boolean validateUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        boolean isValid = rs.next();

        rs.close();
        statement.close();
        disconnect();
        return isValid;
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO Users (username, password, email, role) VALUES (?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getRole());
        statement.executeUpdate();

        statement.close();
        disconnect();
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE Users SET password = ?, email = ?, role = ? WHERE username = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(query);
        statement.setString(1, user.getPassword());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getRole());
        statement.setString(4, user.getUsername());
        statement.executeUpdate();

        statement.close();
        disconnect();
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM Users WHERE username = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(query);
        statement.setString(1, username);
        statement.executeUpdate();

        statement.close();
        disconnect();
    }
}
