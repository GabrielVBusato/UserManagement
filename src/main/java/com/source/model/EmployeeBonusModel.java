/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.model;

/**
 *
 * @author busat
 */
public class EmployeeBonusModel {
    private int idEmployee;
    private int idBonus;
    private String createdAt;
    private Double bonusValue;
    private String bonusName;
    private String employeeRole;
    private String employeeName;

    public EmployeeBonusModel() {
        this.bonusValue = 0.0;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    @Override
    public String toString() {
        return "EmployeeBonusModel{" + "idEmployee=" + idEmployee + ", idBonus=" + idBonus + ", createdAt=" + createdAt + ", bonusValue=" + bonusValue + '}';
    }
}
