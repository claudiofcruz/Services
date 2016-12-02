package br.com.fernandescruz.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.fernandescruz.alarmservices.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void disparar(View view) {
        EditText etTempo = (EditText)findViewById(R.id.etTime);

        if (etTempo.getText().equals("")){
            Toast.makeText(this, "Facor preender um valor", Toast.LENGTH_SHORT).show();
        }else{
            int i = Integer.parseInt(etTempo.getText().toString());

            Intent intent = new Intent(this, AlarmReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this.getApplicationContext(),0,intent,0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + (i*1000),
                    pendingIntent);

            Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_SHORT ).show();
        }

    }

    public void clearText(View view) {
        EditText etTempo = (EditText)findViewById(R.id.etTime);
        etTempo.setText("");
    }
}
