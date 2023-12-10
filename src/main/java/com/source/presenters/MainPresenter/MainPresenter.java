/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.UsersModel;
import com.source.presenters.ConfigPresenter.ConfigPresenter;
import com.source.presenters.UnauthenticatedUsersPresenter.UnauthenticatedUsersPresenter;
import com.source.service.UserService.UsersService;
import com.source.session.UserSession;
import com.source.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public class MainPresenter {

    private static MainView view = null;
    private static MainPresenter instance = null;
    private final IDatabaseConnection connection;
    private MainStrategy strategy;
    private final UsersService userService;

    private MainPresenter(IDatabaseConnection connection,
            UsersService userService) {
        if (view == null) {
            view = new MainView();
        }
        this.userService = userService;
        this.connection = connection;
        initComponents();
    }

    public IDatabaseConnection getConnection() {
        return this.connection;
    }

    public UsersService getUserService() {
        return this.userService;
    }

    public static MainPresenter getInstance(
            IDatabaseConnection connection,
            UsersService userService) {
        if (instance == null) {
            instance = new MainPresenter(connection, userService);
        }

        view.setVisible(true);
        return instance;
    }

    private void initComponents() {
        try {
            view.getBtnConfig().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConfigPresenter.getInstance();
                }
            });
            UsersModel authenticatedUser = UserSession.getInstance().getCurrentUser();
            view.getLblUserType().setText(authenticatedUser.getType());
            view.getLblUserLoggedIn().setText(authenticatedUser.getName());
            this.strategy = MainStrategyFactory.createMainStrategy(UserSession.getInstance()
                    .getCurrentUser().getType());

            strategy.configureMainView(this);
        } catch (Exception ex) {
        }
    }

    public MainView getView() {
        return view;
    }

}
