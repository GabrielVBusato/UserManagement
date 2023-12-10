/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dao;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.UsersModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 *
 * @author Mauricio
 */
public class UsersDao implements IDao<UsersModel> {

    private final IDatabaseConnection connection;

    public UsersDao(IDatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "Delete from users where id = '" + id + "'";
        connection.connect();
        connection.createStatement().executeUpdate(query);
        connection.disconnect();
    }

    @Override
    public int create(UsersModel user) throws SQLException {
        String valuesFormat = String.format(Locale.US, "('%s', '%s', '%s', '%s', '%s')", user.getName(), user.getPassword(), user.getType(), user.getAuthorized(), user.getCreatedAt());
        String query = "INSERT INTO users (name, password, type, authorized, created_at) VALUES "
                + valuesFormat;
        connection.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        ResultSet rs = statement.executeQuery("SELECT MAX(id) as last_id from users");
        int id = rs.getInt("last_id");
        connection.disconnect();
        return id;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return this.databaseQuery("SELECT u.id, u.name, u.type, u.authorized, u.created_at, "
                + "COUNT(n.id) AS total_notifications, "
                + "SUM(CASE WHEN n.read = 1 THEN 1 ELSE 0 END) AS read_notifications, "
                + "SUM(CASE WHEN n.read = 0 THEN 1 ELSE 0 END) AS unread_notifications "
                + "FROM users u "
                + "LEFT JOIN notifications n ON u.id = n.user_id "
                + "WHERE type = 'User'"
                + "GROUP BY u.id, u.name, u.type, u.authorized, u.created_at"
        );
    }

    public ResultSet getAllUnauthorized() throws SQLException {
        return this.databaseQuery("SELECT u.id, u.name, u.type, u.authorized, u.created_at, "
                + "COUNT(n.id) AS total_notifications, "
                + "SUM(CASE WHEN n.read = 1 THEN 1 ELSE 0 END) AS read_notifications, "
                + "SUM(CASE WHEN n.read = 0 THEN 1 ELSE 0 END) AS unread_notifications "
                + "FROM users u "
                + "LEFT JOIN notifications n ON u.id = n.user_id "
                + "WHERE u.authorized = 0 "
                + "AND WHERE type = 'User'"
                + "GROUP BY u.id, u.name, u.type, u.authorized, u.created_at"
        );
    }

    @Override
    public ResultSet read(int id) throws SQLException {
        return this.databaseQuery("Select * from users where id = '" + id + "'");
    }

    public ResultSet readByUsername(String username) throws SQLException {
        return this.databaseQuery("Select * from users where name = '" + username + "'");
    }

    private ResultSet databaseQuery(String query) throws SQLException {
        ResultSet result;
        Statement statement;
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    @Override
    public void update(UsersModel user) throws SQLException {
        String updateQuery = "UPDATE users SET name = '" + user.getName() + "', password = '" + user.getPassword() + "', authorized = "
                + user.getAuthorized() + ", created_at = '" + user.getCreatedAt() + "' where id = '" + user.getId() + "'";
        connection.connect();
        connection.createStatement().executeUpdate(updateQuery);
        connection.disconnect();
    }
}
