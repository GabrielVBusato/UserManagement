/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.session;

/**
 *
 * @author busat
 */
public interface UserSessionObserver {
    void onUpdateUnreadNotifications(int totalUnreadUserNotifications);
}
