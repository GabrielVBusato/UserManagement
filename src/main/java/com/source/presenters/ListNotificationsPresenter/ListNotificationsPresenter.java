/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.ListNotificationsPresenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.NotificationsModel;
import com.source.service.NotificationsService.NotificationsService;
import com.source.session.UserSession;
import com.source.view.ListNotificationsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauricio
 */
public class ListNotificationsPresenter {

    private static ListNotificationsView view = null;
    private static ListNotificationsPresenter instance = null;
    private final IDatabaseConnection connection;
    private static NotificationsService service;

    private ListNotificationsPresenter(IDatabaseConnection connection) {
        if (view == null) {
            view = new ListNotificationsView();
        }
        this.connection = connection;
        this.service = new NotificationsService(connection);
    }

    public IDatabaseConnection getConnection() {
        return this.connection;
    }

    public static ListNotificationsPresenter getInstance(IDatabaseConnection connection) {
        if (instance == null) {
            instance = new ListNotificationsPresenter(connection);
        }
        initComponents();
        view.setVisible(true);
        return instance;
    }
    
    private static void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnMarkAsRead().getActionListeners()) {
            view.getBtnMarkAsRead().removeActionListener(al);
        }
    }
    
    private static void setModelTable() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        List<NotificationsModel> notifications = service.listAllUserNotifications(UserSession.getInstance().getCurrentUser().getId());
        for(NotificationsModel notification : notifications) {
            String read = notification.getRead() == 1 ? "Sim" : "Não";
            Object[] rowData = {notification.getId(), notification.getNotification(), read};
            tableModel.addRow(rowData);
        }
    }
    
    private static int getSelectedRowValue() {
        int row = view.getTblSearch().getSelectedRow();
        
        return Integer.parseInt(view.getTblSearch().getModel().getValueAt(row, 0).toString());
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
        view.getBtnMarkAsRead().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int notificationId = getSelectedRowValue();
                service.markAsReadNotification(notificationId);
                int totalUnreadUserNotifications = service.totalUnreadUserNotifications(UserSession.getInstance().getCurrentUser().getId());
                UserSession.getInstance().setUserUnreadNotifications(totalUnreadUserNotifications);
                view.dispose();
            }
        });
    }
}
