package br.com.fernandescruz.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import br.com.fernandescruz.alarmservices.R;

/**
 * Created by claudiocruz on 28/11/16.
 */
public class AlarmReceiver extends BroadcastReceiver {

    private MediaPlayer mp = null;

    public AlarmReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, R.raw.haduken);
        mp.start();
        Toast.makeText(context, "Alarme disparada",Toast.LENGTH_SHORT).show();
    }
}
