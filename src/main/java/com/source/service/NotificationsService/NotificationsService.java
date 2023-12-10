/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.service.NotificationsService;

import com.logger.helpers.enums.LogTypeEnum;
import com.source.dbConnection.connections.IDatabaseConnection;
import com.source.model.NotificationsModel;
import com.source.repository.NotificationsRepository;
import com.source.utils.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mauricio
 */
public class NotificationsService {

    private final NotificationsRepository notificationsRepository;

    public NotificationsService(IDatabaseConnection connection) {
        notificationsRepository = new NotificationsRepository(connection);
    }

    public List<NotificationsModel> listAllUserNotifications(int id) {
        List<NotificationsModel> notifications = new ArrayList<>();

        try {
            notifications = notificationsRepository.listAllUserNotifications(id);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, null, "LISTAGEM DE NOTIFICAÇÕES");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao listar notificações", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    null, "LISTAGEM DE NOTIFICAÇÕES", ex.getMessage());
        }
        return notifications;
    }

    public List<NotificationsModel> listAllUnreadUserNotifications(int id) {
        List<NotificationsModel> notifications = new ArrayList<>();

        try {
            notifications = notificationsRepository.listAllUnreadUserNotifications(id);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, null, "LISTAGEM DE NOTIFICAÇÕES NÃO LIDAS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao listar notificações não lidas", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    null, "LISTAGEM DE NOTIFICAÇÕES NÃO LIDAS", ex.getMessage());
        }
        return notifications;
    }

    public void markAsReadNotification(int id) {
        try {
            notificationsRepository.markAsReadNotification(id);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, null, "MARCAÇÃO DE NOTIFICAÇÃO COMO LIDA");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao marcar notificação como lida", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    null, "MARCAÇÃO DE NOTIFICAÇÃO COMO LIDA", ex.getMessage());
        }
    }

    public int totalUnreadUserNotifications(int userId) {
        int total = 0;

        try {
            total = notificationsRepository.totalUnreadNotifications(userId);

            Logger.writeSystemInfoLog(LogTypeEnum.INFO, null, "BUSCA DE TOTAL DE NOTIFICAÇÕES NÃO LIDAS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao buscar total de notificações não lidas", JOptionPane.ERROR_MESSAGE);
            Logger.writeSystemErrorLog(LogTypeEnum.ERROR,
                    null, "BUSCA DE TOTAL DE NOTIFICAÇÕES NÃO LIDAS", ex.getMessage());
        }

        return total;
    }

}
