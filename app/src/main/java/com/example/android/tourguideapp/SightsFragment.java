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
public class SightsFragment extends Fragment {


    final ArrayList<Location> mLocations = new ArrayList<Location>();

    public SightsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        makeSightsArray();

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        TextView categoryTextView = rootView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(getString(R.string.category_sights));
        int color = ContextCompat.getColor(getContext(), R.color.category_Sights);
        categoryTextView.setBackgroundColor(color);


        LocationAdapter adapter = new LocationAdapter(getActivity(), mLocations,
                R.color.category_Sights);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getActivity(),DetailActivity.class);

                detailIntent.putExtra("array",mLocations);
                detailIntent.putExtra("position",i);
                detailIntent.putExtra("color",R.color.category_Sights);

                startActivity(detailIntent);

            }
        });



        return rootView;
    }


    public void makeSightsArray(){

        List<String> nameArray = Arrays.asList(
                getString(R.string.sights_name_sixth_floor_museum_at_dealey_plaza),
                getString(R.string.sights_name_dallas_arboretum_and_botanical_garden),
                getString(R.string.sights_name_reunion_tower),
                getString(R.string.sights_name_dallas_world_aquarium),
                getString(R.string.sights_name_klyde_warren_park),
                getString(R.string.sights_name_six_flags_over_texas),
                getString(R.string.sights_name_dallas_museum_of_art),
                getString(R.string.sights_name_george_w_bush_presidential_library));

        List<String> addressArray = Arrays.asList(
                getString(R.string.sights_address_sixth_floor_museum_at_dealey_plaza),
                getString(R.string.sights_address_dallas_arboretum_and_botanical_garden),
                getString(R.string.sights_address_reunion_tower),
                getString(R.string.sights_address_dallas_world_aquarium),
                getString(R.string.sights_address_klyde_warren_park),
                getString(R.string.sights_address_six_flags_over_texas),
                getString(R.string.sights_address_dallas_museum_of_art),
                getString(R.string.sights_address_george_w_bush_presidential_library));

        List<String> numberArray = Arrays.asList(
                getString(R.string.sights_number_sixth_floor_museum_at_dealey_plaza),
                getString(R.string.sights_number_dallas_arboretum_and_botanical_garden),
                getString(R.string.sights_number_reunion_tower),
                getString(R.string.sights_number_dallas_world_aquarium),
                getString(R.string.sights_number_klyde_warren_park),
                getString(R.string.sights_number_six_flags_over_texas),
                getString(R.string.sights_number_dallas_museum_of_art),
                getString(R.string.sights_number_george_w_bush_presidential_library));

        List<String> sumArray = Arrays.asList(
                getString(R.string.sights_sum_sixth_floor_museum_at_dealey_plaza),
                getString(R.string.sights_sum_dallas_arboretum_and_botanical_garden),
                getString(R.string.sights_sum_reunion_tower),
                getString(R.string.sights_sum_dallas_world_aquarium),
                getString(R.string.sights_sum_klyde_warren_park),
                getString(R.string.sights_sum_six_flags_over_texas),
                getString(R.string.sights_sum_dallas_museum_of_art),
                getString(R.string.sights_sum_george_w_bush_presidential_library));

        List<Integer> imageId = Arrays.asList(
                R.drawable.sixth_floor_museum_at_dealey_plaza,
                R.drawable.dallas_arboretum_and_botanical_garden,
                R.drawable.reunion_tower,
                R.drawable.dallas_world_aquarium,
                R.drawable.klyde_warren_park,
                R.drawable.six_flags_over_texas,
                R.drawable.dallas_museum_of_art,
                R.drawable.george_w_bush_presidential_library_and_museum);

        if(mLocations.size()<nameArray.size()){

            for(int index = mLocations.size();index<nameArray.size(); index++) {
                mLocations.add(new Location(nameArray.get(index), addressArray.get(index),
                        numberArray.get(index), sumArray.get(index),imageId.get(index)));
            }
        }
    }
}
