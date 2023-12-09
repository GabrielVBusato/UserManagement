/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.repository;

import com.source.dao.EmployeeBonusDao;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeBonusDTO;
import com.source.model.EmployeeBonusModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author busat
 */
public class EmployeeBonusRepository {

    private final EmployeeBonusDao employeeBonusDao;
    private final IDatabaseConnection connection;

    public EmployeeBonusRepository(IDatabaseConnection connection) {
        employeeBonusDao = new EmployeeBonusDao(connection);
        this.connection = connection;
    }

    public int createEmployeeBonus(List<EmployeeBonusDTO> employeeBonus) throws SQLException {
        return employeeBonusDao.createBatch(employeeBonus);
    }

    public List<EmployeeBonusModel> getEmployeeBonusesById(int id) throws SQLException {
        ResultSet result = employeeBonusDao.read(id);
        List<EmployeeBonusModel> employeeBonuses = new ArrayList();
        while (result.next()) {
            EmployeeBonusModel employeeBonus = new EmployeeBonusModel();
            employeeBonus.setIdEmployee(result.getInt("id_employee"));
            employeeBonus.setIdBonus(result.getInt("id_bonus"));
            employeeBonus.setBonusValue(result.getDouble("bonus_value"));
            employeeBonus.setCreatedAt(result.getString("created_at"));
            employeeBonus.setBonusName(result.getString("name"));
            employeeBonus.setEmployeeName(result.getString("employee_name"));
            employeeBonus.setEmployeeRole(result.getString("name"));
            employeeBonuses.add(employeeBonus);
        }
        connection.disconnect();
        return employeeBonuses;
    }
}
