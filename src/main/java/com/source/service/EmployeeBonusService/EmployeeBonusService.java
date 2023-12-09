package com.source.service.EmployeeBonusService;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeBonusDTO;
import com.source.model.EmployeeBonusModel;
import com.source.model.EmployeeModel;
import com.source.repository.EmployeeBonusRepository;
import com.source.service.EmployeeBonusService.calculateSalaryChain.BonusCalculator;
import com.source.service.EmployeeBonusService.calculateSalaryChain.CalculateBonusByAssiduity;
import com.source.service.EmployeeBonusService.calculateSalaryChain.CalculateBonusByEmployeeOfTheMonth;
import com.source.service.EmployeeBonusService.calculateSalaryChain.CalculateBonusByServiceTime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author busat
 */
public class EmployeeBonusService {

    private final EmployeeBonusRepository employeeBonusRepository;

    public EmployeeBonusService(IDatabaseConnection connection) {
        employeeBonusRepository = new EmployeeBonusRepository(connection);
    }

    public void createEmployeesBonuses(List<EmployeeModel> employees) throws SQLException {
        ArrayList<EmployeeBonusDTO> employeeBonusList = new ArrayList();
        BonusCalculator bonusCalculator = BonusCalculator.link(
                new CalculateBonusByAssiduity(),
                new CalculateBonusByEmployeeOfTheMonth(),
                new CalculateBonusByServiceTime()
        );
        for (EmployeeModel employee : employees) {
            bonusCalculator.calculateBonus(employee, employeeBonusList);
        }
        employeeBonusRepository.createEmployeeBonus(employeeBonusList);
    }
    
    public List<EmployeeBonusModel> getEmployeeBonusesById(int id) throws SQLException{
        return employeeBonusRepository.getEmployeeBonusesById(id);
    }
}
