/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.SearchUserPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.service.UserService.UsersService;
import com.source.view.SearchUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public class SearchUserPresenter {

    private static SearchUserView view = null;
    private static SearchUserPresenter instance = null;
    private static IDatabaseConnection connection;
    private static UsersService service;

    private SearchUserPresenter(IDatabaseConnection connection,
            UsersService service) {
        if (view == null) {
            view = new SearchUserView();
        }
        SearchUserPresenter.connection = connection;
        SearchUserPresenter.service = service;
    }

    public IDatabaseConnection getConnection() {
        return SearchUserPresenter.connection;
    }

    public static SearchUserPresenter getInstance(
            IDatabaseConnection connection,
            UsersService service) {
        if (instance == null) {
            instance = new SearchUserPresenter(connection, service);
        }
        initComponents();
        view.setVisible(true);
        return instance;
    }

    private static String getSelectedRowValue(int column) {
        int row = view.getTblSearch().getSelectedRow();
        if (row != -1) {

            return view.getTblSearch().getModel().getValueAt(row, column).toString();
        }
        return null;
    }

    private static void setModelTable() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        List<UsersModel> users = service.listAllUsers();
        for (UsersModel user : users) {
            Object[] rowData = {user.getId(), user.getName(), user.getType(),
                user.getUnreadNotifications(), user.getReadNotifications(), user.getAuthorized()};
            tableModel.addRow(rowData);
        }
    }

    private static void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        for (ActionListener al : view.getBtnNewUser().getActionListeners()) {
            view.getBtnNewUser().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnViewUser().getActionListeners()) {
            view.getBtnViewUser().removeActionListener(al);
        }
    }

    private static void initComponents() {
        clearScreen();
        setModelTable();

        view.getTblSearch().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setModelTable();
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        view.getBtnNewUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManagementPresenter.getInstance(connection, service, null);
            }
        });

        view.getBtnViewUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSelectedRowValue(1) != null) {
                    UsersModel user = service.findUserByUsername(getSelectedRowValue(1));
                    UserManagementPresenter.getInstance(connection, service, user);
                }
            }
        });
    }
}
