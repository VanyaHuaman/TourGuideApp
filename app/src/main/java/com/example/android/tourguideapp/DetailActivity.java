package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity{

    String mLocationName;
    String mLocationAddress;
    String mLocationNumber;
    String mLocationSummary;
    ImageView mLocationImage;
    ArrayList<Location> mLocations;
    Intent mReceivedIntent;
    int mArrayPosition;

    TextView mNameTitleTextView;
    TextView mNameTextView;
    TextView mAddressTextView;
    TextView mNumberTextView;
    TextView mSummaryTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getLocationDetails();
        setLocationDetails();



    }

    public void getLocationDetails(){
        mReceivedIntent = getIntent();

        mNameTitleTextView = findViewById(R.id.detail_LocationTitle);
        mNameTextView = findViewById(R.id.detail_location_name);
        mAddressTextView = findViewById(R.id.detail_location_address);
        mNumberTextView = findViewById(R.id.detail_location_number);
        mSummaryTextView = findViewById(R.id.detail_location_sum);
        mLocationImage = findViewById(R.id.detail_LocationImageView);


        mLocations = (ArrayList<Location>) mReceivedIntent.getSerializableExtra("array");
        mArrayPosition = mReceivedIntent.getIntExtra("position",0);
        mLocationName = mLocations.get(mArrayPosition).getLocationName();
        mLocationAddress = mLocations.get(mArrayPosition).getAddress();
        mLocationNumber = mLocations.get(mArrayPosition).getPhoneNumber();
        mLocationSummary = mLocations.get(mArrayPosition).getSummary();

        if(mLocations.get(mArrayPosition).hasImage()){
            int imageId = mLocations.get(mArrayPosition).getImageId();
            mLocationImage.setImageResource(imageId);
        }else{
            mLocationImage.setVisibility(View.INVISIBLE);
        }



    }

    public void setLocationDetails(){
        mNameTitleTextView.setText(mLocationName);
        mNameTextView.setText(mLocationName);
        mAddressTextView.setText(mLocationAddress);
        mNumberTextView.setText(mLocationNumber);
        mSummaryTextView.setText(mLocationSummary);
    }

    public void nextLocation(){
        if(mArrayPosition < mLocations.size()-1){
            mArrayPosition++;

            mLocationName = mLocations.get(mArrayPosition).getLocationName();
            mLocationAddress = mLocations.get(mArrayPosition).getAddress();
            mLocationNumber = mLocations.get(mArrayPosition).getPhoneNumber();
            mLocationSummary = mLocations.get(mArrayPosition).getSummary();
            setLocationDetails();

        }
    }

    public void previousLocation(){
        if(mArrayPosition > 0){
            mArrayPosition--;

            mLocationName = mLocations.get(mArrayPosition).getLocationName();
            mLocationAddress = mLocations.get(mArrayPosition).getAddress();
            mLocationNumber = mLocations.get(mArrayPosition).getPhoneNumber();
            mLocationSummary = mLocations.get(mArrayPosition).getSummary();
            setLocationDetails();

        }
    }

}
