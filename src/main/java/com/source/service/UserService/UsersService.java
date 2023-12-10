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
import java.util.ArrayList;
import java.util.List;
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

    public UsersModel findUserByUsername(String name) {
        UsersModel user;
        try {
            user = usersRepository.readByUsername(name);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, user.getName(), "FIND_USER");
            return user;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao buscar usuário por nome", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    name, "FIND_USER", ex.getMessage());
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
                    "Erro ao tentar fazer login", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    name, "LOGIN", ex.getMessage());
        }
        return null;
    }

    public List<UsersModel> listUnauthorizedUsers() {
        List<UsersModel> users = new ArrayList<>();

        try {
            users = usersRepository.getAllUnauthorized();

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, "<< no user >>", "LISTAGEM DE USUÁRIOS NÃO AUTORIZADOS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao buscar usuários não autorizados", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    "<< no user >>", "LISTAGEM DE USUÁRIOS NÃO AUTORIZADOS", ex.getMessage());
        }

        return users;
    }
    
    public List<UsersModel> listAllUsers() {
        List<UsersModel> users = new ArrayList<>();

        try {
            users = usersRepository.getAll();

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, "<< no user >>", "LISTAGEM DE USUÁRIOS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao buscar usuários não autorizados", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    "<< no user >>", "LISTAGEM DE USUÁRIOS NÃO AUTORIZADOS", ex.getMessage());
        }

        return users;
    }

    public UsersModel updateUser(UsersModel user) {
        try {
            usersRepository.updateUser(user);
            
            
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso",
                    "Usuário atualizado", JOptionPane.INFORMATION_MESSAGE);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, "<< no user >>", "ATUALIZAÇÃO DE USUÁRIO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao atualizar usuário", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    "<< no user >>", "ATUALIZAÇÃO DE USUÁRIO", ex.getMessage());
        }

        return user;
    }
}
