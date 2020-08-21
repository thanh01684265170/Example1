package com.dev.test.ui.test2;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.test.R;

import java.util.Locale;

public class Test2 extends AppCompatActivity {

    private Spinner spinner;
    private ImageView image;
    private Button button;
    private TextView txtLanguage;
    private SharedPreferences sharedPreferences;
    private int curentPosition;
    String[] items = new String[]{"Việt Nam", "Anh"};
    final String[] languages = new String[]{"vi", "en"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
        initData();
        initShare();
    }

    private void initShare() {
        sharedPreferences = getSharedPreferences("dataLanguge", MODE_PRIVATE);
        curentPosition = sharedPreferences.getInt("ngonNgu", -1);
        if (curentPosition >= 0) {
            setLanguage(languages[curentPosition], curentPosition);
            spinner.setSelection(curentPosition);
        }
    }

    private void initView() {
        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.imageView);
        txtLanguage = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }

    private void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        curentPosition = spinner.getSelectedItemPosition();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (curentPosition != position) {
                    setLanguage(languages[position], position);
                }
                curentPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ngonNgu", curentPosition);
                editor.commit();
            }
        });
    }

    private void setLanguage(String language, int position) {
        Locale locale = new Locale(language);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        txtLanguage.setText(getString(R.string.title_languge));
        image.setBackground(getDrawable(getResources().getIdentifier(languages[position], "drawable", getPackageName())));
    }
}
