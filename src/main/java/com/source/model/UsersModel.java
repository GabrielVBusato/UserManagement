/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mauricio
 */
public class UsersModel {

    private int id;
    private String name;
    private String password;
    private String type;
    private int authorized;
    private String createdAt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAuthorized() {
        return authorized;
    }

    public void setAuthorized(int authorized) {
        this.authorized = authorized;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UsersModel{" + "id=" + id + ", name=" + name + ", type=" + type + ", Authorized=" + authorized + ", createdAt=" + createdAt + '}';
    }
    
    public void parseData(ResultSet result) throws SQLException {
        this.setId(result.getInt("id"));
        this.setName(result.getString("name"));
        this.setType(result.getString("type"));
        this.setAuthorized(result.getInt("authorized"));
        this.setPassword(result.getString("password"));
        this.setCreatedAt(result.getString("created_at"));
    }
}
