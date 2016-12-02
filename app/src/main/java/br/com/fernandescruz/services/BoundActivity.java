package br.com.fernandescruz.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.fernandescruz.alarmservices.R;

public class BoundActivity extends AppCompatActivity {

    TextView tvTimeStamp;
    Button btnStopService;
    Button btnPrintTimeStamp;
    boolean mServiceBound = false;
    BoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        tvTimeStamp = (TextView)findViewById(R.id.tvTimeStamp);
        btnStopService = (Button)findViewById(R.id.btnStopService);
        btnPrintTimeStamp = (Button)findViewById(R.id.btnPrintTimeStamp);
    }

    public void stopService(View view) {
        if(mServiceBound){
            unbindService(mServiceConnection);
            mServiceBound = false;
        }

        Intent intent = new Intent(BoundActivity.this,BoundService.class);
        stopService(intent);
    }

    public void printTimeStamp(View view) {
        if(mServiceBound) {
            tvTimeStamp.setText(mBoundService.getTimeStamp());
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        Intent intent = new Intent(this,BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop(){
        super.onStop();

        if(mServiceBound){
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };
}
