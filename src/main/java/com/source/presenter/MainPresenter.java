/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.presenter.CalculateSalarys.CalculateSalarysPresenter;
import com.source.presenter.EmployeeManagement.EmployeeManagementPresenter;
import com.source.presenter.SalaryStatistics.SalaryStatisticsPresenter;
import com.source.presenter.SearchEmployee.SearchEmployeePresenter;
import com.source.service.EmployeeBonusService.EmployeeBonusService;
import com.source.service.EmployeeService.EmployeeService;
import com.source.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public class MainPresenter {

    private static MainView view = null;
    private final IDatabaseConnection connection;

    public MainPresenter(IDatabaseConnection connection) {
        this.connection = connection;
        if (view == null) {
            view = new MainView();
        }
        view.setVisible(true);
        initComponents();
    }

    private void initComponents() {
        EmployeeService employeeService = new EmployeeService(connection);
        EmployeeBonusService employeeBonusService = new EmployeeBonusService(connection);
        view.getMenuItemCreateEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeManagementPresenter(employeeService);
            }
        });
        view.getMenuItemSearchEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeePresenter(employeeService, employeeBonusService);
            }
        });
        view.getMenuItemCalculateSalarys().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalculateSalarysPresenter(employeeService, employeeBonusService);
            }
        });
        view.getMenuItemSalaryStatistics().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SalaryStatisticsPresenter(employeeService);
            }
        });
    }
}
