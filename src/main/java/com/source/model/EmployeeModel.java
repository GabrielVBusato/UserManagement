/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.model;

/**
 *
 * @author busat
 */
public class EmployeeModel {

    private int id;
    private String name;
    private String role;
    private String baseSalary;
    private Double bonusTotal;
    private int totalAbsencesFromWork;
    private String distanceFromWork;
    private String serviceTime;
    private String createdAt;
    private int employeeOfTheMonth;

    public EmployeeModel() {
        this.bonusTotal = 0.0;
    }
    
    public int getEmployeeOfTheMonth() {
        return employeeOfTheMonth;
    }

    public void setEmployeeOfTheMonth(int employeeOfTheMonth) {
        this.employeeOfTheMonth = employeeOfTheMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getBonusTotal() {
        return bonusTotal;
    }

    public void setBonusTotal(Double bonusTotal) {
        this.bonusTotal = bonusTotal;
    }

    public int getTotalAbsencesFromWork() {
        return totalAbsencesFromWork;
    }

    public void setTotalAbsencesFromWork(int totalAbsencesFromWork) {
        this.totalAbsencesFromWork = totalAbsencesFromWork;
    }

    public String getDistanceFromWork() {
        return distanceFromWork;
    }

    public void setDistanceFromWork(String distanceFromWork) {
        this.distanceFromWork = distanceFromWork;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" + "id=" + id + ", name=" + name + ", role=" + role + ", baseSalary=" + baseSalary + ", bonusTotal=" + bonusTotal + ", totalAbsencesFromWork=" + totalAbsencesFromWork + ", distanceFromWork=" + distanceFromWork + ", serviceTime=" + serviceTime + ", createdAt=" + createdAt + '}';
    }

}
