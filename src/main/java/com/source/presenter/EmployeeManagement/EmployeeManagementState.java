/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.EmployeeManagement;

import com.source.presenter.AuthenticationPresenter.states.AuthenticationState;
import com.source.view.EmployeeManagementView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public abstract class EmployeeManagementState {

    public EmployeeManagementPresenter presenter;
    private final String operationErr = "Operação não permitida nesse estado";
    public final EmployeeManagementView view;
    private AuthenticationState state;

    public EmployeeManagementState(EmployeeManagementPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }
    
    public void setState(AuthenticationState state){
        this.state = state;
    }

    public abstract void initComponents() throws SQLException;

    public void onUpdate() throws SQLException {
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onCreate() throws SQLException{
        JOptionPane.showMessageDialog(null, operationErr);
    }

    public void onDelete() throws SQLException{
        JOptionPane.showMessageDialog(null, operationErr);
    }
}
