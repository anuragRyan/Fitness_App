package com.example.fitnessapp;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;

import java.io.Serializable;

public class Exercise implements Serializable {
    String exName;
    String exDesc;
    int imageName;


    Exercise(String exName, String exDesc , int imageName) {
        this.exName = exName;
        this.exDesc = exDesc;
        this.imageName = imageName;

    }
}
