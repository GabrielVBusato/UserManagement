/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mauricio
 */
public class NotificationsModel {

    private int id;
    private int userId;
    private String notification;
    private int read;

    public NotificationsModel() {
        this.read = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "NotificationsModel{userId=" + userId + ", notification=" + notification + ", read=" + read + '}';
    }
    
    public void parseData(ResultSet result) throws SQLException {
        this.setId(result.getInt("id"));
        this.setNotification(result.getString("notification"));
        this.setRead(result.getInt("read"));
        this.setId(result.getInt("id"));
    }
}
