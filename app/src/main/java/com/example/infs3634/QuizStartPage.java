package com.example.infs3634;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class QuizStartPage extends AppCompatActivity {

    final TextView nameText = (TextView) findViewById(R.id.textView);
    final EditText nametext = (EditText) findViewById(R.id.editName);
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_start);


    }
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

    public void launchQuizActivity(String msg) {
        Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
        intent.putExtra(QuizResults.INTENT_MESSAGE, msg);
        startActivity(intent);
        System.out.println("working");
    }

    public void launchHomeActivity(String msg) {
        Intent intent = new Intent(QuizStartPage.this, MainActivity.class);
        intent.putExtra(MainActivity.INTENT_MESSAGE, msg);
        startActivity(intent);
    }
}

