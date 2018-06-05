package com.example.android.tourguideapp;

import android.os.Parcelable;

import java.io.Serializable;

public class Location implements Serializable{

    private String mLocationName;
    private String mAddress;
    private String mPhoneNumber;
    private String mSummary;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageId = NO_IMAGE_PROVIDED;

    public Location(String locationName, String address, String phonenumber, String summary){
        mLocationName = locationName;
        mAddress = address;
        mPhoneNumber = phonenumber;
        mSummary = summary;
    }

    public Location(String locationName, String address, String phonenumber, String summary, int imageId){
        mLocationName = locationName;
        mAddress = address;
        mPhoneNumber = phonenumber;
        mSummary = summary;
        mImageId = imageId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getSummary() {
        return mSummary;
    }

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage(){
        return mImageId != NO_IMAGE_PROVIDED;
    }

}
