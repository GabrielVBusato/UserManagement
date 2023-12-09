/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.CalculateSalarys;

import com.source.model.EmployeeModel;
import com.source.service.EmployeeBonusService.EmployeeBonusService;
import com.source.service.EmployeeService.EmployeeService;
import com.source.utils.DateUtils;
import com.source.view.CalculateSalarysView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public final class CalculateSalarysPresenter {

    private static CalculateSalarysView view = null;
    private final EmployeeService service;
    private final EmployeeBonusService serviceBonus;

    public CalculateSalarysPresenter(EmployeeService service, EmployeeBonusService serviceBonus) {
        if (view == null) {
            view = new CalculateSalarysView();
        }
        this.service = service;
        this.serviceBonus = serviceBonus;
        initComponents();
        view.setVisible(true);
    }

    public void calculateSalarys() {
        try {
            List<EmployeeModel> employees = service.getAllEmployees();
            serviceBonus.createEmployeesBonuses(employees);
            for (EmployeeModel employee : employees) {
                Double totalSalary = Double.valueOf(employee.getBaseSalary()) + employee.getBonusTotal();
                DefaultTableModel tableModel = (DefaultTableModel) view.getTblSalarys().getModel();
                Object[] rowData = {employee.getName(), DateUtils.getFormattedCurrentDate(), 
                    String.format("%.2f", Double.valueOf(employee.getBaseSalary())),
                    String.format("%.2f", employee.getBonusTotal()),
                    String.format("%.2f", totalSalary)};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular salários");
        }
    }

    public void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSalarys().getModel();
        tableModel.setRowCount(0);
        for (ActionListener al : view.getBtnCalculate().getActionListeners()) {
            view.getBtnCalculate().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }
    }

    public void initComponents() {
        clearScreen();
        view.getBtnCalculate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSalarys();
            }
        });
        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }
}
