package br.com.fernandescruz.services;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

import br.com.fernandescruz.alarmservices.R;


public class LoginActivity extends AppCompatActivity {

    private Button btnNascimento;
    private int year, month, day;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnNascimento = (Button)findViewById(R.id.btnNascimento);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month+1,day);
    }

    @SuppressWarnings("deprecation")
    public void openDatePicker(View view) {
        showDialog(999);
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int year, int month, int day) {
                    showDate(year, month+1, day);
                }
            };

    private void showDate(int year, int month, int day) {
        btnNascimento.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void validarLogin(View view) {

    }
}
