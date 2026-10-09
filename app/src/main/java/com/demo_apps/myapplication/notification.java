package com.demo_apps.myapplication;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class notification extends ComponentActivity {

    private static final String CHANNEL_ID = "my_notification_channel";
    private static final int NOTIFICATION_ID = 1;

    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        btnNotify = findViewById(R.id.btnNotify);
        createNotificationChannel();

        // Ask notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        100
                );
            }
        }

        btnNotify.setOnClickListener(v -> showNotification());
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "My Notifications";
            String description = "Notification Channel Example";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            name,
                            importance
                    );

            channel.setDescription(description);

            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification() {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Hello Qais!")
                        .setContentText("This notification was created by pressing the button.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        // Check permission before showing notification
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                        == PackageManager.PERMISSION_GRANTED) {

            notificationManager.notify(
                    NOTIFICATION_ID,
                    builder.build()
            );
        }
    }
}