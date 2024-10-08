package com.example.infs3634.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.location.MapViewActivity;
import com.example.infs3634.plant.PlantDetailActivity;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.plant.QRScanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * Quiz activty is the screen which user attempts the quiz
 * accompanied by Quiz questions derived from array list
 * Radio buttons that allow a distinctive option
 * a button to continue to the next button
 * Toast messages and a live-score to inform the user the status of their score
 */

public class QuizActivity extends AppCompatActivity {

    //declarations
    public static String INTENT_MESSAGE;
    TextView quizQuestion;
    TextView playerName;
    Button nextBtn;
    RadioGroup radioGroup;
    RadioButton rbA, rbB, rbC, rbD;

    //array storing quiz questions
    String questions[] = {
            "How many peas are present in the mountain ceda wattle sign?",
            "Finish the sentence traditional uses of the mountain cedal",
            "Which plant can be used to dye fibres?",
            "Which plant have the indigenous used to treat headaches and colds?",
            "You can make me into jam, chutneys and even desserts. Find me at the north wing. Can you guess what I am?"
    };
    //array storing quiz answers
    String answers[] = {"9", "Edible pea flower", "Blue Flax Lily", "Native mint", "Plum Pine"
    };
    //array storing quiz options
    String options[] = {
            "1", "7", "9", "12",
            "Edible pea flower", "Edible plant flower", "Edible stem flower", "None of the above",
            "Blue Flax Lily", "Native Ginger", "Grass Tree", "Riberry",
            "Native mint", "Banksia", "Crimson Bottlebrush", "Paperbark",
            "Plum Pine", "Native Mint", "Riberry", "Port Jackson Fig"
    };








    //flag = boolean variable and signals when conditions do exist in the program
    //used to declare if
    int flag = 0;
    public static int mark = 0, correct = 0, wrong = 0;

    @Override
    //start of the plant quiz activty
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        TextView scoreStatus = (TextView) findViewById(R.id.tvscoreStatus);
        BottomNavigationView bottomNavigationView;

        //retrieves player's name from EditText
        playerName = findViewById(R.id.playerName);
        String input = getIntent().getStringExtra("playerName");
        if (input.trim().equals("")) //.trim to remove white space
            playerName.setText("Hello Player");
        else
            playerName.setText("Great Job!");


        // next button declarations
        nextBtn = (Button) findViewById(R.id.nxtBtn);
        // question with options function
        quizQuestion = (TextView) findViewById(R.id.tvquizQuestion);

        //declarations
        RadioGroup radioGroup = findViewById(R.id.answerOptions);
        TextView quizQuestion = findViewById(R.id.tvquizQuestion);
        RadioButton rbA = findViewById(R.id.rb1);
        RadioButton rbB = findViewById(R.id.rb2);
        RadioButton rbC = findViewById(R.id.rb3);
        RadioButton rbD = findViewById(R.id.rb4);

        quizQuestion.setText(questions[flag]);
        rbA.setText(options[0]);
        rbB.setText(options[1]);
        rbC.setText(options[2]);
        rbD.setText(options[3]);

//4 options
        Button nextButton = findViewById(R.id.nxtBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroup.getCheckedRadioButtonId() == -1) // if group of radio button is at option 1
                {
                    Toast.makeText(getApplicationContext(), "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton playerans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String answerText = playerans.getText().toString(); //might need to change this
                // flag is boolean variable (if option matches with answer then do the following)
                if (answerText.equals(answers[flag])) {
                    correct++;
                    //Toast message to alert customer if answer correct
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();

                    //Toast message to alert customer if answer incorrect

                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                }

                flag++;

                if (scoreStatus != null)
                    scoreStatus.setText("" + correct);

                //flag = boolean variable and signals when conditions do exist in the program and loops to next question
                if (flag < questions.length) {
                    quizQuestion.setText(questions[flag]);
                    rbA.setText(options[flag * 4]);
                    rbB.setText(options[flag * 4 + 1]);
                    rbC.setText(options[flag * 4 + 2]);
                    rbD.setText(options[flag * 4 + 3]);
                } else {
                    mark = correct;
                    Intent intent = new Intent(getApplicationContext(), QuizResults.class);
                    startActivity(intent);
                }

                //clear selection
                radioGroup.clearCheck();

            }

        });

//handle bottomNavigationBar (switch pages)
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
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
                        launchQuizActivity();
                        // handle quiz tab selection
                        return true;
                    case R.id.scancode:
                        launchQRScanActivity();
                        // handle timeline tab selection
                        return true;
                }
                return false;
            }
        });
    }

    public void launchHomeActivity() {
        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
        Intent intent = new Intent(QuizActivity.this, QuizStartPage.class);
        startActivity(intent);
    }

    public void launchPlantPageActivity() {
        Intent intent = new Intent(QuizActivity.this, PlantPageActivity.class);
        startActivity(intent);
    }

    public void launchMapActivity() {
        Intent intent = new Intent(QuizActivity.this, MapViewActivity.class);
        startActivity(intent);
    }

    public void launchQRScanActivity() {
        Intent intent = new Intent(QuizActivity.this, QRScanActivity.class);
        startActivity(intent);
    }
}







































