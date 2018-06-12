package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location>{

    private int mColorResourceID;


    public LocationAdapter(Context context, ArrayList<Location> locations, int colorResourceID){
        super(context, 0, locations);
        mColorResourceID = colorResourceID;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        Location currentLocation = getItem(position);

        int color = ContextCompat.getColor(getContext(), mColorResourceID);

        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.locationName_text_view);

        locationNameTextView.setText(currentLocation.getLocationName());
        locationNameTextView.setTextColor(color);

        TextView locationAddressTextView = listItemView.findViewById(R.id.address_text_view);

        locationAddressTextView.setText(currentLocation.getAddress());

        ImageView locationImage = listItemView.findViewById(R.id.locationImage);

        if(currentLocation.hasImage()){
            locationImage.setImageResource(currentLocation.getImageId());
        }else{
            locationImage.setVisibility(View.GONE);
        }

        return listItemView;

    }
}
