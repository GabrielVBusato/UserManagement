/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.states;

import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.presenters.UserManagementPresenter.UserManagementState;

/**
 *
 * @author busat
 */
public final class ManageUserState extends UserManagementState {

    public ManageUserState(UserManagementPresenter presenter) {
        super(presenter);
        initComponents();
    }

    @Override
    public void initComponents() {
        presenter.getView().getBtnClose().setVisible(false);
        presenter.getView().getBtnDelete().setVisible(false);
        presenter.getView().getBtnEdit().setVisible(false);
        presenter.getView().getBtnCancelar().setVisible(true);
        presenter.getView().getBtnSalvar().setVisible(true);
        removeListeners();
        presenter.initComponents();
    }

    @Override
    public void onSave() {
        UsersModel oldUser = presenter.getUserService().findUserByUsername(presenter.getUser().getName());
        UsersModel newUser = new UsersModel();
        UsersModel hasUser;

        if (oldUser != null) {
            oldUser.setName(presenter.getView().getTxtName().getText());
            hasUser = presenter.getUserService().updateUser(oldUser);
        } else {
            newUser.setName(presenter.getView().getTxtName().getText());
            newUser.setPassword("sandbox");
            hasUser = presenter.getUserService().register(newUser);
        }

        if (hasUser != null) {
            presenter.setUser(hasUser);
            presenter.setState(new ReadState(presenter));
        }
    }

    @Override
    public void onCancel() {
        presenter.getView().dispose();
    }

}
