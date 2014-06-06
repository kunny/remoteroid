package com.androidhuman.remoteroid.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/**
 * Notification listener service for Jellybean MR2 (Android 4.3) or higher.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RDNotificationListenerService extends NotificationListenerService {
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

    }
}
