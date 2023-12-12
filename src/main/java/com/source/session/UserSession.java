/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.session;

import com.source.model.UsersModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author busat
 */
public class UserSession {

    private static UserSession instance;
    private UsersModel currentUser;
    private List<UserSessionObserver> observers = new ArrayList<>();

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
     private void notifyObserversOnUpdateUnreadNotifications(int totalUnreadUserNotifications) {
        for (UserSessionObserver observer : observers) {
            observer.onUpdateUnreadNotifications(totalUnreadUserNotifications);
        }
    }

    public void addObserver(UserSessionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UserSessionObserver observer) {
        observers.remove(observer);
    }

    public void loginUser(UsersModel user) {
        currentUser = user;
    }

    public void logoutUser() {
        currentUser = null;
    }

    public UsersModel getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public void setUserUnreadNotifications(int unread){
        this.currentUser.setUnreadNotifications(unread);
        notifyObserversOnUpdateUnreadNotifications(unread);
    }
}
