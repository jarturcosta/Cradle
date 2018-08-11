package artech.cradle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import java.util.Calendar;
import java.util.Date;

import Entities.Baby;
import Entities.Cradle;
import Entities.Gender;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Baby selectedBaby;
    private static Cradle cradle;
    private int position = 0;

    public static Baby getSelectedBaby() {
        return selectedBaby;
    }

    public static void setSelectedBaby(Cradle cradle, String babyName) {
        for(Baby b: cradle.getBabyList()) {
            if(b.getName().equals(babyName)) {
                selectedBaby = b;
            }
        }
    }

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

        this.cradle = new Cradle(getApplicationContext());
        this.cradle.loadCradle();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            setSelectedBaby(cradle, cradle.getBabyList().get(position).getName());
            this.position = bundle.getInt("selectedBabyPos");

        }


        if(!cradle.getBabyList().isEmpty()) {

            TextView age = findViewById(R.id.age_stats);
            age.setVisibility(View.VISIBLE);
            TextView name = findViewById(R.id.name_stats);
            if(selectedBaby == null) {
                selectedBaby = cradle.getBabyList().get(cradle.getBabyList().size()-1);
            }
            ImageView img = findViewById(R.id.babyPic);
            if (selectedBaby.getGender().equals(Gender.FEMALE)) {
                img.setImageResource(R.mipmap.baby_f);
            } else {
                img.setImageResource(R.mipmap.baby_m);
            }
            img.setVisibility(View.VISIBLE);
            Baby bb1 = selectedBaby;
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


        if (id == R.id.nav_babies) {
            Intent k = new Intent(this, BabyListing.class);
            startActivity(k);
            finish();
        }

        else if (id == R.id.nav_baby_stats) {
            Intent k = new Intent (this, BabyStats.class);
            Bundle bundle = new Bundle();
            cradle.loadCradle();

            bundle.putInt("selectedBabyPos",position);
            k.putExtras(bundle);

            startActivity(k);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
