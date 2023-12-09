/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.SalaryStatistics;

import com.source.service.EmployeeService.EmployeeService;
import com.source.service.EmployeeService.statisticsSalaryChain.AverageSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.HighestSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.LowestSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.StatisticChain;
import com.source.service.EmployeeService.statisticsSalaryChain.SumSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.TotalNumberOfSalarys;
import com.source.utils.DateUtils;
import com.source.view.SalaryStatisticsView;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author busat
 */
public class SalaryStatisticsPresenter {

    private static SalaryStatisticsView view = new SalaryStatisticsView();
    private EmployeeService service = null;

    public SalaryStatisticsPresenter(EmployeeService service) {
        if (view == null) {
            view = new SalaryStatisticsView();
        }
        this.service = service;
        initComponents();
        view.setVisible(true);
    }

    public void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblStatistics().getModel();
        tableModel.setNumRows(0);
    }

    private void initComponents() {
        clearScreen();
        ArrayList<StatisticChain> salarysStatisticsList = new ArrayList();
        try {
            salarysStatisticsList.add(new AverageSalary());
            salarysStatisticsList.add(new HighestSalary());
            salarysStatisticsList.add(new LowestSalary());
            salarysStatisticsList.add(new SumSalary());
            salarysStatisticsList.add(new TotalNumberOfSalarys());
            service.setSalaryStatistics(salarysStatisticsList);
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblStatistics().getModel();
            view.getTblStatistics().getColumnModel().getColumn(1).
                    setHeaderValue(DateUtils.getFormattedCurrentDate());
            for (StatisticChain salary : salarysStatisticsList) {
                Object[] rowData = {salary.getName(), salary.getValue()};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar as estatísticas dos salários" + ex);
        }
    }
}
