/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UnauthenticatedUsersPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.UsersModel;
import com.source.service.UserService.UsersService;
import com.source.view.UnauthenticatedUsersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public class UnauthenticatedUsersPresenter {

    private static UnauthenticatedUsersView view = null;
    private static UnauthenticatedUsersPresenter instance = null;
    private final IDatabaseConnection connection;
    private static UsersService service;

    private UnauthenticatedUsersPresenter(IDatabaseConnection connection,
            UsersService service) {
        if (view == null) {
            view = new UnauthenticatedUsersView();
        }
        this.connection = connection;
        UnauthenticatedUsersPresenter.service = service;
    }

    public IDatabaseConnection getConnection() {
        return this.connection;
    }

    public static UnauthenticatedUsersPresenter getInstance(
            IDatabaseConnection connection,
            UsersService service) {
        if (instance == null) {
            instance = new UnauthenticatedUsersPresenter(connection, service);
        }
        initComponents();
        view.setVisible(true);
        return instance;
    }

    private static UsersModel getSelectedRowValue() {
        int row = view.getTblSearch().getSelectedRow();
        UsersModel userToUpdate = service.findUserByUsername(view.getTblSearch().getModel().getValueAt(row, 1).toString());
        return userToUpdate;
    }

    private static void setModelTable() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        List<UsersModel> users = service.listUnauthorizedUsers();
        for (UsersModel user : users) {
            Object[] rowData = {user.getId(), user.getName(), user.getType()};
            tableModel.addRow(rowData);
        }
    }

    private static void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnAuthenticateUser().getActionListeners()) {
            view.getBtnAuthenticateUser().removeActionListener(al);
        }
    }

    private static void initComponents() {
        clearScreen();
        setModelTable();
        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        view.getBtnAuthenticateUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsersModel userToUpdate = getSelectedRowValue();
                userToUpdate.setAuthorized(1);
                service.updateUser(userToUpdate);
                view.dispose();
            }
        });
    }
}
