/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter.Strategies;

import com.source.presenters.MainPresenter.MainPresenter;
import com.source.presenters.MainPresenter.MainStrategy;

/**
 *
 * @author busat
 */
public class UserStrategy implements MainStrategy {

    public UserStrategy() {
    }

    @Override
    public void configureMainView(MainPresenter presenter) {
        presenter.getView().getMenuItemAuthUser().setVisible(false);
        presenter.getView().getMenuItemListUsers().setVisible(false);
        presenter.getView().getMenuItemSendNotification().setVisible(false);
        presenter.getView().getMenuItemChangePassword().setVisible(true);
        presenter.getView().getMenuItemListNotifications().setVisible(true);
        presenter.getView().getLblDummyNewNotifications().setVisible(true);
        presenter.getView().getBtnNewNotifications().setVisible(true);
    }
}
