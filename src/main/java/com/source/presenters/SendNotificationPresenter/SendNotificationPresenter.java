/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.SendNotificationPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.NotificationsModel;
import com.source.model.UsersModel;
import com.source.service.NotificationsService.NotificationsService;
import com.source.service.UserService.UsersService;
import com.source.view.SendNotificationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public class SendNotificationPresenter {

    private static SendNotificationView view = null;
    private static SendNotificationPresenter instance = null;
    private final IDatabaseConnection connection;
    private static UsersService service;
    private static NotificationsService notificationService;

    private SendNotificationPresenter(IDatabaseConnection connection,
            UsersService service) {
        if (view == null) {
            view = new SendNotificationView();
        }
        this.connection = connection;
        SendNotificationPresenter.service = service;
        SendNotificationPresenter.notificationService = new NotificationsService(connection);
    }

    public IDatabaseConnection getConnection() {
        return this.connection;
    }

    public static SendNotificationPresenter getInstance(
            IDatabaseConnection connection,
            UsersService service) {
        if (instance == null) {
            instance = new SendNotificationPresenter(connection, service);
        }
        initComponents();
        view.setVisible(true);
        return instance;
    }

    private static int[] getSelectedRowsValue() {
        return view.getTblSearch().getSelectedRows();
    }

    private static void setModelTable() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        List<UsersModel> users = service.listAllUsers();
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
        for (ActionListener al : view.getBtnSendNotification().getActionListeners()) {
            view.getBtnSendNotification().removeActionListener(al);
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
        view.getBtnSendNotification().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = getSelectedRowsValue();
                if ("".equals(view.getTxtAreaMessage().getText()) || selectedRows.length == 0) {

                    JOptionPane.showMessageDialog(null, "Verifique se preencheu corretamente o "
                            + "campo de notificação, ou selecionou pelo menos um usuário.",
                            "Erro ao enviar notificação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (int row = 0; row < selectedRows.length; row++) {
                    int value = Integer.parseInt(view.getTblSearch().getModel().getValueAt(row, 0).toString());
                    NotificationsModel notification = new NotificationsModel();
                    notification.setUserId(value);
                    notification.setNotification(view.getTxtAreaMessage().getText());
                    notificationService.sendNotification(notification);
                }
            }
        });
    }
}
