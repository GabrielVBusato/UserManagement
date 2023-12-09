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
public class CalculateBonusByServiceTime extends BonusCalculator {

    @Override
    public boolean calculateBonus(EmployeeModel employee,
            ArrayList<EmployeeBonusDTO> employeeBonusList) {
        Integer bonusByServiceTime = 0;
        Integer serviceTime = (int) Double.parseDouble(employee.getServiceTime());

        if (serviceTime >= 20) {
            bonusByServiceTime = 15;
        } else if (NumberUtil.isBetween(serviceTime, 16, 20)) {
            bonusByServiceTime = 10;
        } else if (NumberUtil.isBetween(serviceTime, 11, 15)) {
            bonusByServiceTime = 8;
        } else if (NumberUtil.isBetween(serviceTime, 6, 10)) {
            bonusByServiceTime = 3;
        } else if (NumberUtil.isBetween(serviceTime, 1, 5)) {
            bonusByServiceTime = 2;
        }

        EmployeeBonusDTO employeeBonus = new EmployeeBonusDTO();
        employeeBonus.setIdBonus(4);
        employeeBonus.setIdEmployee(employee.getId());
        employeeBonus.setCreatedAt(DateUtils.getFormattedCurrentDate());
        employeeBonus.setBonusValue((double) bonusByServiceTime / 100
                * Double.parseDouble(employee.getBaseSalary()));

        if (employeeBonus.getBonusValue() != 0) {
            employeeBonusList.add(employeeBonus);
            employee.setBonusTotal(employee.getBonusTotal() + employeeBonus.getBonusValue());
        }
        return checkNext(employee, employeeBonusList);
    }

}
