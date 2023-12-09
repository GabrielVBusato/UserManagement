/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dao;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dto.EmployeeBonusDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author busat
 */
public class EmployeeBonusDao implements IDao<EmployeeBonusDTO> {

    private final IDatabaseConnection connection;

    public EmployeeBonusDao(IDatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public int create(EmployeeBonusDTO entity) throws SQLException {
        String valuesFormat = String.format("('%d', '%d', '%s', '%f')", entity.getIdEmployee(),
                entity.getIdBonus(), entity.getCreatedAt(), entity.getBonusValue());
        String query = "INSERT INTO employee_bonus (id_employee, id_bonus, created_at, bonus_value) VALUES "
                + valuesFormat;
        connection.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        connection.disconnect();
        return 1;
    }

    public int createBatch(List<EmployeeBonusDTO> entities) throws SQLException {
        String query = "INSERT INTO employee_bonus (id_employee, id_bonus, created_at, bonus_value) VALUES (?, ?, ?, ?)";
        connection.connect();
        PreparedStatement statement = connection.createPreparedStatement(query);
        for (EmployeeBonusDTO entity : entities) {
            statement.setInt(1, entity.getIdEmployee());
            statement.setInt(2, entity.getIdBonus());
            statement.setString(3, entity.getCreatedAt());
            statement.setDouble(4, entity.getBonusValue());
            statement.addBatch();
            statement.clearParameters();
        }
        statement.executeBatch();
        connection.disconnect();
        return 1;
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public ResultSet read(int id) throws SQLException {
        ResultSet result;
        Statement statement;
        String query = "select emp.name as employee_name, emp.role, empb.created_at, bon.name, "
                + "empb.bonus_value, emp.id as id_employee, bon.id as id_bonus from employee as emp join employee_bonus as empb "
                + "on empb.id_employee = emp.id join bonus as bon\n"
                + "on bon.id = empb.id_bonus where emp.id = " + id;
        connection.connect();
        statement = connection.createStatement();
        result = statement.executeQuery(query);
        return result;
    }

    @Override
    public void update(EmployeeBonusDTO entity) throws SQLException {
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }
}
