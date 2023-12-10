package com.source.utils;

import com.logger.business.log.logTypes.LogBuilder;
import com.logger.business.log.logTypes.LogErrorBuilder;
import com.logger.business.log.logTypes.LogInfoBuilder;
import com.logger.business.log.structure.LogDirector;
import com.logger.helpers.enums.FileTypeEnum;
import com.logger.helpers.enums.LogTypeEnum;
import com.logger.services.LogService;
import com.source.model.UsersModel;
import com.source.session.UserSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author busat
 */
public class Logger {

    public static LogService logService;
    public static LogDirector director;

    private static void initialize() {
        if (logService == null) {
            logService = new LogService();
            logService.setFileType(FileTypeEnum.JSON);
            director = new LogDirector("");
            logService.setDirector(director);
        }
        UsersModel adminUser = UserSession.getInstance().getCurrentUser();

        if (adminUser != null) {
            director.setAdminUserName(UserSession.getInstance().getCurrentUser().getName());
            if (adminUser.getType().equals("User")) director.setContactName(adminUser.getName());
            if (adminUser.getType().equals("Admin")) director.setContactName(adminUser.getName());
        } else {
            director.setAdminUserName("Sem administrador");
        }

    }

    public static void writeSystemInfoLog(LogTypeEnum logType,
            String userName,
            String operation) {
        initialize();

        if (userName != null) director.setContactName(userName);
        director.setOperation(operation);
        LogBuilder infoLogger = new LogInfoBuilder();
        logService.writeSystemLogFile(logType, infoLogger);
    }

    public static void writeSystemErrorLog(LogTypeEnum logType,
            String userName,
            String operation,
            String message) {
        initialize();

        director.setContactName(userName);
        director.setOperation(operation);
        director.setMessage(message);
        LogBuilder errorLogger = new LogErrorBuilder();
        logService.writeSystemLogFile(logType, errorLogger);
    }

    public static void writeExceptionLog(String message) {
        initialize();

        director.setMessage(message);
        logService.writeExceptionFileLog();
    }
}
