/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.ChangePasswordPresenter;

import com.logger.helpers.enums.LogTypeEnum;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.exceptions.FailedValidationException;
import com.source.model.UsersModel;
import com.source.service.UserService.UsersService;
import com.source.session.UserSession;
import com.source.utils.Logger;
import com.source.validations.TextField;
import com.source.view.ChangePasswordView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mauricio
 */
public class ChangePasswordPresenter {

    private static ChangePasswordView view = null;
    private static ChangePasswordPresenter instance = null;
    private static UsersService userService;
    private final IDatabaseConnection connection;

    private ChangePasswordPresenter(IDatabaseConnection connection,
            UsersService userService) {
        if (view == null) {
            view = new ChangePasswordView();
        }
        this.connection = connection;
        ChangePasswordPresenter.userService = userService;
    }

    public static ChangePasswordPresenter getInstance(
            IDatabaseConnection connection,
            UsersService userService) {
        if (instance == null) {
            instance = new ChangePasswordPresenter(connection, userService);
        }
        
        initComponents();
        view.setVisible(true);
        return instance;
    }

    private static void initComponents() {
        removeListeners();
        clearScreen();
        view.getBtnSavePassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TextField password = new TextField(view.getTxtNewPassword().getText(), "password");
                    TextField repeatPassword = new TextField(view.getTxtRepeatNewPassword().getText(), "repeatPassword");

                    TextField[] fields = {password, repeatPassword};

                    for (TextField field : fields) {
                        field.validateNotNull();
                        field.validatePassword();
                        field.validateNotEquals(view.getTxtRepeatNewPassword().getText());
                    }

                    UsersModel user = UserSession.getInstance().getCurrentUser();

                    user.setPassword(view.getTxtNewPassword().getText());

                    userService.updateUser(user);
                    
                    view.setVisible(false);
                } catch (FailedValidationException ex) {
                    Logger.writeSystemErrorLog(LogTypeEnum.ERROR, UserSession.getInstance().getCurrentUser().getName(), "TROCAR SENHA", ex.getMessage());
                }
            }
        });
    }

    private static void clearScreen() {
        view.getTxtNewPassword().setText("");
        view.getTxtRepeatNewPassword().setText("");
    }
    
    private static void removeListeners() {
        for (ActionListener al : view.getBtnSavePassword().getActionListeners()) {
            view.getBtnSavePassword().removeActionListener(al);
        }
    }

}
