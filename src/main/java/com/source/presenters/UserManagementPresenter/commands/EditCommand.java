/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.commands;

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
        presenter.setState(new ManageUserState(presenter));
    }

}
