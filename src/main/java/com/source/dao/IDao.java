/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.source.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author busat
 * @param <U>
 */
public interface IDao<U> {
    int create(U entity) throws SQLException;
    void delete(int id) throws SQLException;
    ResultSet read(int id) throws SQLException;
    void update(U entity) throws SQLException;
    ResultSet getAll() throws SQLException;
}
