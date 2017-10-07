package com.example.bob_book.dirble_v3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RadioService extends Service {
    private PlayerInMain playerInMain;
    String huerel="http://relay4.181.fm:8128";

    public RadioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Служба создана",
                Toast.LENGTH_SHORT).show();
        super.onCreate();
        playerInMain=new PlayerInMain();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Служба запущена",
                Toast.LENGTH_SHORT).show();
        playerInMain.start(huerel,null);
       // mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Служба остановлена",
                Toast.LENGTH_SHORT).show();
       // mPlayer.stop();
    }
}
