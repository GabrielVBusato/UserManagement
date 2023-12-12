/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter.states;

import com.source.model.UsersModel;
import com.source.presenters.UserManagementPresenter.UserManagementPresenter;
import com.source.presenters.UserManagementPresenter.UserManagementState;
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
        presenter.setState(new ManageUserState(presenter));
    }

    @Override
    public void onDelete() {
        int choice = JOptionPane.showConfirmDialog(null, "Deseja continuar realmente excluir??", "Confirmação de exclusão  ",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            presenter.getUserService().deleteUser(presenter.getUser().getId(), presenter.getUser().getName());
        }
        presenter.getView().dispose();
    }

    @Override
    public void onClose() {
        presenter.getView().dispose();
    }
}
