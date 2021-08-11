package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import java. lang. Math;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ImageView imageboy = findViewById(R.id.image_boy);
        ImageView imageGirl = findViewById(R.id.image_girl);
        EditText weight = findViewById(R.id.weight_value);
        EditText height = findViewById(R.id.height_value);
        Button calculateButton = findViewById(R.id.calculate_button);
        TextView bmi = findViewById(R.id.bmi);
        TextView bmiStatus = findViewById(R.id.bmi_status);
        LinearLayout bmiView = findViewById(R.id.bmiView);
        TextView calculateAgainButton = findViewById(R.id.calculate_again);

        imageboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageboy.setImageResource(R.drawable.ic_boy);
                imageGirl.setImageResource(R.drawable.ic_girl_blur);
            }
        });

        imageGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageboy.setImageResource(R.drawable.ic_boy_blur);
                imageGirl.setImageResource(R.drawable.ic_girl);
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weightValue = 0.0;
                double heightValue = 0.0;
                if (!weight.getText().toString().isEmpty()) {
                    weightValue = Double.parseDouble(weight.getText().toString());
                }
                if (!height.getText().toString().isEmpty()) {
                    heightValue = (Double.parseDouble(height.getText().toString()) / 100);
                }
                if (weightValue > 0.0 && heightValue > 0.0) {
                    double bmiNumber = weightValue/(heightValue*heightValue);
                    Log.i("BMI Vlaue:", Double.toString(bmiNumber));
                    String bmiValue = String.format("%.2f", bmiNumber);
                    bmi.setText(bmiValue);
                    bmiStatus.setText(bmiStatusValue(bmiNumber));
                    bmiView.setVisibility(View.VISIBLE);
                    calculateButton.setVisibility(View.GONE);
                } else
                Toast.makeText(MainActivity5.this, "Please Input Weight and Height Values greater than 0", Toast.LENGTH_SHORT).show();
            }
        });

        calculateAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiView.setVisibility(View.GONE);
                calculateButton.setVisibility(View.VISIBLE);
                weight.getText().clear();
                height.getText().clear();
                weight.requestFocus();
            }
        });
    }


    private String bmiStatusValue(double bmi) {
        String bmiStatus = new String();
        if (bmi < 18.5)
            bmiStatus = "Underweight";
        else if (bmi >= 18.5 && bmi < 25)
            bmiStatus = "Normal";
        else if (bmi >= 25 && bmi < 30)
            bmiStatus = "Overweight";
        else if (bmi > 30)
            bmiStatus = "Obese";

        return bmiStatus;
        }
}