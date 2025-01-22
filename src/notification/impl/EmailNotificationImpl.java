package notification.impl;

import notification.Notification;

public class EmailNotificationImpl implements Notification {

    @Override
    public void send(String message, String to) {
        System.out.println(" Email send to " + to + ": " + message);
    }
}
