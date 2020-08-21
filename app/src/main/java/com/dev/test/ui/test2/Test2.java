package com.dev.test.ui.test2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.test.R;

public class Test2 extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
        initData();
    }

    private void initView() {
        spinner = findViewById(R.id.spinner);
    }

    private void initData() {
        String[] items = new String[]{"Việt Nam", "Anh", "Mỹ", "Trung Quốc"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }
}
