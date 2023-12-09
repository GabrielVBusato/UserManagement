/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.BonusHistory;

import com.source.model.EmployeeBonusModel;
import com.source.service.EmployeeBonusService.EmployeeBonusService;
import com.source.view.BonusHistoryView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public class BonusHistoryPresenter {

    private static BonusHistoryView view = null;
    private final EmployeeBonusService serviceBonus;
    private final int searchId;
    private final String searchName;

    public BonusHistoryPresenter(EmployeeBonusService service,
            JFrame searchView,
            int id,
            String name) throws SQLException {
        if (view == null) {
            view = new BonusHistoryView(searchView, true);
        }
        this.serviceBonus = service;
        searchId = id;
        searchName = name;
        initComponents();
        view.setVisible(true);
    }

    private void initComponents() throws SQLException {
        List<EmployeeBonusModel> employeeBonuses = serviceBonus.getEmployeeBonusesById(searchId);
        view.setTitle(searchName);
        for (EmployeeBonusModel employeeBonus : employeeBonuses) {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblBonuses().getModel();
            Object[] rowData = {employeeBonus.getCreatedAt(),
                employeeBonus.getEmployeeRole(),
                employeeBonus.getBonusName(),
                String.format("%.2f", employeeBonus.getBonusValue())};
            tableModel.addRow(rowData);
        }
    }
}
