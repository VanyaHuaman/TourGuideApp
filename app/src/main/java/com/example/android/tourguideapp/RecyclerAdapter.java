package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private int mColor;
    private ArrayList<Location> mLocations = new ArrayList<>();
    private Context mContext;


    public RecyclerAdapter(Context content, ArrayList<Location> locations, int colorResourceID) {

        mColor = ContextCompat.getColor(content, colorResourceID);
        mLocations = locations;
        mContext = content;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location currentLocation = mLocations.get(position);

        holder.mName.setText(currentLocation.getLocationName());
        holder.mName.setTextColor(mColor);

        holder.mAddress.setText(currentLocation.getAddress());

        if(currentLocation.hasImage()){
            holder.mImageId.setImageResource(currentLocation.getImageId());
        }else{
            holder.mImageId.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mLocations.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentLayout;
        private TextView mName;
        private TextView mAddress;
        private ImageView mImageId;
        private int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.rootLayout);
            mName = itemView.findViewById(R.id.locationName_text_view);
            mAddress = itemView.findViewById(R.id.address_text_view);
            mImageId = itemView.findViewById(R.id.locationImage);
            mPosition = getAdapterPosition();
        }


    }
}
