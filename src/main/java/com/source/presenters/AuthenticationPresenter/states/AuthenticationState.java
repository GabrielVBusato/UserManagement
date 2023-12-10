package com.source.presenters.AuthenticationPresenter.states;

import com.source.exceptions.AuthenticateFailException;
import com.source.exceptions.FailedValidationException;
import com.source.exceptions.UnauthorizedException;
import com.source.presenters.AuthenticationPresenter.AuthenticationPresenter;
import com.source.view.AuthenticationView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author busat
 */
public abstract class AuthenticationState {

    public AuthenticationPresenter presenter;
    private final String operationErr = "Operação não permitida nesse estado" + getClass().getSimpleName();
    protected final AuthenticationView view;

    public AuthenticationState(AuthenticationPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    public abstract void initComponents();

    public void onLogin() throws FailedValidationException {
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onRegister()
            throws FailedValidationException {
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void clearScreen() {
        this.view.getTxtPassword().setText("");
        this.view.getTxtUsername().setText("");
    }
}
