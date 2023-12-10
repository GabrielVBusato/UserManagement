/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter.Strategies;

import com.source.presenters.MainPresenter.MainPresenter;
import com.source.presenters.MainPresenter.MenuStrategy;

/**
 *
 * @author busat
 */
public class AdminMenuStrategy implements MenuStrategy {

    public AdminMenuStrategy() {
    }

    @Override
    public void displayMenu(MainPresenter presenter) {
        presenter.getView().getMenuItemAuthUser().setVisible(true);
        presenter.getView().getMenuItemCreateUser().setVisible(true);
        presenter.getView().getMenuItemListUsers().setVisible(true);
        presenter.getView().getMenuItemSendNotification().setVisible(true);
        presenter.getView().getMenuItemChangePassword().setVisible(false);
        presenter.getView().getMenuItemListNotifications().setVisible(false);
    }
}
