/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.source.service.EmployeeService.statisticsSalaryChain;

import com.source.service.EmployeeService.EmployeeService;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public abstract class StatisticChain {

    protected String name;
    protected String value;

    private StatisticChain next;

    public static StatisticChain link(StatisticChain first,
            StatisticChain... chain) {
        StatisticChain head = first;
        for (StatisticChain nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract void calculate(EmployeeService service) throws SQLException;

    protected void checkNext(EmployeeService service) throws SQLException {
        if (next != null) {
            next.calculate(service);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
