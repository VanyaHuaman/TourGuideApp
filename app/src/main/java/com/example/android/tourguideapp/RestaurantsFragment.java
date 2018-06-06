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
public class RestaurantsFragment extends Fragment {


    final ArrayList<Location> mLocations = new ArrayList<Location>();

    public RestaurantsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        makeRestaurantArray();

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        TextView categoryTextView = rootView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(getString(R.string.category_restaurants));
        int color = ContextCompat.getColor(getContext(), R.color.category_restaurants);
        categoryTextView.setBackgroundColor(color);

        LocationAdapter adapter = new LocationAdapter(getActivity(), mLocations,
                R.color.category_restaurants);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getActivity(),DetailActivity.class);

                detailIntent.putExtra("array",mLocations);
                detailIntent.putExtra("position",i);
                detailIntent.putExtra("color",R.color.category_restaurants);

                startActivity(detailIntent);
            }
        });



        return rootView;
    }

    public void makeRestaurantArray(){

        List<String> nameArray = Arrays.asList(
                getString(R.string.restaurant_name_fearing_at_the_ritz_carlton),
                getString(R.string.restaurant_name_trinity_groves),
                getString(R.string.restaurant_name_mansion),
                getString(R.string.restaurant_name_gemma),
                getString(R.string.restaurant_name_the_grape),
                getString(R.string.restaurant_name_five_sixty_by_wolfgang_puck),
                getString(R.string.restaurant_name_mercado_juarez),
                getString(R.string.restaurant_name_avilas),
                getString(R.string.restaurant_name_gonzalez),
                getString(R.string.restaurant_name_meso_maya_comida_y_copas));

        List<String> addressArray = Arrays.asList(
                getString(R.string.restaurant_address_fearing_at_the_ritz_carlton),
                getString(R.string.restaurant_address_trinity_groves),
                getString(R.string.restaurant_address_mansion),
                getString(R.string.restaurant_address_gemma),
                getString(R.string.restaurant_address_the_grape),
                getString(R.string.restaurant_address_five_sixty_by_wolfgang_puck),
                getString(R.string.restaurant_address_mercado_juarez),
                getString(R.string.restaurant_address_avilas),
                getString(R.string.restaurant_address_gonzalez),
                getString(R.string.restaurant_address_meso_maya_comida_y_copas));

        List<String> numberArray = Arrays.asList(
                getString(R.string.restaurant_number_fearing_at_the_ritz_carlton),
                getString(R.string.restaurant_number_trinity_groves),
                getString(R.string.restaurant_number_mansion),
                getString(R.string.restaurant_number_gemma),
                getString(R.string.restaurant_number_the_grape),
                getString(R.string.restaurant_number_five_sixty_by_wolfgang_puck),
                getString(R.string.restaurant_number_trinity_groves),
                getString(R.string.restaurant_number_avilas),
                getString(R.string.restaurant_number_gonzalez),
                getString(R.string.restaurant_number_meso_maya_comida_y_copas));

        List<String> sumArray = Arrays.asList(
                getString(R.string.restaurant_sum_fearing_at_the_ritz_carlton),
                getString(R.string.restaurant_sum_trinity_groves),
                getString(R.string.restaurant_sum_mansion),
                getString(R.string.restaurant_sum_gemma),
                getString(R.string.restaurant_sum_the_grape),
                getString(R.string.restaurant_sum_five_sixty_by_wolfgang_puck),
                getString(R.string.restaurant_sum_mercado_juarez),
                getString(R.string.restaurant_sum_avilas),
                getString(R.string.restaurant_sum_gonzalez),
                getString(R.string.restaurant_sum_meso_maya_comida_y_copas));

        List<Integer> imageId = Arrays.asList(
                R.drawable.fearing_s_at_the_ritz_carlton,R.drawable.trinity_groves_dallas,
                R.drawable.mansion_restaurant,R.drawable.gemma_restaurant,
                R.drawable.the_grape_restaurant,R.drawable.five_sixty_by_wolfgang_puck,
                R.drawable.mercado_juarez_restaurant,R.drawable.avila_s,
                R.drawable.gonzalez,R.drawable.meso_maya_comida_y_copas);

        if(mLocations.size()<nameArray.size()){

            for(int index = mLocations.size();index<nameArray.size(); index++) {
                mLocations.add(new Location(nameArray.get(index), addressArray.get(index),
                        numberArray.get(index), sumArray.get(index),imageId.get(index)));
            }
        }
    }

}
