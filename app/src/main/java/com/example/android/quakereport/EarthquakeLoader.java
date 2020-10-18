package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthquakeData>> {
    String requestURL;
    public EarthquakeLoader(Context context, String requestURL) {
        super(context);
        this.requestURL = requestURL;
    }

    @Override
    public List<EarthquakeData> loadInBackground() {
        return QueryUtils.fetchEarthquakeData(requestURL);
    }
}
