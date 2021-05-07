package com.example.assignment6_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment6_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(b.getRoot());
        setTitle("Constraint Layout 1");

    }



}