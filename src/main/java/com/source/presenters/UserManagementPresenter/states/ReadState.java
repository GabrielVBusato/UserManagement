/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.states;

import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.presenters.UserManagementPresenter.UserManagementState;
import com.source.presenters.UserManagementPresenter.commands.CloseWindowCommand;
import com.source.presenters.UserManagementPresenter.commands.DeleteCommand;
import com.source.presenters.UserManagementPresenter.commands.EditCommand;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public final class ReadState extends UserManagementState {

    public ReadState(UserManagementPresenter presenter) {
        super(presenter);
        initComponents();
    }

    @Override
    public void initComponents() {
        presenter.getView().getBtnClose().setVisible(true);
        presenter.getView().getBtnDelete().setVisible(true);
        presenter.getView().getBtnEdit().setVisible(true);
        presenter.getView().getBtnCancelar().setVisible(false);
        presenter.getView().getBtnSalvar().setVisible(false);
        removeListeners();
        presenter.initComponents();
    }

    @Override
    public void onEdit() {
        presenter.setCommand(new EditCommand(presenter));
    }

    @Override
    public void onDelete() {
        presenter.setCommand(new DeleteCommand(presenter));
    }

    @Override
    public void onClose() {
        presenter.setCommand(new CloseWindowCommand(presenter));
    }
}
