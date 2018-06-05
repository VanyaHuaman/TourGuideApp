package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {


    final ArrayList<Location> mLocations = new ArrayList<Location>();

    public EntertainmentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        makeEntertainmentArray();

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        TextView categoryTextView = rootView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(getString(R.string.category_entertainment));
        int color = ContextCompat.getColor(getContext(), R.color.category_Entertainment);
        categoryTextView.setBackgroundColor(color);


        LocationAdapter adapter = new LocationAdapter(getActivity(), mLocations,
                R.color.category_Entertainment);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getActivity(),DetailActivity.class);

                detailIntent.putExtra("array",mLocations);
                detailIntent.putExtra("position",i);

                startActivity(detailIntent);
            }
        });



        return rootView;
    }

    public void makeEntertainmentArray(){

        List<String> nameArray = Arrays.asList(
                getString(R.string.entertainment_name_six_flags_over_texas),
                getString(R.string.entertainment_name_hurricane_harbor),
                getString(R.string.entertainment_name_national_videogame_museum),
                getString(R.string.entertainment_name_free_play_arcade),
                getString(R.string.entertainment_name_house_of_blues),
                getString(R.string.entertainment_name_south_side_ballroom),
                getString(R.string.entertainment_name_barcadia),
                getString(R.string.entertainment_name_att_stadium),
                getString(R.string.entertainment_name_globe_life_park),
                getString(R.string.entertainment_name_majestic_theater));

        List<String> addressArray = Arrays.asList(
                getString(R.string.entertainment_address_six_flags_over_texas),
                getString(R.string.entertainment_address_hurricane_harbor),
                getString(R.string.entertainment_address_national_videogame_museum),
                getString(R.string.entertainment_address_free_play_arcade),
                getString(R.string.entertainment_address_house_of_blues),
                getString(R.string.entertainment_address_south_side_ballroom),
                getString(R.string.entertainment_address_barcadia),
                getString(R.string.entertainment_address_att_stadium),
                getString(R.string.entertainment_address_globe_life_park),
                getString(R.string.entertainment_address_majestic_theater));

        List<String> numberArray = Arrays.asList(
                getString(R.string.entertainment_number_six_flags_over_texas),
                getString(R.string.entertainment_number_hurricane_harbor),
                getString(R.string.entertainment_number_national_videogame_museum),
                getString(R.string.entertainment_number_free_play_arcade),
                getString(R.string.entertainment_number_house_of_blues),
                getString(R.string.entertainment_number_south_side_ballroom),
                getString(R.string.entertainment_number_barcadia),
                getString(R.string.entertainment_number_att_stadium),
                getString(R.string.entertainment_number_globe_life_park),
                getString(R.string.entertainment_number_majestic_theater));

        List<String> sumArray = Arrays.asList(
                getString(R.string.entertainment_sum_six_flags_over_texas),
                getString(R.string.entertainment_sum_hurricane_harbor),
                getString(R.string.entertainment_sum_national_videogame_museum),
                getString(R.string.entertainment_sum_free_play_arcade),
                getString(R.string.entertainment_sum_house_of_blues),
                getString(R.string.entertainment_sum_south_side_ballroom),
                getString(R.string.entertainment_sum_barcadia),
                getString(R.string.entertainment_sum_att_stadium),
                getString(R.string.entertainment_sum_globe_life_park),
                getString(R.string.entertainment_sum_majestic_theater));


        if(mLocations.size()<nameArray.size()){

            for(int index = mLocations.size();index<nameArray.size(); index++) {
                mLocations.add(new Location(nameArray.get(index), addressArray.get(index),
                        numberArray.get(index), sumArray.get(index)));
            }
        }
    }

}