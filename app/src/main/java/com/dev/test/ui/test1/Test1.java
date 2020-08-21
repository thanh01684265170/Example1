package com.dev.test.ui.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.test.R;
import com.dev.test.adapter.LocationAdapter;
import com.dev.test.model.Location;

import java.util.ArrayList;

public class Test1 extends AppCompatActivity implements LocationAdapter.ItemClickListener {

    private LocationAdapter locationAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initView();
        initData();
    }

    private void initView() {
        listView = findViewById(R.id.list_location);
        locationAdapter = new LocationAdapter();
    }

    private void initData() {
        listView.setAdapter(locationAdapter);
        locationAdapter.setLocations(getLocations(), this);
    }

    private ArrayList<Location> getLocations() {
        ArrayList<Location> list = new ArrayList<>();
        list.add(new Location("Hồ tây", "https://icdn.dantri.com.vn/thumb_w/640/2020/01/24/00-1579884195136.jpg", "Có tháo rùa"));
        list.add(new Location("Hồ tây", "https://icdn.dantri.com.vn/thumb_w/640/2020/01/24/00-1579884195136.jpg", "Có tháo rùa"));
        list.add(new Location("Hồ tây", "1", "Có tháo rùa"));
        list.add(new Location("Hồ tây", "1", "Có tháo rùa"));
        list.add(new Location("Hồ tây", "1", "Có tháo rùa"));
        list.add(new Location("Hồ tây", "1", "Có tháo rùa"));
        return list;
    }

    @Override
    public void onClick(Location location) {
        Test1Detail.openDetailActivity(Test1.this, location);
    }
}
