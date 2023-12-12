/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.commands;

import com.source.presenters.UserManagementPresenter.UserManagementPresenter;

/**
 *
 * @author busat
 */
public class CloseWindowCommand extends Command {

    public CloseWindowCommand(UserManagementPresenter presenter) {
        super(presenter);
    }

    @Override
    public void execute() {
        presenter.getView().dispose();
    }
}
