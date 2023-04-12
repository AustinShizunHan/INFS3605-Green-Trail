package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    public void launchQuizActivity() {
        Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
//        intent.putExtra(QuizResults.INTENT_MESSAGE, msg);
        startActivity(intent);
        System.out.println("quiz button working");
    }

    public void launchHomeActivity() {
        Intent intent = new Intent(QuizStartPage.this, MainActivity.class);
//        intent.putExtra(MainActivity.INTENT_MESSAGE, msg);
        startActivity(intent);
        System.out.println("home button working");
    }

    public void launchMapActivity() {
        Intent intent = new Intent(QuizStartPage.this, MapActivity.class);
//        intent.putExtra(QuizResults.INTENT_MESSAGE, msg);
        startActivity(intent);
        System.out.println("map button working");
    }


}
