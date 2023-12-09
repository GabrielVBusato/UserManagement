/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.AuthenticationPresenter.states;

import com.source.presenter.AuthenticationPresenter.AuthenticationPresenter;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public final class LoginState extends AuthenticationState {

    public LoginState(AuthenticationPresenter presenter) {
        super(presenter);
        initComponents();
    }

    @Override
    public void initComponents() {
        clearScreen();
    }

    @Override
    public void onLogin() throws SQLException {
    }

    @Override
    public void onRegister() throws SQLException {
        presenter.getView().getBtnLogin().setVisible(false);
        presenter.setState(new RegisterState(presenter));
    }

}
