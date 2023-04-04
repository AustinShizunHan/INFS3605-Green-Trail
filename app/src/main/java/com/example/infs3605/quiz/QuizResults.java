package com.example.infs3605.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.example.infs3634.R;

    //import au.edu.unsw.infs3634.unswlearning.home.HomeDashboardActivity;
/**
 * Final Results is the last screen user views after completion of activity
 * accompanied by 3 textviews: correct, incorrect and final score
 * Restart button to re-attempt quiz
 * home button to revert to home screen
 */

public class FinalResultActivity extends AppCompatActivity {
    //declarations
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
        greeting = (TextView) findViewById(R.id.congratulationsTV);
        restartBtn = (Button) findViewById(R.id.btnTryagn);
        home = (Button) findViewById(R.id.btnHome);

        /**
         * String Buffer is used due to its modificarion and mutable capabilities
         */
        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers:" + QuizActivity.correct + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answers:" + QuizActivity.wrong + "\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score:" + QuizActivity.correct + "\n");

        //Find user details from Firebase to set personalised title
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        tvIncorret.setText(sb);
        tvCorrect.setText(sb2);
        tvFinalResults.setText(sb3);
        //set greeting called out based on firebased log-in user
        greeting.setText("Nice work " + user.getDisplayName() + "!");

        QuizActivity.correct = 0;
        QuizActivity.wrong = 0;

        //provides functionality to the restart button and enables user to re-do quiz
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent message to allow users to revert back to quiz page
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
            // provides functionality to the home button
        });
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // intent message to allow users to revert back to home screen
//                Intent intent = new Intent(getApplicationContext(), HomeDashboardActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}


public class QuizResults {


}
