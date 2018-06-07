package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        View rootView = inflater.inflate(R.layout.location_recycler_list, container, false);

        TextView categoryTextView = (TextView) rootView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(getString(R.string.category_entertainment));
        int color = ContextCompat.getColor(getContext(), R.color.category_Entertainment);
        categoryTextView.setBackgroundColor(color);


        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), mLocations,
                R.color.category_Entertainment);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



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

        List<Integer> imageIds = Arrays.asList(R.drawable.six_flags_over_texas,R.drawable.hurricane_harbor,
                R.drawable.national_videogame_museum,R.drawable.free_play_arcade,
                R.drawable.house_of_blues,R.drawable.south_side_ballroom,R.drawable.barcadia,
                R.drawable.att_stadium,R.drawable.globe_life_park,R.drawable.majestic_theatre);


        if(mLocations.size()<nameArray.size()){

            for(int index = mLocations.size();index<nameArray.size(); index++) {
                mLocations.add(new Location(nameArray.get(index), addressArray.get(index),
                        numberArray.get(index), sumArray.get(index), imageIds.get(index)));
            }
        }
    }


}
