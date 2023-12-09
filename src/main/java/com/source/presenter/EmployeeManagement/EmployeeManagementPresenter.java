/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenter.EmployeeManagement;

import com.source.model.EmployeeModel;
import com.source.presenter.EmployeeManagement.states.CreateState;
import com.source.presenter.EmployeeManagement.states.UpdateState;
import com.source.service.EmployeeService.EmployeeService;
import com.source.utils.DateUtils;
import com.source.view.EmployeeManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public final class EmployeeManagementPresenter {

    private static EmployeeManagementView view = null;
    private EmployeeManagementState state;
    private final EmployeeService service;
    private int searchId;

    public EmployeeManagementPresenter(
            EmployeeService service) {
        if (view == null) {
            view = new EmployeeManagementView();
        }
        this.service = service;
        this.state = new CreateState(this);
        view.setVisible(true);
    }

    public EmployeeManagementPresenter(EmployeeService service,
            int id) throws SQLException {
        if (view == null) {
            view = new EmployeeManagementView();
        }
        this.searchId = id;
        this.service = service;
        this.state = new UpdateState(this);
        view.setVisible(true);
    }

    public EmployeeManagementState getState() {
        return state;
    }

    public void setState(EmployeeManagementState state) {
        this.state = state;
    }

    public void createEmployee() throws SQLException {
        searchId = service.createEmployee(getModel());
    }

    public void editEmployee() throws SQLException {
        service.editEmployee(getModel());
    }

    public void deleteEmployee() throws SQLException {
        service.deleteEmployeeById(searchId);
    }

    public EmployeeModel getEmployeeById(int id) throws SQLException {
        return service.getEmployeeById(id);
    }

    public EmployeeManagementView getView() {
        return view;
    }

    public int getSearchId() {
        return searchId;
    }

    public void clearScreen() {
        for (ActionListener al : view.getBtnCreate().getActionListeners()) {
            view.getBtnCreate().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnUpdate().getActionListeners()) {
            view.getBtnUpdate().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnClose().getActionListeners()) {
            view.getBtnClose().removeActionListener(al);
        }

        for (ActionListener al : view.getBtnDelete().getActionListeners()) {
            view.getBtnDelete().removeActionListener(al);
        }

        view.getTxtAbsencesFromWork().setText("");
        view.getTxtDistanceFromWork().setText("");
        view.getTxtName().setText("");
        view.getTxtSalary().setText("");
        view.getTxtServiceTime().setText("");
        view.getComboRole().setSelectedIndex(-1);
    }

    public EmployeeModel getModel() {
        EmployeeModel employee = new EmployeeModel();
        employee.setTotalAbsencesFromWork(Integer.parseInt(view.getTxtAbsencesFromWork().getText()));
        employee.setServiceTime(view.getTxtServiceTime().getText());
        employee.setDistanceFromWork(view.getTxtDistanceFromWork().getText());
        employee.setName(view.getTxtName().getText());
        employee.setBaseSalary(view.getTxtSalary().getText());
        employee.setRole((String) view.getComboRole().getSelectedItem());
        employee.setId(searchId);
        employee.setEmployeeOfTheMonth(view.getCheckBoxMonthEmployee().isSelected() ? 1 : 0);
        employee.setCreatedAt(DateUtils.getFormattedCurrentDate());
        return employee;
    }

    public void setModel(EmployeeModel employee) {
        view.getTxtAbsencesFromWork().setText(Integer.toString(employee.getTotalAbsencesFromWork()));
        view.getTxtDistanceFromWork().setText(employee.getDistanceFromWork());
        view.getTxtName().setText(employee.getName());
        view.getTxtSalary().setText(employee.getBaseSalary());
        view.getTxtServiceTime().setText(employee.getServiceTime());
        view.getCheckBoxMonthEmployee().setSelected((employee.getEmployeeOfTheMonth() == 1));
        view.getComboRole().setSelectedItem(employee.getRole());
    }

    public boolean isAllFieldsFilled() {
        return !(view.getTxtAbsencesFromWork().getText().isEmpty()
                || view.getTxtDistanceFromWork().getText().isEmpty()
                || view.getTxtName().getText().isEmpty()
                || view.getTxtSalary().getText().isEmpty()
                || view.getTxtServiceTime().getText().isEmpty()
                || view.getComboRole().getSelectedIndex() == -1);
    }

    public void initComponents() {
        clearScreen();
        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        view.getBtnCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isAllFieldsFilled()) {
                        state.onCreate();
                        JOptionPane.showConfirmDialog(view, "Funcionário criado com sucesso",
                                "Sucesso", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao criar funcionário");
                }
            }
        });
        view.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    state.onUpdate();
                    JOptionPane.showConfirmDialog(view, "Funcionário atualizado com sucesso",
                            "Sucesso", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
                    view.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
                }
            }
        });
        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputConfirm = JOptionPane.showConfirmDialog(null,
                            "Deseja realmente deletar?", "Selecione uma opção...", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (inputConfirm == 0) {
                        state.onDelete();
                        JOptionPane.showConfirmDialog(view, "Funcionário deletado com sucesso",
                                "Sucesso", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE);
                        view.dispose();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário");
                }
            }
        });
        try {
            ArrayList<String> roles = new ArrayList(this.service.getAllRoles());
            for (String role : roles) {
                view.getComboRole().addItem(role);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cargos cadastrados");
        }
    }
}
