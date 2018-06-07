package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailAdapter extends ArrayAdapter<Location> {

    private int mColorResourceID;


    public DetailAdapter(Context context, ArrayList<Location> locations, int colorResourceID){
        super(context, 0, locations);
        mColorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.detail_list_item,parent,false);
        }


        Location currentLocation = getItem(position);

        int color = ContextCompat.getColor(getContext(), mColorResourceID);

        TextView locationTitleTextView = listItemView.findViewById(R.id.detail_LocationTitle);

        locationTitleTextView.setText(currentLocation.getLocationName());
        locationTitleTextView.setBackgroundColor(color);

        TextView locationNameTextView = listItemView.findViewById(R.id.detail_location_name);
        locationNameTextView.setText(currentLocation.getLocationName());
        locationNameTextView.setTextColor(color);

        TextView locationAddressTextView = listItemView.findViewById(R.id.detail_location_address);
        locationAddressTextView.setText(currentLocation.getAddress());

        TextView locationNumberTextView = listItemView.findViewById(R.id.detail_location_number);
        locationNumberTextView.setText(currentLocation.getPhoneNumber());

        TextView locationSummaryTextView = listItemView.findViewById(R.id.detail_location_sum);
        locationSummaryTextView.setText(currentLocation.getSummary());

        ImageView locationImage = listItemView.findViewById(R.id.detail_LocationImageView);
            if(currentLocation.hasImage()){
                locationImage.setImageResource(currentLocation.getImageId());
            }else{
                locationImage.setVisibility(View.GONE);
            }

        return listItemView;

    }
}
