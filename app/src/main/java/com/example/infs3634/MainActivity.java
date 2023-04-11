package com.example.infs3634;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.infs3634.MapActivity;
import com.example.infs3634.QuizActivity;

import com.example.infs3634.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("INFS3605");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                // handle Home tab selection
                                return true;

                            case R.id.quiz:
                                // handle Search tab selection
                                return true;
                            case R.id.location:
                                // handle Profile tab selection
                                return true;
                            case R.id.timeline:
                        }
                        return false;
                    }

                });
    }
    public void launchQuizActivity(String msg) {
        Intent intent = new Intent(MainActivity.this, QuizStartPage.class);
        intent.putExtra(QuizActivity.INTENT_MESSAGE, msg);
        startActivity(intent);
    }
}

