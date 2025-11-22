package com.ministore.mini_store.dao;

import com.ministore.mini_store.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User getUserByEmail(String email) throws SQLException {
        String SQL = "SELECT id, username, password_hash, email, created_at FROM app_user WHERE email = ?";

        try (Connection conn = JDBC.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {

            statement.setString(1, email);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password_hash"));
                    user.setEmail(rs.getString("email"));
                    user.setCreated_at(rs.getTimestamp("created_at"));
                    return user;
                }
            }
            return null;

        }
    }

    public void CreateUser(User user) throws SQLException {

        if (getUserByEmail(user.getEmail()) != null) {
            throw new SQLException("L'utilisateur avec cet email existe déjà.");
        }

        String SQL = "INSERT INTO app_user (username, password_hash, email) VALUES (?, ?, ?)";

        try (Connection conn = JDBC.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();

        }

    }
}