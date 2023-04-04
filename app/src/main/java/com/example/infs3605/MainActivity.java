package com.example.infs3605;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.R;

public class MainActivity extends AppCompatActivity {

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("INFS3605");
    }
}