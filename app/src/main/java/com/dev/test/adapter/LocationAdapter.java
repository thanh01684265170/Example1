package com.dev.test.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.test.R;
import com.dev.test.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends BaseAdapter {
    private List<Location> locations = new ArrayList<>();
    private ItemClickListener mListener;

    public void setLocations(List<Location> locations, ItemClickListener listener) {
        this.locations = locations;
        this.mListener = listener;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    @Override
    public Location getItem(int i) {
        return locations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final Location location = locations.get(i);

        view = View.inflate(viewGroup.getContext(), R.layout.item_location, null);

        ((TextView) view.findViewById(R.id.txt_name)).setText(location.getName());

        (view.findViewById(R.id.item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(location);
            }
        });

        return view;
    }

    public interface ItemClickListener {
        void onClick(Location location);
    }
}
