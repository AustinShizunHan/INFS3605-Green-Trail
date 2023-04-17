package com.example.infs3634.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.location.MapActivity;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.R;
import com.example.infs3634.timeline.TimelineActivity;
import com.example.infs3634.timeline.TimelineAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class QuizStartPage extends AppCompatActivity {

    EditText name;
    BottomNavigationView bottomNavigationView;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_start);

        startButton = findViewById(R.id.quizbutton);
        name = findViewById(R.id.editName);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.quiz);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = name.getText().toString();
                Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
            }
        });

        //The start button to next page
//        startButton.setOnClickListener(view -> launchQuizActivity());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        launchHomeActivity();
                        // handle Home tab selection
                        return true;
                    case R.id.location:
                        launchMapActivity();
                        // handle location tab selection
                        return true;
                    case R.id.search:
                        launchPlantPageActivity();
                        // handle search tab selection
                        return true;
                    case R.id.quiz:
//                        launchQuizStartPage();
                        // handle quiz tab selection
                        return true;
                    case R.id.timeline:
                        launchTimelineActivity();
//                         handle timeline tab selection
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

    public void launchMapActivity() {
        Intent intent = new Intent(QuizStartPage.this, MapActivity.class);
        startActivity(intent);
    }
    public void launchPlantPageActivity() {
        Intent intent = new Intent(QuizStartPage.this, PlantPageActivity.class);
        startActivity(intent);
    }
    public void launchQuizStartPage() {
        Intent intent = new Intent(QuizStartPage.this, QuizStartPage.class);
        startActivity(intent);
    }
    public void launchTimelineActivity() {
        Intent intent = new Intent(QuizStartPage.this, TimelineActivity.class);
        startActivity(intent);
    }

    //Click the start button to start the quiz
    public void launchQuizActivity() {
        Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
        // Record the name user put in and shows in quiz page
        String playername = name.getText().toString();
        intent.putExtra("EditText",playername);
        startActivity(intent);
    }

}
