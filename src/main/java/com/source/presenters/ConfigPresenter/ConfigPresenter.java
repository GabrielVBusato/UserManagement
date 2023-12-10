/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.ConfigPresenter;

import com.logger.helpers.enums.FileTypeEnum;
import com.logger.helpers.enums.LogTypeEnum;
import com.source.utils.Logger;
import com.source.view.ConfigView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author busat
 */
public class ConfigPresenter {

    private static ConfigView view = null;
    private static ConfigPresenter instance = null;

    private ConfigPresenter() {
        if (view == null) {
            view = new ConfigView();
        }
    }

    public static ConfigPresenter getInstance() {
        if (instance == null) {
            instance = new ConfigPresenter();
        }

        initComponents();
        view.setVisible(true);
        return instance;
    }

    private static void initComponents() {
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cbLogType = view.getCbLogType();

                // Obtém o valor selecionado
                String selectedValueString = (String) cbLogType.getSelectedItem();
                FileTypeEnum selectedValue = FileTypeEnum.valueOf(selectedValueString);
                Logger.setLogType(selectedValue);
                JOptionPane.showMessageDialog(null, "Tipo do arquivo do log foi alterado com sucesso",
                        "Tipo de arquivo de log", JOptionPane.INFORMATION_MESSAGE);
                view.dispose();
            }
        });

        JComboBox<String> cbLogType = view.getCbLogType();

        cbLogType.removeAllItems();

        for (FileTypeEnum fileType : FileTypeEnum.values()) {
            cbLogType.addItem(fileType.name());
        }
    }
}
