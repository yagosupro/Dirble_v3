package com.example.bob_book.dirble_v3;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Created by bob-book on 10/6/2017.
 */

class NotificationService extends Service{
    public static Context context;
    Notification status;
    boolean isPause = true;

    private void showNotification(int pos) {
        RemoteViews views = new RemoteViews(getPackageName(),
                R.layout.status_bar);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        //notificationIntent.setAction(Const.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Intent playIntent = new Intent(this, NotificationService.class);
       // playIntent.setAction(Const.ACTION.PLAY_ACTION);
        PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                playIntent, 0);

        Intent closeIntent = new Intent(this, NotificationService.class);
       // closeIntent.setAction(Const.ACTION.STOPFOREGROUND_ACTION);
        PendingIntent pcloseIntent = PendingIntent.getService(this, 0,
                closeIntent, 0);

        views.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);

        views.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);

        if (pos == 0)
        {
            views.setImageViewResource(R.id.status_bar_play,
                    R.drawable.pause_ntf);
        }

        if(pos == 1) {
            views.setImageViewResource(R.id.status_bar_play,
                    R.drawable.pause_ntf);

        }
        if(pos == 2)
        {
            views.setImageViewResource(R.id.status_bar_play,
                    R.drawable.play_ntf);

        }
        status = new Notification.Builder(this).build();
        status.contentView = views;
        status.flags = Notification.FLAG_ONGOING_EVENT;
        status.icon = R.drawable.radio;
        status.contentIntent = pendingIntent;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    }


