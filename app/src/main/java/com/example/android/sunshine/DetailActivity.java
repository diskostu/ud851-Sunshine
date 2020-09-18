package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private TextView tvWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvWeatherData = findViewById(R.id.tv_weather_data);

        // DONE (2) Display the weather forecast that was passed from MainActivity
        final String weather = getIntent().getStringExtra("weather");
        tvWeatherData.setText(weather);
    }
}