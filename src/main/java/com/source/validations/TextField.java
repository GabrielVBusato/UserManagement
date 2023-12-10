/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.validations;

import com.pss.senha.validacao.ValidadorSenha;
import com.source.exceptions.FailedValidationException;
import java.util.ArrayList;
import java.util.List;
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

    public void validatePassword() throws FailedValidationException {
        ValidadorSenha validador = new ValidadorSenha();
        List<String> resultado = validador.validar(value);
        if (!resultado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo "
                    + name + " está inválido. " + resultado.get(0),
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE
            );
            throw new FailedValidationException(name);
        }

    }
}
