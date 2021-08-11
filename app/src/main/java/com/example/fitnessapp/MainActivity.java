package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);

    }

    public void clickMenu(View v) {
        openDrawer(drawer);
    }

    public  static  void openDrawer(DrawerLayout drawer) {
        drawer.openDrawer(GravityCompat.START);
    }

    public void startWorkout(View v){
        //Toast.makeText(this, "Button Pressed..", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    public void bmiCalculator(View v) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void calendar(View v) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void aboutUs(View v) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
}