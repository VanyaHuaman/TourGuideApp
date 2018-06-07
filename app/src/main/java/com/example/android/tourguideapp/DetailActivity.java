package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity{

    private int mColorResourceID;
    private int mPosition;
    private int mColor;
    private ArrayList<Location> mLocations;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list_item);

        Intent mReceivedIntent = getIntent();
        final ArrayList<Location> mLocations = (ArrayList<Location>) mReceivedIntent.getSerializableExtra("array");
        mPosition = mReceivedIntent.getIntExtra("position",0);
        mColor = mReceivedIntent.getIntExtra("color",0);

        Location currentLocation = mLocations.get(mPosition);

        TextView locationTitleTextView = findViewById(R.id.detail_LocationTitle);

        locationTitleTextView.setText(currentLocation.getLocationName());
        locationTitleTextView.setBackgroundColor(mColor);

        TextView locationNameTextView = findViewById(R.id.detail_location_name);
        locationNameTextView.setText(currentLocation.getLocationName());
        locationNameTextView.setTextColor(mColor);

        TextView locationAddressTextView = findViewById(R.id.detail_location_address);
        locationAddressTextView.setText(currentLocation.getAddress());

        TextView locationNumberTextView = findViewById(R.id.detail_location_number);
        locationNumberTextView.setText(currentLocation.getPhoneNumber());

        TextView locationSummaryTextView = findViewById(R.id.detail_location_sum);
        locationSummaryTextView.setText(currentLocation.getSummary());

        ImageView locationImage = findViewById(R.id.detail_LocationImageView);
        if(currentLocation.hasImage()){
            locationImage.setImageResource(currentLocation.getImageId());
        }else{
            locationImage.setVisibility(View.GONE);
        }

    }
}
