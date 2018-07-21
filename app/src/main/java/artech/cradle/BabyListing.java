package artech.cradle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import Entities.Baby;
import Entities.Cradle;

public class BabyListing extends AppCompatActivity {

    private List<Baby> babies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_listing);

        Cradle cradle = new Cradle(getApplicationContext());
        cradle.loadCradle();

        babies = cradle.getBabyList();

        BabyListAdapter adapter = new BabyListAdapter(this, babies);
        ListView list = (ListView) findViewById(R.id.babyListView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent k = new Intent(BabyListing.this, Home.class);

                Bundle bundle = new Bundle();
                System.out.println(babies.get(position).getName());

                bundle.putInt("selectedBabyPos",position);
                k.putExtras(bundle);

                startActivity(k);
                finish();
            }
        });

    }
}
