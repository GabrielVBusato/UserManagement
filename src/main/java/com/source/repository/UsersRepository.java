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

//    public EmployeeModel getEmployeeById(int id) throws SQLException {
//        ResultSet result = employeeDao.read(id);
//        EmployeeModel employee = new EmployeeModel();
//        while (result.next()) {
//            employee.setId(result.getInt("id"));
//            employee.setName(result.getString("name"));
//            employee.setRole(result.getString("role"));
//            employee.setBaseSalary(result.getString("base_salary"));
//            employee.setDistanceFromWork(result.getString("distance_from_work"));
//            employee.setServiceTime(result.getString("service_time"));
//            employee.setCreatedAt(result.getString("created_at"));
//            employee.setTotalAbsencesFromWork(result.getInt("absences_from_work"));
//            employee.setEmployeeOfTheMonth(result.getInt("employee_of_the_month"));
//        }
//        connection.disconnect();
//        return employee;
//    }
    public UsersModel createUser(UsersModel user) throws SQLException {
        int id = usersDao.create(user);
        ResultSet result = usersDao.read(id);
        
        UsersModel newUser = new UsersModel();
        
        newUser.setId(id);
        newUser.setName(result.getString("name"));
        newUser.setType(result.getString("type"));
        newUser.setAuthorized(result.getInt("authorized"));
        newUser.setCreatedAt(result.getString("created_at"));
        connection.disconnect();
        
        return newUser;
    }

    public boolean isAuthorized(int id) throws SQLException {
        ResultSet result = usersDao.read(id);
        Boolean isAuthorized = result.getBoolean("authorized");
        connection.disconnect();
        
        return isAuthorized;
    }
    
    public UsersModel readByUsername(String username) throws SQLException {
        ResultSet result = usersDao.readByUsername(username);
        
        UsersModel user = new UsersModel();
        
        user.setId(result.getInt("id"));
        user.setName(result.getString("name"));
        user.setType(result.getString("type"));
        user.setAuthorized(result.getInt("authorized"));
        user.setPassword(result.getString("password"));
        user.setCreatedAt(result.getString("created_at"));
        
        connection.disconnect();
        return user;
    }

    public boolean existThereAnyUser() throws SQLException {
        ResultSet result = usersDao.getAll();
        Boolean existsThereAnyUser = result.next();
        
        connection.disconnect();
        return existsThereAnyUser;
    }

//    public List<EmployeeModel> getAllEmployees() throws SQLException {
//        ResultSet result = employeeDao.getAll();
//        List<EmployeeModel> employees = new ArrayList<>();
//        while (result.next()) {
//            EmployeeModel employee = new EmployeeModel();
//            employee.setId(result.getInt("id"));
//            employee.setName(result.getString("name"));
//            employee.setRole(result.getString("role"));
//            employee.setBaseSalary(result.getString("base_salary"));
//            employee.setDistanceFromWork(result.getString("distance_from_work"));
//            employee.setServiceTime(result.getString("service_time"));
//            employee.setCreatedAt(result.getString("created_at"));
//            employee.setTotalAbsencesFromWork(result.getInt("absences_from_work"));
//            employee.setEmployeeOfTheMonth(result.getInt("employee_of_the_month"));
//            employees.add(employee);
//        }
//        connection.disconnect();
//        return employees;
//    }
}
