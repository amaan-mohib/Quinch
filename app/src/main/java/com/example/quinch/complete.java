package com.example.quinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.animation.ObjectAnimator;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class complete extends AppCompatActivity {
    public ProgressBar mprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        Intent intent=getIntent();
        String score=intent.getStringExtra("point1");
        final TextView point=findViewById(R.id.score);
        point.setText(score);

        int endvalue=Integer.parseInt(score);
        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, endvalue);
        anim.setDuration(1000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.WHITE);
            notificationChannel.setVibrationPattern(new long[]{0, 100});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.trophy);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_stat_name)

                .setLargeIcon(largeIcon)
                .setTicker("Hearty365")
                //     .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Your Score: ")
                .setContentText(score)
                .setContentInfo("Info");

        /*Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);*/

        notificationManager.notify(/*notification id*/1, notificationBuilder.build());
    }

    public void next(View view)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
