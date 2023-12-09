/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.source;

import com.logger.services.LogService;
import com.source.dbConnection.factory.DatabaseConnectionFactory;
import com.source.dbConnection.factory.SqliteConnectionFactory;
import com.source.presenter.AuthenticationPresenter.AuthenticationPresenter;

/**
 *
 * @author busat
 */
public class Application {

    public static void main(String[] args) {
        DatabaseConnectionFactory connection = new SqliteConnectionFactory();
        LogService logService = new LogService();
        AuthenticationPresenter.getInstance(logService, connection.getConnection());
    }
}
