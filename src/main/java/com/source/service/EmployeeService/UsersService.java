/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.EmployeeService;

import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.exceptions.AuthenticateFailException;
import com.source.exceptions.UnauthorizedException;
import com.source.model.UsersModel;
import com.source.repository.UsersRepository;
import java.sql.SQLException;

/**
 *
 * @author busat
 */
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(IDatabaseConnection connection) {
        usersRepository = new UsersRepository(connection);
    }

    public UsersModel register(UsersModel user) throws SQLException {
        String type = "user";
        int authorized = 0;
        if (!usersRepository.existThereAnyUser()) {
            type = "admin";
            authorized = 1;
        }
        
        user.setType(type);
        user.setAuthorized(authorized);
        
        return usersRepository.createUser(user);        
    }
    
    public UsersModel login(String name, String password) throws SQLException, AuthenticateFailException, UnauthorizedException {
        UsersModel user = usersRepository.readByUsername(name);
        
        if (!usersRepository.checkAuthorized(user)) {
            throw new UnauthorizedException();
        }
        
        if (!user.getPassword().equals(password)) {
            throw new AuthenticateFailException();
        }
        
        return user;
    }
}
