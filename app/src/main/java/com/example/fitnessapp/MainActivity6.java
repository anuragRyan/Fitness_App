package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class MainActivity6 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager = null;
    private boolean running = false;
    private float totalSteps = 0f;
    private float previousTotalSteps = 0f;
    TextView tv_stepsTaken;
    CircularProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        tv_stepsTaken = findViewById(R.id.tv_stepsTaken);
        progress_circular = findViewById(R.id.progress_circular);

        loadData();
        resetSteps();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        
        if(stepSensor == null) {
            Toast.makeText(this, "No sensor detected  on your device.", Toast.LENGTH_LONG).show();
        } else {
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (running) {
            totalSteps = event.values[0];
            int currentSteps = (int) (totalSteps - previousTotalSteps);
            tv_stepsTaken.setText(Integer.toString(currentSteps));

            progress_circular.setProgressWithAnimation(currentSteps);
        }
    }

    public void resetSteps() {
        tv_stepsTaken.setOnClickListener(v -> Toast.makeText(MainActivity6.this, "Long Press to reset the counter.", Toast.LENGTH_LONG).show());
        tv_stepsTaken.setOnLongClickListener((View.OnLongClickListener) v -> {
            previousTotalSteps = totalSteps;
            tv_stepsTaken.setText("0");
            saveData();
            return true;
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("key1", previousTotalSteps);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        float savedNumber = sharedPreferences.getFloat("key1", 0f);
        Log.d("MainActivity6", Float.toString(savedNumber));
        previousTotalSteps = savedNumber;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}