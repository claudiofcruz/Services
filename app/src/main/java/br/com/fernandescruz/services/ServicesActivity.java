package br.com.fernandescruz.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.fernandescruz.alarmservices.R;


public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }

    Intent intent;

    public void ativar(View view) {
        intent = new Intent(this, Loggers.class);
        startService(intent);
    }

    public void desativar(View view) {
        if(intent != null)
        {
            stopService(intent);
        }
    }

}
