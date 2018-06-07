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
public class NightlifeFragment extends Fragment {


    final ArrayList<Location> mLocations = new ArrayList<Location>();

    public NightlifeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        makeNightlifeArray();

        View rootView = inflater.inflate(R.layout.location_recycler_list, container, false);

        TextView categoryTextView = (TextView) rootView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(getString(R.string.category_nightlife));
        int color = ContextCompat.getColor(getContext(), R.color.category_Nightlife);
        categoryTextView.setBackgroundColor(color);

        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), mLocations,
                R.color.category_Nightlife);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




        return rootView;
    }

    public void makeNightlifeArray(){

        List<String> nameArray = Arrays.asList(
                getString(R.string.nightlife_name_candleroom),
                getString(R.string.nightlife_name_balcony_club),
                getString(R.string.nightlife_name_parliament),
                getString(R.string.nightlife_name_double_wide),
                getString(R.string.nightlife_name_adairs_saloon),
                getString(R.string.nightlife_name_sons_of_hermann_hall),
                getString(R.string.nightlife_name_the_mansion_bar),
                getString(R.string.nightlife_name_twilite_lounge),
                getString(R.string.nightlife_name_black_swan_saloon),
                getString(R.string.nightlife_name_the_old_monk));

        List<String> addressArray = Arrays.asList(
                getString(R.string.nightlife_address_candleroom),
                getString(R.string.nightlife_address_balcony_club),
                getString(R.string.nightlife_address_parliament),
                getString(R.string.nightlife_address_double_wide),
                getString(R.string.nightlife_address_adairs_saloon),
                getString(R.string.nightlife_address_sons_of_hermann_hall),
                getString(R.string.nightlife_address_the_mansion_bar),
                getString(R.string.nightlife_address_twilite_lounge),
                getString(R.string.nightlife_address_black_swan_saloon),
                getString(R.string.nightlife_address_the_old_monk));

        List<String> numberArray = Arrays.asList(
                getString(R.string.nightlife_number_candleroom),
                getString(R.string.nightlife_number_balcony_club),
                getString(R.string.nightlife_number_parliament),
                getString(R.string.nightlife_number_double_wide),
                getString(R.string.nightlife_number_adairs_saloon),
                getString(R.string.nightlife_number_sons_of_hermann_hall),
                getString(R.string.nightlife_number_the_mansion_bar),
                getString(R.string.nightlife_number_twilite_lounge),
                getString(R.string.nightlife_number_black_swan_saloon),
                getString(R.string.nightlife_number_the_old_monk));

        List<String> sumArray = Arrays.asList(
                getString(R.string.nightlife_sum_candleroom),
                getString(R.string.nightlife_sum_balcony_club),
                getString(R.string.nightlife_sum_parliament),
                getString(R.string.nightlife_sum_double_wide),
                getString(R.string.nightlife_sum_adairs_saloon),
                getString(R.string.nightlife_sum_sons_of_hermann_hall),
                getString(R.string.nightlife_sum_the_mansion_bar),
                getString(R.string.nightlife_sum_twilite_lounge),
                getString(R.string.nightlife_sum_black_swan_saloon),
                getString(R.string.nightlife_sum_the_old_monk));

        List<Integer> imageId = Arrays.asList(
                R.drawable.candleroom,R.drawable.balcony_club,R.drawable.parliament,
                R.drawable.double_wide,R.drawable.adair_saloon,R.drawable.sons_of_hermann_hall,
                R.drawable.the_mansion_bar,R.drawable.twilite_lounge,R.drawable.black_swan_saloon,
                R.drawable.the_old_monk);

        if(mLocations.size()<nameArray.size()){

            for(int index = mLocations.size();index<nameArray.size(); index++) {
                mLocations.add(new Location(nameArray.get(index), addressArray.get(index),
                        numberArray.get(index), sumArray.get(index),imageId.get(index)));
            }
        }
    }
}
