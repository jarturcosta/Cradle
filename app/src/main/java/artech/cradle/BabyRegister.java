package artech.cradle;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Entities.Baby;
import Entities.Cradle;

public class BabyRegister extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_register);

        dateView = (TextView) findViewById(R.id.birthday);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        FloatingActionButton save = (FloatingActionButton) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cradle cradle = new Cradle(getApplicationContext());
                TextView tvName = findViewById(R.id.name);
                TextView tvHeight = findViewById(R.id.height);
                TextView tvBDay = findViewById(R.id.birthday);
                TextView tvWeight = findViewById(R.id.weight);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date bday = new Date();
                try {
                    bday = sdf.parse(tvBDay.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Baby bb = new Baby(tvName.getText().toString(), "José", "Maria", Double.parseDouble(tvHeight.getText().toString()), Double.parseDouble(tvWeight.getText().toString()),bday);
                cradle.addBaby(bb);
                cradle.saveCradle();

                Toast.makeText(getApplicationContext(), //Context
                        "Baby saved!", // Message to display
                        Toast.LENGTH_SHORT // Duration of the message, another possible value is Toast.LENGTH_LONG
                ).show(); //Finally Show the toast
                cradle.loadCradle();
            }
        });

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
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
                                      int arg1, int arg2, int arg3) {

                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



}
