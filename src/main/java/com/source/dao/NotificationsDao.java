/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dao;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.NotificationsModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 *
 * @author Mauricio
 */
public class NotificationsDao implements IDao<NotificationsModel> {

    private final IDatabaseConnection connection;

    public NotificationsDao(IDatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public int create(NotificationsModel notification) throws SQLException {
        String valuesFormat = String.format(Locale.US, "('%s', '%s', '%s')", notification.getUserId(), notification.getNotification(), notification.getRead());
        String query = "INSERT INTO notifications (user_id, notification, read) VALUES "
                + valuesFormat;
        connection.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        ResultSet rs = statement.executeQuery("SELECT MAX(id) as last_id from notifications");
        int id = rs.getInt("last_id");
        connection.disconnect();
        return id;
    }

    @Override
    public void delete(int notificationId) throws SQLException {
        String query = "Delete from notifications where id = '" + notificationId + "'";
        connection.connect();
        connection.createStatement().executeUpdate(query);
        connection.disconnect();
    }

    public void markAsRead(int notificationId) throws SQLException {
        String updateQuery = "Update notifications SET read = 1 where id = '" + notificationId + "'";
        connection.connect();
        connection.createStatement().executeUpdate(updateQuery);
        connection.disconnect();
    }

    public ResultSet getAllById(int userId) throws SQLException {
        return this.databaseQuery("Select * from notifications where user_id = '" + userId + "'");
    }

    public ResultSet getAllUnread(int userId) throws SQLException {
        return this.databaseQuery("Select * from notifications where user_id = '" + userId + "' and read = 0");
    }
    
    public int totalUnreadNotifications(int userId) throws SQLException {
        ResultSet result = this.databaseQuery("Select count(id) as total from notifications where read = 0");
        
        return result.getInt("total");
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
    public ResultSet read(int notificationId) throws SQLException {
        return this.databaseQuery("Select * from notifications where id = '" + notificationId + "'");
    }

    @Override
    public void update(NotificationsModel notification) throws SQLException {
        String updateQuery = "UPDATE notifications SET notification = '" + notification.getNotification() + "', read = '" + notification.getRead() + "' where id = '" + notification.getId() + "'";
        connection.connect();
        connection.createStatement().executeUpdate(updateQuery);        
        connection.disconnect();
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return this.databaseQuery("Select * from notifications");
    }
}
