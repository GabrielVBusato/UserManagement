/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.UserManagementPresenter;

import com.source.view.UserManagementView;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public abstract class UserManagementState {

    public UserManagementPresenter presenter;
    private final String operationErr = "Operação não permitida nesse estado" + getClass().getSimpleName();
    protected final UserManagementView view;

    public UserManagementState(UserManagementPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    public abstract void initComponents();

    public void onEdit() {
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onDelete(){
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onClose() {
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onCancel(){
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onSave(){
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void removeListeners() {
        for (ActionListener al : view.getBtnEdit().getActionListeners()) {
            view.getBtnEdit().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnDelete().getActionListeners()) {
            view.getBtnDelete().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }
        
        for (ActionListener al : view.getBtnSalvar().getActionListeners()) {
            view.getBtnSalvar().removeActionListener(al);
        }
        
        for (ActionListener al : view.getBtnCancelar().getActionListeners()) {
            view.getBtnCancelar().removeActionListener(al);
        }
    }
}
