package com.dev.test.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dev.test.R;
import com.dev.test.ui.test1.Test1;
import com.dev.test.ui.test2.Test2;

public class MainActivity extends AppCompatActivity {
    private Button btnTest1;
    private Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        btnTest1 = findViewById(R.id.btn_test1);
        btnTest2 = findViewById(R.id.btn_test2);
    }

    private void initData() {
        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Test1.class));
            }
        });

        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Test2.class));
            }
        });
    }

}
