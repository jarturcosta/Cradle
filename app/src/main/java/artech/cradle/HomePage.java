package artech.cradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import Entities.Baby;
import Entities.Cradle;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Baby creation test
        Cradle cradle = new Cradle(getApplicationContext());
        Baby bb1 = new Baby("Joaquim Silva", "Arnaldo Silva", "Maria Paredes", new Date());
        cradle.addBaby(bb1);

        TextView name = new TextView(this);
        name = (TextView) findViewById(R.id.name);
        name.setText(bb1.getName());

        SimpleDateFormat bdayFormat = new SimpleDateFormat("MMMM dd yyyy");
        TextView bday = new TextView(this);
        bday = (TextView) findViewById(R.id.birthday);
        bday.setText((CharSequence) bdayFormat.format(bb1.getBirthday()));

        cradle.saveCradle();
    }
}
