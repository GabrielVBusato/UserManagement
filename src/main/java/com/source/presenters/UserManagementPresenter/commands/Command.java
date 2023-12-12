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
public abstract class Command {
    
    protected boolean commandIsValid;

    protected Command(UserManagementPresenter presenter) {
        this.presenter = presenter;
        this.commandIsValid = validate();
    }

    private boolean validate() {
        if ("".equals(presenter.getView().getTxtName().getText())) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de nome",
                    "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    protected UserManagementPresenter presenter;
    
    public void executeCommandIfValid(){
        if(commandIsValid){
            execute();
        }
    }

    public abstract void execute();
}
