/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.dbConnection.factory;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.dbConnection.connections.SqliteConnection;

/**
 *
 * @author busat
 */
public class SqliteConnectionFactory implements DatabaseConnectionFactory {

    @Override
    public IDatabaseConnection getConnection() {
        return new SqliteConnection();
    }
    
}
