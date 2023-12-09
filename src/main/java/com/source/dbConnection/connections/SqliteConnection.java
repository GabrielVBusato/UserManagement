/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dbConnection.connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author busat
 */
public class SqliteConnection implements IDatabaseConnection {

    private static Connection connection;
    
    @Override
    public boolean connect() throws SQLException {
        String url = "jdbc:sqlite:database/employee_management.db";
        SqliteConnection.connection = DriverManager.getConnection(url);
        return true;
    }

    @Override
    public boolean disconnect() throws SQLException {
        if (!SqliteConnection.connection.isClosed()) {
            SqliteConnection.connection.close();
        }
        return true;
    }
    
    @Override
    public Statement createStatement() throws SQLException {
        return SqliteConnection.connection.createStatement();
    }

    @Override
    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return SqliteConnection.connection.prepareStatement(sql);
    }

}
