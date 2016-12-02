package br.com.fernandescruz.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by claudiocruz on 28/11/16.
 */
public class Loggers extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand (Intent intent, int flags, int startid){
        Log.i(this.getClass().getName(), "onBind(..)");
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(this.getClass().getName(), "Serviço iniciado");
    }

    public void onDestroy(){
        System.out.println("Serviço encerrado");
        Log.i(this.getClass().getName(), "Serviço onDestroy");
    }
}
