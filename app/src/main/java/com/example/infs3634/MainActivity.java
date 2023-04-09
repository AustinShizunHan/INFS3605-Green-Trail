package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLauncher = findViewById(R.id.MapButton);
        btnLauncher.setOnClickListener(view -> launchMapActivity());


    }

    void launchMapActivity(){
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }


}
