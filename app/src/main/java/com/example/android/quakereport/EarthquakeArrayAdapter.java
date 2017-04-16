package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yusuf on 10/11/2016.
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeArrayAdapter(Context context, ArrayList<Earthquake> earthquake){
        super(context,0,earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView)listItemView.findViewById(R.id.magnitude);
        TextView place = (TextView)listItemView.findViewById(R.id.primary_location);
        TextView location = (TextView)listItemView.findViewById(R.id.location_offset);
        TextView date = (TextView)listItemView.findViewById(R.id.date);
        TextView time =(TextView)listItemView.findViewById(R.id.time);

        magnitude.setText(currentEarthquake.getmMagnitude());

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = currentEarthquake.getMagnitudeColor();

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(),magnitudeColor));

        place.setText(currentEarthquake.getPrimaryLocation());

        location.setText(currentEarthquake.getLocationOffset());

        date.setText(currentEarthquake.getDate());

        time.setText(currentEarthquake.getTime());

        return listItemView;
    }
}
