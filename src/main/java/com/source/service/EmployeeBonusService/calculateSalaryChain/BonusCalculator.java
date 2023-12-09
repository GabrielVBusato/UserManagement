/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeBonusService.calculateSalaryChain;

import com.source.dto.EmployeeBonusDTO;
import com.source.model.EmployeeModel;
import java.util.ArrayList;

/**
 *
 * @author busat
 */
public abstract class BonusCalculator {

    private BonusCalculator next;

    public static BonusCalculator link(BonusCalculator first,
            BonusCalculator... chain) {
        BonusCalculator head = first;
        for (BonusCalculator nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }
    
    public abstract boolean calculateBonus(EmployeeModel employee, 
            ArrayList<EmployeeBonusDTO> employeeBonusList);
    
    protected boolean checkNext(EmployeeModel employee, ArrayList<EmployeeBonusDTO> employeeBonusList) {
        if (next == null) {
            return true;
        }
        return next.calculateBonus(employee, employeeBonusList);
    }
}
