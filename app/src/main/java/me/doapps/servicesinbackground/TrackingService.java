package me.doapps.servicesinbackground;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by doapps on 8/17/16.
 */
public class TrackingService extends Service {
    private String TAG = "SERVICE";
    private boolean flag;

    @Override
    public void onCreate() {
        Log.e(TAG, "Creado");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "Iniciado");
        counterTrack();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "Detenido");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**Thread**/
    private void counterTrack() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    Log.e(TAG, MainActivity.count + "");
                    MainActivity.count = MainActivity.count + 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
