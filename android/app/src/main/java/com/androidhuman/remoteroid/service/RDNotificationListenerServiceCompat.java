package com.androidhuman.remoteroid.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/**
 * Notification listener service for Jellybean MR1 (Android 4.2) or lower.
 *
 * Since official NotificationListenerService is supported on Android 4.3
 * or higher, we use AccessibilityService instead.
 */
public class RDNotificationListenerServiceCompat extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2){
            // TODO Alert user or redirect
            stopSelf();
        }

        // Announce service info for pre-ICS devices
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

    }

    @Override
    public void onInterrupt() {

    }
}
