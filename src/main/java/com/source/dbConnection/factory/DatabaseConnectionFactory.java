/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.source.dbConnection.factory;

import com.source.dbConnection.connections.IDatabaseConnection;

/**
 *
 * @author busat
 */
public interface DatabaseConnectionFactory {
    IDatabaseConnection getConnection();
}
