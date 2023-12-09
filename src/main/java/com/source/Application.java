/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.source;

import com.source.dbConnection.factory.DatabaseConnectionFactory;
import com.source.dbConnection.factory.SqliteConnectionFactory;
import com.source.presenter.MainPresenter;




/**
 *
 * @author busat
 */
public class Application {

    public static void main(String[] args) {
      DatabaseConnectionFactory connection = new SqliteConnectionFactory();
      new MainPresenter(connection.getConnection());
    }
}
