package com.example.android.tourguideapp;


/**
 * Created by vladislavakopalova on 27.4.18.
 */

public class Item {

    private int mName;
    private int mDescription;
    private double mLat;
    private double mLon;
    private int mImageId;

    public Item(int name, int description, double lon, double lat, int imageId){
        mName=name;
        mDescription=description;
        mLat=lat;
        mLon=lon;
        mImageId = imageId;
    }

    public int getmName() {
        return mName;
    }

    public int getmDescription() {
        return mDescription;
    }

    public double getmLat() {
        return mLat;
    }

    public double getmLon() {
        return mLon;
    }

    public int getmImageId() {
        return mImageId;
    }
}
