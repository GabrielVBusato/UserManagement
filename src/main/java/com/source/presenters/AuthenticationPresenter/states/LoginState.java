/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.AuthenticationPresenter.states;

import com.source.exceptions.FailedValidationException;
import com.source.model.UsersModel;
import com.source.presenters.AuthenticationPresenter.AuthenticationPresenter;
import com.source.presenters.MainPresenter.MainPresenter;
import com.source.session.UserSession;
import com.source.validations.TextField;

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
        presenter.removeListeners();
        presenter.initComponents();
        clearScreen();
    }

    @Override
    public void onLogin() throws FailedValidationException {
        TextField userName = new TextField(presenter.getView().getTxtUsername().getText(), "userName");
        TextField password = new TextField(presenter.getView().getTxtPassword().getText(), "password");;

        TextField[] fields = {userName, password};

        for (TextField field : fields) {
            field.validateNotNull();
        }

        UsersModel user = presenter.getUserService().login(userName.getValue(), password.getValue());

        if (user != null) {
            UserSession.getInstance().loginUser(user);
            presenter.getView().dispose();

            MainPresenter.getInstance(presenter.getConnection(), presenter.getUserService());
        }
    }
}
