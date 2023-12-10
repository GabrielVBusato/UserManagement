/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.exceptions;

/**
 *
 * @author busat
 */
public class FailedValidationException extends Exception {
    public FailedValidationException(String field){
        super("Validação falhou para o campo: " + field);
    }
}
