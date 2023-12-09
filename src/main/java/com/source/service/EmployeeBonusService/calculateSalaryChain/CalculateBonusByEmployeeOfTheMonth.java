/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeBonusService.calculateSalaryChain;

import com.source.dto.EmployeeBonusDTO;
import com.source.model.EmployeeBonusModel;
import com.source.model.EmployeeModel;
import com.source.utils.DateUtils;
import java.util.ArrayList;

/**
 *
 * @author busat
 */
public class CalculateBonusByEmployeeOfTheMonth extends BonusCalculator {

    @Override
    public boolean calculateBonus(EmployeeModel employee,
            ArrayList<EmployeeBonusDTO> employeeBonusList) {
        EmployeeBonusDTO employeeBonus = new EmployeeBonusDTO();
        Double employeeOfTheMonthValueBonus = 150.00;

        employeeBonus.setIdBonus(3);
        employeeBonus.setIdEmployee(employee.getId());
        employeeBonus.setCreatedAt(DateUtils.getFormattedCurrentDate());

        if (employee.getEmployeeOfTheMonth() == 1) {
            employeeBonus.setBonusValue(employeeOfTheMonthValueBonus);

        } else {
            employeeBonus.setBonusValue(0.0);
        }

        if (employeeBonus.getBonusValue() != 0) {
            employeeBonusList.add(employeeBonus);
            employee.setBonusTotal(employee.getBonusTotal() + employeeBonus.getBonusValue());
        }
        return checkNext(employee, employeeBonusList);
    }

}
