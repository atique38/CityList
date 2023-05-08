package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowCityName extends AppCompatActivity {
    TextView textView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_city_name);

        String city=getIntent().getStringExtra("name");
        textView=findViewById(R.id.city_name);
        back=findViewById(R.id.back_btn);

        textView.setText(city);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCityName.super.onBackPressed();
            }
        });

    }
}