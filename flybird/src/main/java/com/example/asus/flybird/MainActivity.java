package com.example.asus.flybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Game.GameSurface;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setContentView(new GameSurface(this));

    }
}
