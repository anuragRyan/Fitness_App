package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        textView7 = findViewById(R.id.textView7);

        textView7.setText("A FHYSIQ is an application used anywhere to get fit." +
                "The purpose of a fitness app is to provide the user with instructions and examples" +
                " of one or more types of exercise, physical activity, or some other fitness topic and " +
                "keep track of steps covered in a day. We provide exercise tracker where individual and " +
                "click on the particular dates and look in to what exercise he/she has to do.");
    }
}