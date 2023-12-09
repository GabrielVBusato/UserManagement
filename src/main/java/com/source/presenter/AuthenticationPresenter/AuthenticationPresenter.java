/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.AuthenticationPresenter;

import com.logger.business.log.structure.LogDirector;
import com.logger.services.LogService;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.presenter.AuthenticationPresenter.states.AuthenticationState;
import com.source.presenter.AuthenticationPresenter.states.LoginState;
import com.source.view.AuthenticationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public class AuthenticationPresenter {

    private AuthenticationView view = null;
    private static AuthenticationPresenter instance = null;
    private AuthenticationState state;
    private final LogDirector director = new LogDirector("");
    private final LogService logService;
    private final IDatabaseConnection connection;

    private AuthenticationPresenter(LogService logService,
            IDatabaseConnection connection) {
        if (view == null) {
            view = new AuthenticationView();
        }
        this.connection = connection;
        this.logService = logService;
        view.setVisible(true);
        this.state = new LoginState(this);
        initLoginComponents();
    }

    public void setState(AuthenticationState state) {
        this.state = state;
    }

    public static AuthenticationPresenter getInstance(LogService logService,
            IDatabaseConnection connection) {
        if (instance == null) {
            instance = new AuthenticationPresenter(logService, connection);
        }
        return instance;
    }

    public AuthenticationView getView() {
        return view;
    }

    public void onLogin() {
        try {
            state.onLogin();
        } catch (SQLException ex) {
            director.setMessage(ex.getMessage());
            logService.writeExceptionFileLog();

        }
    }

    public void onRegister() {
        try {
            state.onRegister();
        } catch (SQLException ex) {
            director.setMessage(ex.getMessage());
            logService.writeExceptionFileLog();
        }
    }

    private void initLoginComponents() {
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
}
