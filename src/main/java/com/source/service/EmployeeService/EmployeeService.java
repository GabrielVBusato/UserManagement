/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeService;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeDTO;
import com.source.model.EmployeeModel;
import com.source.repository.EmployeeRepository;
import com.source.service.EmployeeService.statisticsSalaryChain.StatisticChain;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author busat
 */
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(IDatabaseConnection connection) {
        employeeRepository = new EmployeeRepository(connection);
    }

    public EmployeeModel getEmployeeById(int id) throws SQLException {
        return employeeRepository.getEmployeeById(id);
    }

    public void deleteEmployeeById(int id) throws SQLException {
        employeeRepository.deleteEmployeeById(id);
    }

    public List<EmployeeModel> getAllEmployees() throws SQLException {
        return employeeRepository.getAllEmployees();
    }

    public Collection<String> getAllRoles() throws SQLException {
        return employeeRepository.getAllRoles();
    }

    public List<EmployeeModel> getAllEmployeesByName(String name) throws SQLException {
        return employeeRepository.getAllEmployeesByName(name);
    }

    public int createEmployee(EmployeeModel employee) throws SQLException {
        EmployeeDTO empDTO = new EmployeeDTO(employee);
        return employeeRepository.createEmployee(empDTO);
    }

    public void editEmployee(EmployeeModel employee) throws SQLException {
        EmployeeDTO empDTO = new EmployeeDTO(employee);
        employeeRepository.modifyEmployee(empDTO);
    }

    public StatisticChain getAverageSalarysByMonth() throws SQLException {
        return employeeRepository.getAverageSalarys();
    }

    public StatisticChain getSumSalaryByMonth() throws SQLException {
        return employeeRepository.getSumSalarys();
    }

    public StatisticChain getHighestSalaryByMonth() throws SQLException {
        return employeeRepository.getHighestSalary();
    }

    public StatisticChain getLowestSalaryByMonth() throws SQLException {
        return employeeRepository.getLowestSalary();
    }

    public StatisticChain getTotalSalarysByMonth() throws SQLException {
        return employeeRepository.getTotalSalarys();
    }

    public void setSalaryStatistics(List<StatisticChain> strategyList) throws SQLException {
        for (StatisticChain strategy : strategyList) {
            strategy.calculate(this);
        }
    }
}
