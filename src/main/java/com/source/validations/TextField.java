/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.validations;

import com.source.exceptions.FailedValidationException;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public class TextField {

    private final String value;
    private final String name;

    public TextField(String value,
            String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void validateNotNull() throws FailedValidationException {
        if (value == null || value.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campo " + name + " está vazio.",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE
            );
            throw new FailedValidationException(name);
        }
    }
    
    public void validateNotEquals(String secondValue)throws FailedValidationException {
        if(!value.equals(secondValue)) {
            JOptionPane.showMessageDialog(null, "As senhas não são iguais",
                    "Validação de senha", JOptionPane.ERROR_MESSAGE
            );
            throw new FailedValidationException("Nova senha");
        }
    }
}
