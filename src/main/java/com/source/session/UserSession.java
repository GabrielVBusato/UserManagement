/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.session;

import com.source.model.UsersModel;

/**
 *
 * @author busat
 */
public class UserSession {
    private static UserSession instance;
    private UsersModel currentUser;  // Suponha que você tenha uma classe User para representar os dados do usuário

    private UserSession() {
        // Construtor privado para evitar instâncias externas
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
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
}
