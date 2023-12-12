/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.commands;

import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.presenters.UserManagementPresenter.states.ManageUserState;

/**
 *
 * @author busat
 */
public class EditCommand extends Command {

    public EditCommand(UserManagementPresenter presenter) {
        super(presenter);
    }

    @Override
    public void execute() {
        String newUsername = presenter.getView().getTxtName().getText();
        presenter.getUser().setName(newUsername);
        UsersModel updatedUser = presenter.getUserService().updateUser(presenter.getUser());
        if (updatedUser != null) {
            presenter.setUser(updatedUser);
            presenter.setState(new ManageUserState(presenter));
        }
    }

}
