/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.source.presenters.MainPresenter.Strategies;

import com.source.presenters.ChangePasswordPresenter.ChangePasswordPresenter;
import com.source.presenters.ListNotificationsPresenter.ListNotificationsPresenter;
import com.source.presenters.MainPresenter.MainPresenter;
import com.source.presenters.MainPresenter.MainStrategy;
import com.source.presenters.UnauthenticatedUsersPresenter.UnauthenticatedUsersPresenter;
import com.source.service.NotificationsService.NotificationsService;
import com.source.session.UserSession;
import com.source.session.UserSessionObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author busat
 */
public class UserStrategy implements MainStrategy, UserSessionObserver {
    
    private MainPresenter presenter;

    public UserStrategy() {
        UserSession.getInstance().addObserver(this);
    }

    @Override
    public void configureMainView(MainPresenter presenter) {
        this.presenter = presenter;
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
        presenter.getView().getMenuItemChangePassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordPresenter.getInstance(presenter.getConnection(), presenter.getUserService());
            }
        });

        presenter.getView().getBtnNewNotifications().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListNotificationsPresenter.getInstance(presenter.getConnection());
            }
        });
        int totalUnreadUserNotifications = service.totalUnreadUserNotifications(UserSession.getInstance().getCurrentUser().getId());
        UserSession.getInstance().setUserUnreadNotifications(totalUnreadUserNotifications);

    }

    @Override
    public void onUpdateUnreadNotifications(int totalUnreadUserNotifications) {
        this.presenter.getView().getBtnNewNotifications()
                .setText(String.valueOf(totalUnreadUserNotifications));
    }
}
