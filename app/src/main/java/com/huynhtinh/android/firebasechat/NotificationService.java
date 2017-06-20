package com.huynhtinh.android.firebasechat;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by TINH HUYNH on 6/19/2017.
 */

public class NotificationService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseNotification";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        RemoteMessage.Notification receivedNotification = remoteMessage.getNotification();
        Log.i(TAG, "onMessageReceived: " + receivedNotification.getTitle());
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(receivedNotification.getTitle())
                .setContentText(receivedNotification.getBody())
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}