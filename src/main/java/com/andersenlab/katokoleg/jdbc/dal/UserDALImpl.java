package com.andersenlab.katokoleg.jdbc.dal;

import com.andersenlab.katokoleg.jdbc.dal.data_source.DataSource;
import com.andersenlab.katokoleg.jdbc.entity.User;
import com.andersenlab.katokoleg.jdbc.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDALImpl implements UserDAL {

    private static final String GET_ALL_USER_ROLES = "SELECT r.name FROM users_has_roles ur JOIN roles r ON ur.role_id = r.id WHERE ur.user_id = ?";
    private static final String GET_ALL_ROLE_USERS = "SELECT * FROM users u JOIN users_has_roles ur ON u.id = ur.user_id WHERE role_id = ?";
    private final DataSource dataSource;

    public UserDALImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getRoleUsers(long roleID) {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROLE_USERS)) {
            preparedStatement.setLong(1, roleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    User user = new User(login, password);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<UserRole> getUserRoles(long userID) {
        List<UserRole> roles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER_ROLES)) {
            preparedStatement.setLong(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    UserRole role = Enum.valueOf(UserRole.class, resultSet.getString("name"));
                    roles.add(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
