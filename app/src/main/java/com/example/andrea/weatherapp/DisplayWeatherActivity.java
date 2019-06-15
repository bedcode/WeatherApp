package com.example.andrea.weatherapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class DisplayWeatherActivity extends AppCompatActivity {

    TextView cityField, weatherIcon, updatedField, currentTemperatureField, detailsField, humidityField, pressureField;
    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);

        Intent intent = getIntent();
        String city = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        weatherFont = Typeface.createFromAsset(getAssets(), "font/weather_icons.ttf");
        cityField = findViewById(R.id.cityField);
        updatedField = findViewById(R.id.updatedField);
        weatherIcon = findViewById(R.id.weatherIcon);
        currentTemperatureField = findViewById(R.id.currentTemperatureField);
        detailsField = findViewById(R.id.detailsField);
        humidityField =findViewById(R.id.humidityField);
        pressureField = findViewById(R.id.pressureField);

        weatherIcon.setTypeface(weatherFont);

        Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidityField.setText("Humidity: " + weather_humidity);
                pressureField.setText("Pressure: " + weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute(city);

    }
}
