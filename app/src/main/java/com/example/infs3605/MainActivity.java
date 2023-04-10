package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605.quiz.QuizStartPage;
import com.example.infs3634.R;

public class MainActivity extends AppCompatActivity {

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("INFS3605");


        Button go_to_quiz = findViewById(R.id.go_to_quiz);

        go_to_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizStartPage.class);
                startActivity(intent);
            }
        });
    }

}