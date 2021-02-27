package com.example.notificationapp;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }
    private void addNotification() {
        Intent intent = new Intent(this, NotificationView.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,
                (int) System.currentTimeMillis(), intent, 0);
        Notification noti = new Notification.Builder(this)
                .setContentTitle("New mail from " + "xyz@gmail.com")
                .setContentText("Subject").setSmallIcon(R.drawable.snapchat)
                .setContentIntent(pIntent)
                .addAction(R.drawable.facebook, "Call", pIntent)
                .addAction(R.drawable.instagram, "More", pIntent).build();
                //.addAction(R.drawable.vine, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);
    }
}
