/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.source.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
 * @author busat
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDummyUserLoggedIn = new javax.swing.JLabel();
        lblUserLoggedIn = new javax.swing.JLabel();
        lblDummyUserType = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        lblDummyNewNotifications = new javax.swing.JLabel();
        btnNewNotifications = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        menuBarMain = new javax.swing.JMenuBar();
        menuUserManagement = new javax.swing.JMenu();
        menuItemListUsers = new javax.swing.JMenuItem();
        menuItemAuthUser = new javax.swing.JMenuItem();
        menuItemChangePassword = new javax.swing.JMenuItem();
        menuNotificationManagement = new javax.swing.JMenu();
        menuItemSendNotification = new javax.swing.JMenuItem();
        menuItemListNotifications = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestão de pessoas");
        setResizable(false);

        lblDummyUserLoggedIn.setText("Usuário Logado: ");

        lblUserLoggedIn.setText("user");

        lblDummyUserType.setText("Tipo:");

        lblUserType.setText("user");

        lblDummyNewNotifications.setText("Novas notificações");

        btnNewNotifications.setText("0");

        btnConfig.setText("Config");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDummyNewNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(btnConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDummyUserLoggedIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserLoggedIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDummyUserType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserType)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDummyUserLoggedIn)
                    .addComponent(lblUserLoggedIn)
                    .addComponent(lblDummyUserType)
                    .addComponent(lblUserType)
                    .addComponent(lblDummyNewNotifications)
                    .addComponent(btnNewNotifications)
                    .addComponent(btnConfig))
                .addContainerGap())
        );

        menuBarMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menuBarMain.setFocusable(false);
        menuBarMain.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        menuUserManagement.setText("Usuários");

        menuItemListUsers.setText("Listar usuários");
        menuUserManagement.add(menuItemListUsers);

        menuItemAuthUser.setText("Autorizar usuário");
        menuUserManagement.add(menuItemAuthUser);

        menuItemChangePassword.setText("Alterar senha");
        menuUserManagement.add(menuItemChangePassword);

        menuBarMain.add(menuUserManagement);

        menuNotificationManagement.setText("Notificação");

        menuItemSendNotification.setText("Enviar notificação");
        menuItemSendNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSendNotificationActionPerformed(evt);
            }
        });
        menuNotificationManagement.add(menuItemSendNotification);

        menuItemListNotifications.setText("Listar notificações");
        menuNotificationManagement.add(menuItemListNotifications);

        menuBarMain.add(menuNotificationManagement);

        setJMenuBar(menuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 316, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSendNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSendNotificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemSendNotificationActionPerformed

    public JLabel getLblDummyNewNotifications() {
        return lblDummyNewNotifications;
    }

    public JLabel getLblDummyUserLoggedIn() {
        return lblDummyUserLoggedIn;
    }

    public JLabel getLblDummyUserType() {
        return lblDummyUserType;
    }

    public JButton getBtnNewNotifications() {
        return btnNewNotifications;
    }

    public JButton getBtnConfig() {
        return btnConfig;
    }

    public JLabel getLblUserLoggedIn() {
        return lblUserLoggedIn;
    }

    public JLabel getLblUserType() {
        return lblUserType;
    }
    
    public JMenuBar getMenuBarMain() {
        return menuBarMain;
    }

    public void setMenuBarMain(JMenuBar menuBarMain) {
        this.menuBarMain = menuBarMain;
    }

    public JMenuItem getMenuItemAuthUser() {
        return menuItemAuthUser;
    }

    public void setMenuItemAuthUser(JMenuItem menuItemAuthUser) {
        this.menuItemAuthUser = menuItemAuthUser;
    }

    public JMenuItem getMenuItemChangePassword() {
        return menuItemChangePassword;
    }

    public void setMenuItemChangePassword(JMenuItem menuItemChangePassword) {
        this.menuItemChangePassword = menuItemChangePassword;
    }

    public JMenuItem getMenuItemListNotifications() {
        return menuItemListNotifications;
    }

    public void setMenuItemListNotifications(JMenuItem menuItemListNotifications) {
        this.menuItemListNotifications = menuItemListNotifications;
    }

    public JMenuItem getMenuItemListUsers() {
        return menuItemListUsers;
    }

    public void setMenuItemListUsers(JMenuItem menuItemListUsers) {
        this.menuItemListUsers = menuItemListUsers;
    }

    public JMenuItem getMenuItemSendNotification() {
        return menuItemSendNotification;
    }

    public void setMenuItemSendNotification(JMenuItem menuItemSendNotification) {
        this.menuItemSendNotification = menuItemSendNotification;
    }

    public JMenu getMenuNotificationManagement() {
        return menuNotificationManagement;
    }

    public void setMenuNotificationManagement(JMenu menuNotificationManagement) {
        this.menuNotificationManagement = menuNotificationManagement;
    }

    public JMenu getMenuUserManagement() {
        return menuUserManagement;
    }

    public void setMenuUserManagement(JMenu menuUserManagement) {
        this.menuUserManagement = menuUserManagement;
    }


  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnNewNotifications;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDummyNewNotifications;
    private javax.swing.JLabel lblDummyUserLoggedIn;
    private javax.swing.JLabel lblDummyUserType;
    private javax.swing.JLabel lblUserLoggedIn;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JMenuBar menuBarMain;
    private javax.swing.JMenuItem menuItemAuthUser;
    private javax.swing.JMenuItem menuItemChangePassword;
    private javax.swing.JMenuItem menuItemListNotifications;
    private javax.swing.JMenuItem menuItemListUsers;
    private javax.swing.JMenuItem menuItemSendNotification;
    private javax.swing.JMenu menuNotificationManagement;
    private javax.swing.JMenu menuUserManagement;
    // End of variables declaration//GEN-END:variables
}
