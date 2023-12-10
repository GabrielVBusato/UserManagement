/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter.Strategies;

import com.source.presenters.ListNotificationsPresenter.ListNotificationsPresenter;
import com.source.presenters.MainPresenter.MainPresenter;
import com.source.presenters.MainPresenter.MainStrategy;
import com.source.presenters.UnauthenticatedUsersPresenter.UnauthenticatedUsersPresenter;
import com.source.service.NotificationsService.NotificationsService;
import com.source.session.UserSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public class UserStrategy implements MainStrategy {

    public UserStrategy() {
    }

    @Override
    public void configureMainView(MainPresenter presenter) {
        NotificationsService service = new NotificationsService(presenter.getConnection());
        presenter.getView().getMenuItemAuthUser().setVisible(false);
        presenter.getView().getMenuItemListUsers().setVisible(false);
        presenter.getView().getMenuItemSendNotification().setVisible(false);
        presenter.getView().getMenuItemChangePassword().setVisible(true);
        presenter.getView().getMenuItemListNotifications().setVisible(true);
        presenter.getView().getLblDummyNewNotifications().setVisible(true);
        presenter.getView().getBtnNewNotifications().setVisible(true);
        presenter.getView().getMenuItemListNotifications().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListNotificationsPresenter.getInstance(presenter.getConnection());
            }
        });
        
        presenter.getView().getBtnNewNotifications().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListNotificationsPresenter.getInstance(presenter.getConnection());
            }
        });
        int totalUnreadUserNotifications = service.totalUnreadUserNotifications(UserSession.getInstance().getCurrentUser().getId());
        presenter.getView().getBtnNewNotifications()
                .setText(String.valueOf(totalUnreadUserNotifications));
    }
}
