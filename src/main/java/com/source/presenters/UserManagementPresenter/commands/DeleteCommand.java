/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.commands;

import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public class DeleteCommand extends Command {

    public DeleteCommand(UserManagementPresenter presenter) {
        super(presenter);
    }

    @Override
    public void execute() {
        int choice = JOptionPane.showConfirmDialog(null, "Deseja continuar realmente excluir??", "Confirmação de exclusão  ",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            presenter.getUserService().deleteUser(presenter.getUser().getId(), presenter.getUser().getName());
        }
        presenter.getView().dispose();
    }

}
