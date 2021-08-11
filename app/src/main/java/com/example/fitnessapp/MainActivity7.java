package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class MainActivity7 extends AppCompatActivity {

    CustomCalendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        customCalendar = findViewById(R.id.customCalender);

        HashMap<Object, Property> descHashMap = new HashMap<>();

        Property defaultProperty = new Property();

        defaultProperty.layoutResource = R.layout.default_view;

        defaultProperty.dateTextViewResource = R.id.text_view;

        descHashMap.put("default", defaultProperty);

        Property currentProperty = new Property();
        currentProperty.layoutResource = R.layout.current_view;
        currentProperty.dateTextViewResource = R.id.text_view;
        descHashMap.put("current", currentProperty);

        customCalendar.setMapDescToProp(descHashMap);

        HashMap<Integer, Object> dateHaspMap = new HashMap<>();

        Calendar calendar = Calendar.getInstance();

        dateHaspMap.put(calendar.get(Calendar.DAY_OF_MONTH), "current");

        customCalendar.setDate(calendar, dateHaspMap);

        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {

                String sDate = selectedDate.get(Calendar.DAY_OF_MONTH)
                        + "/" + (selectedDate.get(Calendar.MONTH) + 1)
                        + "/" + selectedDate.get(Calendar.YEAR);

                int selectDate = selectedDate.get(Calendar.DAY_OF_MONTH);

                Log.i("tapped date", String.valueOf(selectDate));


                if (selectDate % 7 == 0)
                    Toast.makeText(getApplicationContext(), "Cheat Day!!", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 1)
                    Toast.makeText(getApplicationContext(), "Chest Workout", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 2)
                    Toast.makeText(getApplicationContext(), "Shoulder Workout", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 3)
                    Toast.makeText(getApplicationContext(), "Biceps Workout", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 4)
                    Toast.makeText(getApplicationContext(), "Legs Workout", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 5)
                    Toast.makeText(getApplicationContext(), "Abs Workout", Toast.LENGTH_LONG).show();
                else if (selectDate % 7 == 6)
                    Toast.makeText(getApplicationContext(), "Yoga", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "No data...", Toast.LENGTH_LONG).show();
            }
        });
    }
}