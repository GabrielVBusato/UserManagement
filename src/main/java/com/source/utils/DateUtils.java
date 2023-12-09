/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author busat
 */
public class DateUtils {
    public static String getFormattedCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateObj.format(formatter);
    }
}
