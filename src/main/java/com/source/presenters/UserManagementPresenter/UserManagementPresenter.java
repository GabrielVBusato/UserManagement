/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.states.ManageUserState;
import com.source.presenters.UserManagementPresenter.states.ReadState;
import com.source.service.UserService.UsersService;
import com.source.view.UserManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author busat
 */
public class UserManagementPresenter {

    private static UserManagementView view = null;
    private static UserManagementPresenter instance = null;
    private final UsersService userService;
    private final IDatabaseConnection connection;
    private static UserManagementState state;
    private static UsersModel user;

    private UserManagementPresenter(IDatabaseConnection connection,
            UsersService userService) {
        if (view == null) {
            view = new UserManagementView();
        }
        this.connection = connection;
        this.userService = userService;
    }

    public static UserManagementPresenter getInstance(
            IDatabaseConnection connection,
            UsersService userService,
            UsersModel user) {
        if (instance == null) {
            instance = new UserManagementPresenter(connection, userService);
        }
        UserManagementPresenter.user = user;
        if (user != null) {
            UserManagementPresenter.user = user;
            UserManagementPresenter.state = new ReadState(instance);
        } else {
            UserManagementPresenter.state = new ManageUserState(instance);
        }
        view.setVisible(true);
        return instance;
    }

    public UsersService getUserService() {
        return this.userService;
    }

    public UsersModel getUser() {
        return UserManagementPresenter.user;
    }

    public void setUser(UsersModel user) {
        UserManagementPresenter.user = user;
    }

    public void setState(UserManagementState state) {
        UserManagementPresenter.state = state;
    }

    public UserManagementView getView() {
        return view;
    }

    public IDatabaseConnection getConnection() {
        return connection;
    }

    public void clearScreen() {
        UserManagementPresenter.view.getTxtName().setText("");
    }

    public void initComponents() {

        if (user != null && "".equals(view.getTxtName().getText())) {
            view.getTxtName().setText(user.getName());
        }
        
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                clearScreen();
            }
        });

        view.getBtnSalvar()
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        state.onSave();
                    }
                }
                );

        view.getBtnClose()
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        state.onClose();
                    }
                }
                );

        view.getBtnEdit()
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        state.onEdit();
                    }
                }
                );

        view.getBtnDelete()
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        state.onDelete();
                    }
                }
                );

        view.getBtnCancelar()
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        state.onCancel();
                    }
                }
                );
    }
}
