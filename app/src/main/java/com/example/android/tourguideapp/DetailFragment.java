package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    private int mColorResourceID;
    private int mPosition;
    private int mColor;
    private ArrayList<Location> mLocations;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.detail_list_item, container, false);

        Intent mReceivedIntent = getActivity().getIntent();
        final ArrayList<Location> mLocations = (ArrayList<Location>) mReceivedIntent.getSerializableExtra("array");
        mPosition = mReceivedIntent.getIntExtra("position",0);
        mColor = mReceivedIntent.getIntExtra("color",0);

        Location currentLocation = mLocations.get(mPosition);

        TextView locationTitleTextView = rootView.findViewById(R.id.detail_LocationTitle);

        locationTitleTextView.setText(currentLocation.getLocationName());
        locationTitleTextView.setBackgroundColor(mColor);

        TextView locationNameTextView = rootView.findViewById(R.id.detail_location_name);
        locationNameTextView.setText(currentLocation.getLocationName());
        locationNameTextView.setTextColor(mColor);

        TextView locationAddressTextView = rootView.findViewById(R.id.detail_location_address);
        locationAddressTextView.setText(currentLocation.getAddress());

        TextView locationNumberTextView = rootView.findViewById(R.id.detail_location_number);
        locationNumberTextView.setText(currentLocation.getPhoneNumber());

        TextView locationSummaryTextView = rootView.findViewById(R.id.detail_location_sum);
        locationSummaryTextView.setText(currentLocation.getSummary());

        ImageView locationImage = rootView.findViewById(R.id.detail_LocationImageView);
        if(currentLocation.hasImage()){
            locationImage.setImageResource(currentLocation.getImageId());
        }else{
            locationImage.setVisibility(View.GONE);
        }

        return rootView;
    }

}
