package com.example.dltkl.mynoty;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    NotificationCompat.Builder note;
    private static final int uID = 2345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = new NotificationCompat.Builder(this);
        note.setAutoCancel(true);
    }

    public void clickNote(View v){
        note.setSmallIcon(R.drawable.bora1);
        note.setTicker("Ticker note.");
        note.setWhen(System.currentTimeMillis());
        note.setContentTitle("Content Title");
        note.setContentText("Content Body.");

        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        note.setContentIntent(pi);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uID, note.build());
    }
}
