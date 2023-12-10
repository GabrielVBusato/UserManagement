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
public class MainStrategyFactory {
    public static MainStrategy createMainStrategy(String userType) throws Exception {
        String className = "com.source.presenters.MainPresenter.Strategies." + userType + "Strategy";

        Class<?> menuClass = Class.forName(className);

        Constructor<?> constructor = menuClass.getConstructor();

        MainStrategy menuStrategy = (MainStrategy) constructor.newInstance();
        return menuStrategy;
    }
    
}
