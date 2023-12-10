/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.AuthenticationPresenter;

import com.logger.helpers.enums.LogTypeEnum;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.exceptions.FailedValidationException;
import com.source.presenters.AuthenticationPresenter.states.AuthenticationState;
import com.source.presenters.AuthenticationPresenter.states.LoginState;
import com.source.service.UserService.UsersService;
import com.source.utils.Logger;
import com.source.view.AuthenticationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public final class AuthenticationPresenter {

    private static AuthenticationView view = null;
    private static AuthenticationPresenter instance = null;
    private AuthenticationState state;
    private final UsersService userService;
    private final IDatabaseConnection connection;

    private AuthenticationPresenter(IDatabaseConnection connection,
            UsersService userService) {
        if (view == null) {
            view = new AuthenticationView();
        }
        this.connection = connection;
        this.userService = userService;
        this.state = new LoginState(this);
    }

    public static AuthenticationPresenter getInstance(
            IDatabaseConnection connection,
            UsersService userService) {
        if (instance == null) {
            instance = new AuthenticationPresenter(connection, userService);
        }
        
        view.setVisible(true);
        return instance;
    }

    public UsersService getUserService() {
        return this.userService;
    }

    public void setState(AuthenticationState state) {
        this.state = state;
    }

    public AuthenticationView getView() {
        return view;
    }
    
    public IDatabaseConnection getConnection() {
        return connection;
    }

    public void onLogin() {
        try {
            state.onLogin();
        } catch (FailedValidationException ex) {
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    "<<no user>>", "LOGIN", ex.getMessage());
        }
    }

    public void onRegister() {
        try {
            state.onRegister();
        } catch (FailedValidationException ex) {
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    "<<no user>>", "Register", ex.getMessage());
        }
    }

    public void initComponents() {
        view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });

        view.getBtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        });
    }

    public void removeListeners() {
        for (ActionListener al : view.getBtnLogin().getActionListeners()) {
            view.getBtnLogin().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnRegister().getActionListeners()) {
            view.getBtnRegister().removeActionListener(al);
        }
    }
}
