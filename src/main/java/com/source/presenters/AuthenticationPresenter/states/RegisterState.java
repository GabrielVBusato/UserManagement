/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.AuthenticationPresenter.states;

import com.source.exceptions.FailedValidationException;
import com.source.model.UsersModel;
import com.source.presenters.AuthenticationPresenter.AuthenticationPresenter;
import com.source.validations.TextField;

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
        presenter.removeListeners();
        presenter.initComponents();
        presenter.getView().getBtnLogin().setVisible(false);
    }

    @Override
    public void onRegister() throws FailedValidationException {
        TextField userName = new TextField(presenter.getView().getTxtUsername().getText(), "userName");
        TextField password = new TextField(presenter.getView().getTxtPassword().getText(), "password");

        TextField[] fields = {userName, password};

        for (TextField field : fields) {
            field.validateNotNull();
        }

        UsersModel user = new UsersModel();
        user.setPassword(password.getValue());
        user.setName(userName.getValue());
        UsersModel newUser = presenter.getUserService().register(user);

        if (newUser != null) {
            presenter.setState(new LoginState(presenter));
        }

    }
}
