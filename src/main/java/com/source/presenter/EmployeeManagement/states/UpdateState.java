/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.EmployeeManagement.states;

import com.source.model.EmployeeModel;
import com.source.presenter.EmployeeManagement.EmployeeManagementPresenter;
import com.source.presenter.EmployeeManagement.EmployeeManagementState;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public final class UpdateState extends EmployeeManagementState {

    public UpdateState(EmployeeManagementPresenter presenter) throws SQLException {
        super(presenter);
        initComponents();
    }

    @Override
    public void onUpdate() throws SQLException {
        presenter.editEmployee();
    }
    
    @Override
    public void onDelete() throws SQLException {
        presenter.deleteEmployee();
    }

    @Override
    public void initComponents() throws SQLException {
        presenter.initComponents();
        view.getBtnDelete().setVisible(true);
        view.getBtnUpdate().setVisible(true);
        view.getBtnCreate().setVisible(false);    
        EmployeeModel employee = presenter.getEmployeeById(presenter.getSearchId());
        presenter.setModel(employee);
    }

}
