package artech.cradle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

import Entities.Baby;
import Entities.Cradle;
import Entities.Gender;
import artech.cradle.R;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(Home.this, BabyRegister.class);
                startActivity(k);
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Cradle cradle = new Cradle(getApplicationContext());
        cradle.loadCradle();

        if(!cradle.getBabyList().isEmpty()) {
            ImageView img = findViewById(R.id.babyPic);
            img.setVisibility(View.VISIBLE);
            TextView age = findViewById(R.id.age);
            age.setVisibility(View.VISIBLE);
            TextView name = findViewById(R.id.name);
            Baby bb1 = cradle.getBabyList().get(cradle.getBabyList().size()-1);
            name.setText(bb1.getName());
            age.setText(dateDifference(bb1.getBirthday(),new Date()));
        }


    }


    public static String dateDifference(Date from, Date to) {
        Calendar fromDate= Calendar.getInstance();
        Calendar toDate=Calendar.getInstance();
        fromDate.setTime(from);
        toDate.setTime(to);
        int increment = 0;
        int year,month,day;
        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
            increment =fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (increment != 0) {
            day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
            increment = 1;
        } else {
            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
        }

        if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 1;
        } else {
            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 0;
        }

        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);

        StringBuilder sb = new StringBuilder();
        if (year>0) {sb.append(year+" years, ");}
        if (month>0) {sb.append(month + " months and ");}
        sb.append(day + " days old");
        return sb.toString();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
