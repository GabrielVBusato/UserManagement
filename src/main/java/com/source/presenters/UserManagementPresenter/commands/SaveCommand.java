/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.commands;

import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.presenters.UserManagementPresenter.states.ReadState;

/**
 *
 * @author busat
 */
public class SaveCommand extends Command {

    public SaveCommand(UserManagementPresenter presenter) {
        super(presenter);
    }

    @Override
    public void execute() {
        UsersModel newUser = (presenter.getUser() != null) ? presenter.getUser() : new UsersModel();
        newUser.setName(presenter.getView().getTxtName().getText());
        UsersModel hasUser;

        if (presenter.getUser() != null) {
            hasUser = presenter.getUserService().updateUser(newUser);
        } else {
            newUser.setPassword("sandbox");
            hasUser = presenter.getUserService().register(newUser);
        }

        if (hasUser != null) {
            presenter.setUser(hasUser);
            presenter.setState(new ReadState(presenter));
        }
    }

}
