/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.repository;

import com.source.dao.NotificationsDao;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.NotificationsModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class NotificationsRepository {

    private final NotificationsDao notificationsDao;
    private final IDatabaseConnection connection;

    public NotificationsRepository(IDatabaseConnection connection) {
        notificationsDao = new NotificationsDao(connection);
        this.connection = connection;
    }

    public NotificationsModel craeteNotification(NotificationsModel notification) throws SQLException {
        notificationsDao.create(notification);

        return notification;
    }

    public List<NotificationsModel> listAllUserNotifications(int id) throws SQLException {
        ResultSet result = notificationsDao.getAllById(id);

        return this.formatNotifications(result);
    }

    public List<NotificationsModel> listAllUnreadUserNotifications(int id) throws SQLException {
        ResultSet result = notificationsDao.getAllUnread(id);

        return this.formatNotifications(result);
    }

    private List<NotificationsModel> formatNotifications(ResultSet result) throws SQLException {
        List<NotificationsModel> notifications = new ArrayList<>();

        while (result.next()) {
            NotificationsModel notification = new NotificationsModel();
            notification.parseData(result);

            notifications.add(notification);
        }

        return notifications;
    }

    public void markAsReadNotification(int id) throws SQLException {
        notificationsDao.markAsRead(id);
    }

    public int totalUnreadNotifications(int userId) throws SQLException {
        return notificationsDao.totalUnreadNotifications(userId);
    }
}
