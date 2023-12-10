/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.UserService;

import com.logger.helpers.enums.LogTypeEnum;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.exceptions.AuthenticateFailException;
import com.source.exceptions.UnauthorizedException;
import com.source.model.UsersModel;
import com.source.repository.UsersRepository;
import com.source.utils.Logger;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(IDatabaseConnection connection) {
        usersRepository = new UsersRepository(connection);
    }

    public UsersModel register(UsersModel user) {
        String type = "User";
        int authorized = 0;
        try {
            if (!usersRepository.existThereAnyUser()) {
                type = "Admin";
                authorized = 1;
            }

            user.setType(type);
            user.setAuthorized(authorized);

            UsersModel newUser = usersRepository.createUser(user);

            JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso",
                    "Usuário registrado", JOptionPane.INFORMATION_MESSAGE);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, user.getName(), "CRIAÇÃO");
            return newUser;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome já existente",
                    "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    user.getName(), "CRIAÇÃO", "nome já existente");
        }
        return null;
    }

    public UsersModel login(String name,
            String password) {
        UsersModel user;
        try {
            user = usersRepository.readByUsername(name);

            if (user.getAuthorized() == 0) {
                throw new UnauthorizedException();
            }

            if (!user.getPassword().equals(password)) {
                throw new AuthenticateFailException();
            }

             Logger.writeSystemInfoLog(LogTypeEnum.INFO, user.getName(), "LOGIN");
            return user;
        } catch (SQLException | UnauthorizedException | AuthenticateFailException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao testar fazer login", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    name, "LOGIN", ex.getMessage());
        }
        return null;
    }
}
