/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dto;

import com.source.model.EmployeeModel;

/**
 *
 * @author busat
 */
public class EmployeeDTO {
   
    private int id;
    private String name;
    private String role;
    private String baseSalary;
    private String distanceFromWork;
    private String serviceTime;
    private String createdAt;
    private int absencesFromWork;
    private int employeeOfTheMonth;

    public EmployeeDTO(EmployeeModel employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.role = employee.getRole();
        this.baseSalary = employee.getBaseSalary();
        this.distanceFromWork = employee.getDistanceFromWork();
        this.serviceTime = employee.getServiceTime();
        this.createdAt = employee.getCreatedAt();
        this.absencesFromWork = employee.getTotalAbsencesFromWork();
        this.employeeOfTheMonth = employee.getEmployeeOfTheMonth();
    }
    
    public int getEmployeeOfTheMonth() {
        return employeeOfTheMonth;
    }

    public void setEmployeeOfTheMonth(int employeeOfTheMonth) {
        this.employeeOfTheMonth = employeeOfTheMonth;
    }

    public int getAbsencesFromWork() {
        return absencesFromWork;
    }

    public void setAbsencesFromWork(int absencesFromWork) {
        this.absencesFromWork = absencesFromWork;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setDistanceFromWork(String distanceFromWork) {
        this.distanceFromWork = distanceFromWork;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public String getDistanceFromWork() {
        return distanceFromWork;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", role=" + role + ", baseSalary=" + baseSalary + ", distanceFromWork=" + distanceFromWork + ", serviceTime=" + serviceTime + ", createdAt=" + createdAt + '}';
    }
    
    
    
}
