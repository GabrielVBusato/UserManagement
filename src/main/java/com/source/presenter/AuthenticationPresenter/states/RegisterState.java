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
public final class RegisterState extends AuthenticationState {

    public RegisterState(AuthenticationPresenter presenter) {
        super(presenter);
        initComponents();
    }

    @Override
    public void initComponents() {
        clearScreen();
        presenter.getView().getBtnLogin().setVisible(false);
    }

    @Override
    public void onRegister() throws SQLException {
        presenter.getView().getBtnLogin().setVisible(true);
        presenter.setState(new LoginState(presenter));
    }
    
}
