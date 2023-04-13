package com.example.infs3634.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.location.MapActivity;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class QuizStartPage extends AppCompatActivity {
    
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_start);

        Button startButton = (Button) findViewById(R.id.quizbutton);
        final TextView nameText = (TextView) findViewById(R.id.textView);
        final EditText nametext = (EditText) findViewById(R.id.editName);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.quiz);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        launchHomeActivity();
                        // handle Home tab selection
                        return true;
                    case R.id.quiz:
                        launchQuizActivity();
                        // handle Search tab selection
                        return true;
                    case R.id.location:
                        launchMapActivity();
                        // handle Profile tab selection
                        return true;
                    case R.id.timeline:
//                        launchTimelineActivity();
                        // handle Profile tab selection
                        return true;
                }
                return false;
            }
        });

    }
    public void launchHomeActivity() {
        Intent intent = new Intent(QuizStartPage.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchPlantPageActivity() {
        Intent intent = new Intent(QuizStartPage.this, PlantPageActivity.class);
        startActivity(intent);
    }

    public void launchMapActivity() {
        Intent intent = new Intent(QuizStartPage.this, MapActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
        Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
        startActivity(intent);
    }
}
