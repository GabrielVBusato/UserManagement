/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.repository;

import com.source.dao.EmployeeDao;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeDTO;
import com.source.model.EmployeeModel;
import com.source.service.EmployeeService.statisticsSalaryChain.AverageSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.HighestSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.LowestSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.SumSalary;
import com.source.service.EmployeeService.statisticsSalaryChain.TotalNumberOfSalarys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author busat
 */
public class EmployeeRepository {

    private final EmployeeDao employeeDao;
    private final IDatabaseConnection connection;

    public EmployeeRepository(IDatabaseConnection connection) {
        employeeDao = new EmployeeDao(connection);
        this.connection = connection;
    }

    public void deleteEmployeeById(int id) throws SQLException {
        employeeDao.delete(id);
    }

    public EmployeeModel getEmployeeById(int id) throws SQLException {
        ResultSet result = employeeDao.read(id);
        EmployeeModel employee = new EmployeeModel();
        while (result.next()) {
            employee.setId(result.getInt("id"));
            employee.setName(result.getString("name"));
            employee.setRole(result.getString("role"));
            employee.setBaseSalary(result.getString("base_salary"));
            employee.setDistanceFromWork(result.getString("distance_from_work"));
            employee.setServiceTime(result.getString("service_time"));
            employee.setCreatedAt(result.getString("created_at"));
            employee.setTotalAbsencesFromWork(result.getInt("absences_from_work"));
            employee.setEmployeeOfTheMonth(result.getInt("employee_of_the_month"));
        }
        connection.disconnect();
        return employee;
    }

    public int createEmployee(EmployeeDTO employee) throws SQLException {
        return employeeDao.create(employee);
    }

    public void modifyEmployee(EmployeeDTO employee) throws SQLException {
        employeeDao.update(employee);
    }

    public List<EmployeeModel> getAllEmployees() throws SQLException {
        ResultSet result = employeeDao.getAll();
        List<EmployeeModel> employees = new ArrayList<>();
        while (result.next()) {
            EmployeeModel employee = new EmployeeModel();
            employee.setId(result.getInt("id"));
            employee.setName(result.getString("name"));
            employee.setRole(result.getString("role"));
            employee.setBaseSalary(result.getString("base_salary"));
            employee.setDistanceFromWork(result.getString("distance_from_work"));
            employee.setServiceTime(result.getString("service_time"));
            employee.setCreatedAt(result.getString("created_at"));
            employee.setTotalAbsencesFromWork(result.getInt("absences_from_work"));
            employee.setEmployeeOfTheMonth(result.getInt("employee_of_the_month"));
            employees.add(employee);
        }
        connection.disconnect();
        return employees;
    }

    public List<EmployeeModel> getAllEmployeesByName(String name) throws SQLException {
        ResultSet result = employeeDao.getAllByName(name);
        List<EmployeeModel> employees = new ArrayList<>();
        while (result.next()) {
            EmployeeModel employee = new EmployeeModel();
            employee.setId(result.getInt("id"));
            employee.setName(result.getString("name"));
            employee.setRole(result.getString("role"));
            employee.setBaseSalary(result.getString("base_salary"));
            employee.setDistanceFromWork(result.getString("distance_from_work"));
            employee.setServiceTime(result.getString("service_time"));
            employee.setCreatedAt(result.getString("created_at"));
            employee.setTotalAbsencesFromWork(result.getInt("absences_from_work"));
            employee.setEmployeeOfTheMonth(result.getInt("employee_of_the_month"));
            employees.add(employee);
        }
        connection.disconnect();
        return employees;
    }

    public Collection<String> getAllRoles() throws SQLException {
        ResultSet result = employeeDao.getAllRoles();
        Collection roles = new ArrayList();
        while (result.next()) {
            if (!roles.contains(result.getString("role"))) {
                roles.add(result.getString("role"));
            }
        }
        connection.disconnect();
        return roles;
    }

    public AverageSalary getAverageSalarys() throws SQLException {
        ResultSet result = employeeDao.getAverageSalarys();
        AverageSalary salary = new AverageSalary();
        while (result.next()) {
            salary.setValue(result.getString("salary_avg"));
        }
        connection.disconnect();
        return salary;
    }
    
    public SumSalary getSumSalarys() throws SQLException {
        ResultSet result = employeeDao.getSumSalarys();
        SumSalary salary = new SumSalary();
        while (result.next()) {
            salary.setValue(result.getString("salary_sum"));
        }
        connection.disconnect();
        return salary;
    }
    
    public LowestSalary getLowestSalary() throws SQLException {
        ResultSet result = employeeDao.getLowestSalary();
        LowestSalary salary = new LowestSalary();
        while (result.next()) {
            salary.setValue(result.getString("min_salary"));
        }
        connection.disconnect();
        return salary;
    }
    
   public HighestSalary getHighestSalary() throws SQLException {
        ResultSet result = employeeDao.getHighestSalary();
        HighestSalary salary = new HighestSalary();
        while (result.next()) {
            salary.setValue(result.getString("max_salary"));
        }
        connection.disconnect();
        return salary;
    }
   
   public TotalNumberOfSalarys getTotalSalarys() throws SQLException {
        ResultSet result = employeeDao.getTotalSalarys();
        TotalNumberOfSalarys salary = new TotalNumberOfSalarys();
        while (result.next()) {
            salary.setValue(result.getString("total_salarys"));
        }
        connection.disconnect();
        return salary;
    }
}
