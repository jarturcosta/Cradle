package artech.cradle;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import Entities.Baby;
import Entities.Cradle;
import Entities.Gender;

public class BabyStats extends AppCompatActivity {

    private Baby selectedBaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_stats);

        Cradle cradle = new Cradle(getApplicationContext());
        cradle.loadCradle();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int position = bundle.getInt("selectedBabyPos");
            selectedBaby = cradle.getBabyList().get(position);
        }

        if(selectedBaby.getGender().equals(Gender.FEMALE)) {
            findViewById(R.id.profile_layout).setBackgroundColor(getResources().getColor(R.color.colorAccent));
            ImageView cover = findViewById(R.id.header_cover_image);
            cover.setImageResource(R.drawable.ic_background_pink);
            ImageView profile = findViewById(R.id.profile);
            profile.setImageResource(R.mipmap.baby_f);
        }

        TextView name = findViewById(R.id.name_stats);
        TextView age = findViewById(R.id.age_stats);
        TextView bday = findViewById(R.id.bday);
        TextView fa_name = findViewById(R.id.fathers_name);
        TextView mo_name = findViewById(R.id.mothers_name);
        TextView weight = findViewById(R.id.weight);
        TextView height = findViewById(R.id.height);

        name.setText(selectedBaby.getName());
        age.setText(Home.dateDifference(selectedBaby.getBirthday(),new Date()));
        bday.setText(selectedBaby.getBirthday().toString());
        fa_name.setText(selectedBaby.getDadName());
        mo_name.setText(selectedBaby.getMomName());
        weight.setText(Double.toString(selectedBaby.getWeight()));
        height.setText(Double.toString(selectedBaby.getHeight()));

    }
}
