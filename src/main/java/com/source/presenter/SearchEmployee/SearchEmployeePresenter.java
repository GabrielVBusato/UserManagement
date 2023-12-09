/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.SearchEmployee;

import com.source.model.EmployeeModel;
import com.source.presenter.BonusHistory.BonusHistoryPresenter;
import com.source.presenter.EmployeeManagement.EmployeeManagementPresenter;
import com.source.service.EmployeeBonusService.EmployeeBonusService;
import com.source.service.EmployeeService.EmployeeService;
import com.source.view.SearchEmployeeView;
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
public final class SearchEmployeePresenter {

    private static SearchEmployeeView view = new SearchEmployeeView();
    private final EmployeeService service;
    private final EmployeeBonusService bonusService;

    public SearchEmployeePresenter(EmployeeService service, EmployeeBonusService bonusService) {
        if (view == null) {
            view = new SearchEmployeeView();
        }
        initComponents();
        this.service = service;
        this.bonusService = bonusService;
        view.setVisible(true);
    }

    public String getSelectedRowValue(int column) {
        int row = view.getTblSearch().getSelectedRow();
        return view.getTblSearch().getModel().getValueAt(row, column).toString();
    }

    public void setModelTable() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
            tableModel.setRowCount(0);
            List<EmployeeModel> employees = service.getAllEmployeesByName(view.getTxtSearchName().getText());
            for (EmployeeModel employee : employees) {
                Object[] rowData = {employee.getId(), employee.getName(), employee.getRole(),
                    employee.getBaseSalary(), employee.getTotalAbsencesFromWork()};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar funcionário");
        }
    }

    public void clearScreen() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblSearch().getModel();
        tableModel.setRowCount(0);
        view.getTxtSearchName().setText("");
        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnSearch().getActionListeners()) {
            view.getBtnSearch().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnNewEmployee().getActionListeners()) {
            view.getBtnNewEmployee().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnViewBonus().getActionListeners()) {
            view.getBtnViewBonus().removeActionListener(al);
        }
        for (ActionListener al : view.getBtnViewEmployee().getActionListeners()) {
            view.getBtnViewEmployee().removeActionListener(al);
        }
    }

    private void initComponents() {
        clearScreen();
        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        view.getBtnNewEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeManagementPresenter(service);
            }
        });
        view.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModelTable();
            }
        });
        view.getBtnViewBonus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new BonusHistoryPresenter(bonusService, view,
                            Integer.parseInt(getSelectedRowValue(0)),
                            getSelectedRowValue(1));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar dados do funcionário");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário");
                }
            }
        });
        view.getBtnViewEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EmployeeManagementPresenter(service,
                            Integer.parseInt(getSelectedRowValue(0)));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao pesquisar funcionário");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário");
                }
            }
        });
    }
}
