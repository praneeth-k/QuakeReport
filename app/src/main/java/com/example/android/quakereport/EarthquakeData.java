package com.example.android.quakereport;

import android.net.Uri;

public class EarthquakeData {
    private double magnitude; private String location; private Uri url; private long timestamp;
    public EarthquakeData(double magnitude, String location, long timestamp, Uri url)
    {
        this.magnitude = magnitude;
        this.location = location;
        this.timestamp = timestamp;
        this.url = url;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public Uri getUrl() {
        return url;
    }
}
