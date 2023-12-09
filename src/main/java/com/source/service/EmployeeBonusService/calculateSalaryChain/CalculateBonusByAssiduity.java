/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeBonusService.calculateSalaryChain;

import com.source.dto.EmployeeBonusDTO;
import com.source.model.EmployeeBonusModel;
import com.source.model.EmployeeModel;
import com.source.utils.DateUtils;
import com.source.utils.NumberUtil;
import java.util.ArrayList;

/**
 *
 * @author busat
 */
public class CalculateBonusByAssiduity extends BonusCalculator {

    @Override
    public boolean calculateBonus(EmployeeModel employee,
            ArrayList<EmployeeBonusDTO> employeeBonusList) {
        Integer bonusByAssiduity = 0;
        int totalAbsencesFromWork = employee.getTotalAbsencesFromWork();

        if (totalAbsencesFromWork == 0) {
            bonusByAssiduity = 5;
        } else if (NumberUtil.isBetween(totalAbsencesFromWork, 1, 3)) {
            bonusByAssiduity = 3;
        } else if (NumberUtil.isBetween(totalAbsencesFromWork, 4, 5)) {
            bonusByAssiduity = 1;
        }

        EmployeeBonusDTO employeeBonus = new EmployeeBonusDTO();
        employeeBonus.setIdBonus(2);
        employeeBonus.setIdEmployee(employee.getId());
        employeeBonus.setCreatedAt(DateUtils.getFormattedCurrentDate());
        employeeBonus.setBonusValue((double) bonusByAssiduity / 100
                * Double.parseDouble(employee.getBaseSalary()));
        
        if (employeeBonus.getBonusValue() != 0) {
            employeeBonusList.add(employeeBonus);
            employee.setBonusTotal(employee.getBonusTotal() + employeeBonus.getBonusValue());
        }

        return checkNext(employee, employeeBonusList);
    }
}
