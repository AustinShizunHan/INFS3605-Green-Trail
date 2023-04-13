package com.example.infs3634.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.quiz.QuizActivity;

//import au.edu.unsw.infs3634.unswlearning.home.HomeDashboardActivity;


public class QuizResults extends  AppCompatActivity{

    public static final String INTENT_MESSAGE = "";
    TextView tvIncorret, tvCorrect, tvFinalResults, greeting;
    Button restartBtn;
    Button home;

    @Override
    // starting new activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results);

        tvIncorret = (TextView) findViewById(R.id.correctresult);
        tvCorrect = (TextView) findViewById(R.id.incorrectanswer);
        tvFinalResults = (TextView) findViewById(R.id.tvfinalscore);
        restartBtn = (Button) findViewById(R.id.btnTryagn);
        home = (Button) findViewById(R.id.btnHome);


        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers:" + QuizActivity.correct + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answers:" + QuizActivity.wrong + "\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score:" + QuizActivity.correct + "\n");


        tvIncorret.setText(sb);
        tvCorrect.setText(sb2);
        tvFinalResults.setText(sb3);


        QuizActivity.correct = 0;
        QuizActivity.wrong = 0;


        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }

        });
    }};





