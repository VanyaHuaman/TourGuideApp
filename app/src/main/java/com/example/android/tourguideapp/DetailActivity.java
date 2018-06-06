package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity{





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list);

        Intent mReceivedIntent = getIntent();
        final ArrayList<Location> mLocations = (ArrayList<Location>) mReceivedIntent.getSerializableExtra("array");
        int mPosition = mReceivedIntent.getIntExtra("position",0);
        int mColor = mReceivedIntent.getIntExtra("color",0);

        DetailAdapter adapter = new DetailAdapter(this, mLocations,
                mColor);

        ListView listView = findViewById(R.id.detailListView);

        listView.setAdapter(adapter);


    }
}
