/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.repository;

import com.source.dao.UsersDao;
import com.source.model.UsersModel;
import com.source.dbConnection.connections.IDatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author busat
 */
public class UsersRepository {

    private final UsersDao usersDao;
    private final IDatabaseConnection connection;

    public UsersRepository(IDatabaseConnection connection) {
        usersDao = new UsersDao(connection);
        this.connection = connection;
    }

    public UsersModel createUser(UsersModel user) throws SQLException {
        int id = usersDao.create(user);
        ResultSet result = usersDao.read(id);
        
        UsersModel newUser = new UsersModel();
        newUser.parseData(result);
        
        connection.disconnect();
        
        return newUser;
    }

    public boolean isAuthorized(int id) throws SQLException {
        ResultSet result = usersDao.read(id);
        Boolean isAuthorized = result.getBoolean("authorized");
        connection.disconnect();
        
        return isAuthorized;
    }
    
    public List<UsersModel> getAllUnauthorized() throws SQLException {
        ResultSet result = usersDao.getAllUnauthorized();
        
        List<UsersModel> unauthorizedUsers = new ArrayList<>();
        
        while(result.next()) {
            UsersModel user = new UsersModel();
            user.parseData(result);
            unauthorizedUsers.add(user);
        }
        
        connection.disconnect();
        
        return unauthorizedUsers;
    }
    
    public List<UsersModel> getAll() throws SQLException {
        ResultSet result = usersDao.getAll();
        
        List<UsersModel> users = new ArrayList<>();
        
        while(result.next()) {
            UsersModel user = new UsersModel();
            user.parseData(result);
            users.add(user);
        }
        
        connection.disconnect();
        
        return users;
    }
    
    public UsersModel readByUsername(String username) throws SQLException {
        ResultSet result = usersDao.readByUsername(username);
        
        UsersModel user = new UsersModel();
        user.parseData(result);
        
        connection.disconnect();
        return user;
    }

    public boolean existThereAnyUser() throws SQLException {
        ResultSet result = usersDao.getAll();
        Boolean existsThereAnyUser = result.next();
        
        connection.disconnect();
        return existsThereAnyUser;
    }
    
    public void updateUser(UsersModel user) throws SQLException {
        usersDao.update(user);
    }
}
