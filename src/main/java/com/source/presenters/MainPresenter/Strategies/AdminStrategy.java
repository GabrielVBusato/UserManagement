/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter.Strategies;

import com.source.presenters.MainPresenter.MainPresenter;
import com.source.presenters.MainPresenter.MainStrategy;
import com.source.presenters.SearchUserPresenter.SearchUserPresenter;
import com.source.presenters.SendNotificationPresenter.SendNotificationPresenter;
import com.source.presenters.UnauthenticatedUsersPresenter.UnauthenticatedUsersPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public class AdminStrategy implements MainStrategy {

    public AdminStrategy() {
    }

    @Override
    public void configureMainView(MainPresenter presenter) {
        presenter.getView().getMenuItemAuthUser().setVisible(true);
        presenter.getView().getMenuItemListUsers().setVisible(true);
        presenter.getView().getMenuItemSendNotification().setVisible(true);
        presenter.getView().getMenuItemChangePassword().setVisible(false);
        presenter.getView().getMenuItemListNotifications().setVisible(false);
        presenter.getView().getLblDummyNewNotifications().setVisible(false);
        presenter.getView().getBtnNewNotifications().setVisible(false);
        presenter.getView().getMenuItemListUsers().setVisible(true);
        presenter.getView().getMenuItemListUsers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchUserPresenter.getInstance(presenter.getConnection(), presenter.getUserService());
            }
        });
        presenter.getView().getMenuItemAuthUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnauthenticatedUsersPresenter.getInstance(presenter.getConnection(), presenter.getUserService());
            }
        });
        presenter.getView().getMenuItemSendNotification().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendNotificationPresenter.getInstance(presenter.getConnection(), 
                        presenter.getUserService());
            }
        });
    }
}
