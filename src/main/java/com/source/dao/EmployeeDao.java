/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dao;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 *
 * @author busat
 */
public class EmployeeDao implements IDao<EmployeeDTO> {

    private final IDatabaseConnection connection;

    public EmployeeDao(IDatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public int create(EmployeeDTO entity) throws SQLException {
        String valuesFormat = String.format(Locale.US, "('%s', '%s', '%s', '%s', "
                + "'%s', '%s', '%d', '%d')", entity.getName(), entity.getRole(), entity.getBaseSalary(),
                entity.getDistanceFromWork(), entity.getServiceTime(), entity.getCreatedAt(), entity.getAbsencesFromWork(), entity.getEmployeeOfTheMonth());
        String query = "INSERT INTO employee (name, role, base_salary, distance_from_work, service_time, created_at, absences_from_work, employee_of_the_month) VALUES "
                + valuesFormat;
        connection.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        ResultSet rs = statement.executeQuery("SELECT MAX(id) as last_id from employee");
        int id = rs.getInt("last_id");
        connection.disconnect();
        return id;

    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "Delete from employee where id = " + id;
        connection.connect();
        connection.createStatement().executeUpdate(query);
        connection.disconnect();

    }

    @Override
    @SuppressWarnings("null")
    public ResultSet read(int id) throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "Select * from employee where id = " + id;
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;

    }

    @Override
    public void update(EmployeeDTO entity) throws SQLException {
        String query = String.format(Locale.US, "UPDATE employee SET name = '%s'"
                + ", role = '%s', base_salary = '%s', distance_from_work = '%s'"
                + ", service_time = '%s', absences_from_work = '%d', employee_of_the_month = '%d' where id = %d",
                entity.getName(), entity.getRole(),
                entity.getBaseSalary(), entity.getDistanceFromWork(),
                entity.getServiceTime(), entity.getAbsencesFromWork(), entity.getEmployeeOfTheMonth(),
                entity.getId());
        connection.connect();
        connection.createStatement().execute(query);
        connection.disconnect();

    }

    @Override
    public ResultSet getAll() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "Select * from employee";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getAllByName(String name) throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "Select * from employee where name like '" + name + "%'";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getAllRoles() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "Select role from employee";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getAverageSalarys() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "SELECT AVG(base_salary) as salary_avg from employee ";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getSumSalarys() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "SELECT SUM(base_salary) as salary_sum from employee ";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getHighestSalary() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "SELECT MAX(base_salary) as max_salary from employee ";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getLowestSalary() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "SELECT MIN(base_salary) as min_salary from employee ";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    public ResultSet getTotalSalarys() throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "SELECT count(base_salary) as total_salarys from employee ";
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }
}
