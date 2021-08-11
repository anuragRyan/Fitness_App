package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    Exercise e1 = new Exercise("Triceps Dips", "10reps - 4 sets", R.drawable.triceps_dips);
    Exercise e2 = new Exercise("Push ups", "10reps - 4 sets", R.drawable.push_ups);
    Exercise e3 = new Exercise("Inclined Push Ups", "10reps - 4 sets",R.drawable.incline_push_ups);
    Exercise e4 = new Exercise("Chest Stretch", "10reps - 4 sets",R.drawable.chest_stretch);
    Exercise e5 = new Exercise("Jumping Jack", "10reps - 3 sets",R.drawable.jumping_jack);

    Exercise b1 = new Exercise("Burpees", "10reps - 4 sets",R.drawable.burpees);
    Exercise b2 = new Exercise("Triceps dips", "10reps - 4 sets",R.drawable.triceps_dips);
    Exercise b3 = new Exercise("Diamond push-ups", "10reps - 4 sets",R.drawable.diamond_push_ups);
    Exercise b4 = new Exercise("Dumbbells Curl", "10reps - 4 sets",R.drawable.dubmbells_curls);
    Exercise b5 = new Exercise("Punches", "10reps - 3 sets",R.drawable.punches);

    Exercise a1 = new Exercise("Crunches", "10reps - 4 sets",R.drawable.crunches);
    Exercise a2 = new Exercise("Russian twist", "10reps - 4 sets",R.drawable.russian_twist);
    Exercise a3 = new Exercise("Mountain climber", "10reps - 4 sets",R.drawable.mountain_climber);
    Exercise a4 = new Exercise("Leg raises", "10reps - 4 sets",R.drawable.leg_raises);
    Exercise a5 = new Exercise("Plank", "60secs - 90secs",R.drawable.plank);

    Exercise l1 = new Exercise("Side Hop", "10reps - 4 sets",R.drawable.side_hop);
    Exercise l2 = new Exercise("Calf Stretch", "10reps - 4 sets",R.drawable.calf_stretch);
    Exercise l3 = new Exercise("Squats", "10reps - 4 sets",R.drawable.squats);
    Exercise l4 = new Exercise("Backward lunge", "10reps - 4 sets",R.drawable.backward_lunge);
    Exercise l5 = new Exercise("Knee to chest stretch", "10reps - 3 sets",R.drawable.knee_to_chest_stretch);

    Exercise back1 = new Exercise("Pull ups", "10reps - 4 sets",R.drawable.pull_ups);
    Exercise back2 = new Exercise("Knee Push ups", "10reps - 4 sets",R.drawable.knee_push_ups);
    Exercise back3 = new Exercise("Incline Push Ups", "10reps - 4 sets",R.drawable.incline_push_ups);
    Exercise back4 = new Exercise("Inchworms", "10reps - 4 sets",R.drawable.inchworms);
    Exercise back5 = new Exercise("Side Arm Raise", "10reps - 3 sets",R.drawable.side_arm_raise);

    Exercise[] chestExercises = {e1, e2, e3, e4, e5};
    Exercise[] bicepsExercises = {b1, b2, b3, b4, b5};
    Exercise[] absExercises = {a1, a2, a3, a4, a5};
    Exercise[] legExercises = {l1, l2, l3, l4, l5};
    Exercise[] backExercises = {back1, back2, back3, back4, back5};

    Button bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialiseListeners();
    }

    public void initialiseListeners() {
        ViewGroup fitone = findViewById(R.id.fitone);
        fitone.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            StaticRepo.currentExercise = chestExercises;
            startActivity(intent);
        });

        ViewGroup fittwo = findViewById(R.id.fittwo);
        fittwo.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            StaticRepo.currentExercise = bicepsExercises;
            startActivity(intent);
        });

        ViewGroup fitthree = findViewById(R.id.absfitthree);
        fitthree.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            StaticRepo.currentExercise = absExercises;
            startActivity(intent);
        });

        ViewGroup fitfour = findViewById(R.id.fitfour);
        fitfour.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);

            StaticRepo.currentExercise = legExercises;
            startActivity(intent);
        });

        ViewGroup fitfive = findViewById(R.id.fitthree);
        fitfive.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            StaticRepo.currentExercise = backExercises;
            startActivity(intent);
        });
    }

    public void continueWorkout(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent);
    }

    public void stepCounter(View v) {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }
}