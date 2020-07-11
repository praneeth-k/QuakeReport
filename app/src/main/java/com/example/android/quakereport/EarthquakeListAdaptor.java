package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeListAdaptor extends ArrayAdapter<EarthquakeData> {
    public EarthquakeListAdaptor(@NonNull Context context, ArrayList<EarthquakeData> earthquakeData) {
        super(context, 0, earthquakeData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        EarthquakeData earthquakeData = getItem(position);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD YYYY");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:MM a");
        DecimalFormat magFormat = new DecimalFormat("0.0");
        assert earthquakeData != null;
        String place = earthquakeData.getLocation();
        String distance, location;
        double magnitude = earthquakeData.getMagnitude();
        int index = place.indexOf(" of ");
        distance = index>-1? place.substring(0, index+3): "Near";
        location = index>-1? place.substring(index+4, place.length()): place;
        View listItemView = convertView;
        if(listItemView == null)
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(magFormat.format(magnitude));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(magnitude));
        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.distance);
        distanceTextView.setText(distance);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(dateFormatter.format(new Date( earthquakeData.getTimestamp())));
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(timeFormatter.format(new Date(earthquakeData.getTimestamp())));

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude)    {
        int magnitudeColorResourceId;
        switch ((int)Math.floor(magnitude))
        {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
