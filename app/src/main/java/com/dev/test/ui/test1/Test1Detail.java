package com.dev.test.ui.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.dev.test.R;
import com.dev.test.model.Location;

public class Test1Detail extends AppCompatActivity {

    public static final String EXTRA_LOCATION = "EXTRA_LOCATION";
    private Location location;
    private TextView txtName, txtDes;
    private ImageView image;

    public static void openDetailActivity(Activity activity, Location location) {
        Intent intent = new Intent(activity, Test1Detail.class);
        intent.putExtra(EXTRA_LOCATION, location);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_detail);
        initView();
        initData();
        showData();
    }

    private void initView() {
        txtName = findViewById(R.id.txt_name);
        txtDes = findViewById(R.id.txt_description);
        image = findViewById(R.id.img_image);
    }

    private void initData() {
        location = getIntent().getParcelableExtra(EXTRA_LOCATION);
    }

    private void showData() {
        txtName.setText(location.getName());
        txtDes.setText(location.getDescription());
        Glide.with(this)
                .load(location.getImage())
                .centerCrop()
                .placeholder(R.drawable.image_test)
                .error(R.drawable.ic_launcher_background)
                .into(image);
    }
}
