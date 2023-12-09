/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeService.statisticsSalaryChain;

import com.source.service.EmployeeService.EmployeeService;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public class TotalNumberOfSalarys extends StatisticChain {

    public TotalNumberOfSalarys() {
        this.name = "Quantidade de salários no mês";
    }

    @Override
    public void calculate(EmployeeService service) throws SQLException {
        this.value = String.format(service.getTotalSalarysByMonth().getValue());
    }

}
