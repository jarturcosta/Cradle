package artech.cradle;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Entities.Baby;
import Entities.Gender;

public class BabyListAdapter extends ArrayAdapter<Baby> {

    private final Activity context;
    private final List<Baby> babies;

    public BabyListAdapter(Activity context, List<Baby> babies) {
        super(context, R.layout.activity_baby_listing, babies);
        this.context = context;
        this.babies = babies;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.babyName);
        txtTitle.setText(babies.get(position).getName());
        ImageView gen = (ImageView) rowView.findViewById(R.id.babyGender);
        ImageView img = (ImageView) rowView.findViewById(R.id.babySingleImage);
        if(babies.get(position).getGender().equals(Gender.FEMALE)) {
            gen.setImageResource(R.mipmap.female);
            img.setImageResource(R.mipmap.baby_f);
        } else {
            gen.setImageResource(R.mipmap.male);
            img.setImageResource(R.mipmap.baby_m);

        }
        return rowView;
    }
}
