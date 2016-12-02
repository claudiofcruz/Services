package br.com.fernandescruz.services;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

/**
 * Created by claudiocruz on 28/11/16.
 */

public class BoundService extends Service {

    private IBinder mBinder = new MyBinder();
    private Chronometer mChronometer;
    private String LOG_TAG = "BoundService";

    public void onCreate(){
        super.onCreate();
        Log.i(LOG_TAG, "in onCreate");

        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(LOG_TAG, "in onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(LOG_TAG, "in onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "in onDestroy");
        mChronometer.stop();
    }

    public String getTimeStamp(){
        long elapsedMills = SystemClock.elapsedRealtime()
                - mChronometer.getBase();

        int hours   =   (int) (elapsedMills / 3600000);
        int minutes =   (int) (elapsedMills + hours * 3600000) / 60000;
        int seconds =   (int) (elapsedMills - hours * 3600000 - minutes * 60000) / 1000;
        int mills   =   (int) (elapsedMills - hours * 3600000 - minutes * 60000 - seconds * 1000);
        return hours + ":" + minutes + ":" + seconds + ":" + mills;
    }

    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

}
