/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.EmployeeManagement.states;

import com.source.presenter.EmployeeManagement.EmployeeManagementPresenter;
import com.source.presenter.EmployeeManagement.EmployeeManagementState;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public final class CreateState extends EmployeeManagementState {

    public CreateState(EmployeeManagementPresenter presenter) {
        super(presenter);
        initComponents();
    }

    @Override
    public void onCreate() throws SQLException,
            NumberFormatException {
        presenter.createEmployee();
        presenter.setState(new UpdateState(presenter));

    }

    @Override
    public void initComponents() {
        presenter.initComponents();
        view.getComboRole().setSelectedIndex(0);
        view.getBtnCreate().setVisible(true);
        view.getBtnDelete().setVisible(false);
        view.getBtnUpdate().setVisible(false);
    }
}
