/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.session.UserSession;
import com.source.view.MainView;

/**
 *
 * @author busat
 */
public class MainPresenter {

    private MainView view = null;
    private static MainPresenter instance = null;
    private final IDatabaseConnection connection;
    private MenuStrategy strategy;

    private MainPresenter(IDatabaseConnection connection) {
        if (view == null) {
            view = new MainView();
        }
        this.connection = connection;
        view.setVisible(true);
        initComponents();
    }

    public static MainPresenter getInstance(
            IDatabaseConnection connection) {
        if (instance == null) {
            instance = new MainPresenter(connection);
        }
        return instance;
    }

    private void initComponents() {
        try {
            this.strategy = MenuStrategyFactory.createMenu(UserSession.getInstance()
                    .getCurrentUser().getType());

            strategy.displayMenu(this);
        } catch (Exception ex) {
        }
    }

    public MainView getView() {
        return view;
    }

}
