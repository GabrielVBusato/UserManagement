/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.exceptions;

/**
 *
 * @author Mauricio
 */
public class AuthenticateFailException extends Exception {
    public AuthenticateFailException() {
        super("Usuário não autenticado.");
    }
}
