/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dto;

import com.source.model.EmployeeBonusModel;

/**
 *
 * @author busat
 */
public class EmployeeBonusDTO {
    private int idEmployee;
    private int idBonus;
    private String createdAt;
    private Double bonusValue;

    public EmployeeBonusDTO(EmployeeBonusModel employeeBonus) {
        idEmployee = employeeBonus.getIdEmployee();
        idBonus = employeeBonus.getIdBonus();
        createdAt = employeeBonus.getCreatedAt();
        bonusValue = employeeBonus.getBonusValue();
    }
    
    public EmployeeBonusDTO() {
        
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdBonus() {
        return idBonus;
    }

    public void setIdBonus(int idBonus) {
        this.idBonus = idBonus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(Double bonusValue) {
        this.bonusValue = bonusValue;
    }
  
    
}
