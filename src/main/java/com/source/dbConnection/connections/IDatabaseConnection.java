/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.source.dbConnection.connections;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author busat
 */
public interface IDatabaseConnection {
    boolean connect() throws SQLException;
    boolean disconnect() throws SQLException;
    Statement createStatement() throws SQLException;
    PreparedStatement createPreparedStatement(String sql) throws SQLException;
}
