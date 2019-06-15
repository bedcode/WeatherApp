package com.example.andrea.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendCity(View view) {
        Intent intent = new Intent(this, DisplayWeatherActivity.class);
        EditText editText = findViewById(R.id.editText);
        String city = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, city);
        startActivity(intent);
    }
}