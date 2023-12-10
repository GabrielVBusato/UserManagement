/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter;

import java.lang.reflect.Constructor;

/**
 *
 * @author busat
 */
public class MenuStrategyFactory {
    public static MenuStrategy createMenu(String userType) throws Exception {
        String className = "com.source.presenters.MainPresenter.Strategies." + userType + "MenuStrategy";

        Class<?> menuClass = Class.forName(className);

        Constructor<?> constructor = menuClass.getConstructor();

        MenuStrategy menuStrategy = (MenuStrategy) constructor.newInstance();
        return menuStrategy;
    }
    
}
