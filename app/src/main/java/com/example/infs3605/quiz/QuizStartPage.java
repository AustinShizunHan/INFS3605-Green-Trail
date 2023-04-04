//package com.example.infs3605.quiz;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.example.infs3634.R;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;
//
//
////import au.edu.unsw.infs3634.unswlearning.R;
////import au.edu.unsw.infs3634.unswlearning.adoption.AdoptionActivity;
////import au.edu.unsw.infs3634.unswlearning.home.HomeDashboardActivity;
//
///**
// * Quiz start page is the first screen to the dog quiz
// * it allows user to start the quiz and navigvate across home bar
// */
//
//public class QuizStartPage extends AppCompatActivity {
//    //setting up navigation bar
//
//    BottomNavigationView bottomNavigationView;
//
//    @Override
//    //starting quiz activity
//    protected void onCreate(Bundle savedInstance) {
//        super.onCreate(savedInstance);
//        setContentView(R.layout.quiz_start);
//
//        //getting id's from xml
//        Button startButton=(Button) findViewById(R.id.button);
//        final TextView nameText=(TextView) findViewById(R.id.textView);
//        final TextView name = findViewById(R.id.editName);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.quizPage);
//
////        //Find user details from Firebase then set personalised title
////        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
////        name.setText("Welcome " + user.getDisplayName() + "!");
//
//
//        //Set up navigation bar
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//
//            public boolean onNavigationItemSelected(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.adoptPage:
//                        launchAdoptionActivity("Message from InfoActivity");
//                        return true;
//                    case R.id.homePage:
//                        launchHomeActivity("Message from InfoActivity");
//                        return true;
//                    case R.id.quizPage:
//                        launchQuizActivity("Message from InfoActivity");
//                        return true;
//                }
//                return false;
//            }
//        });
//
//        //functional start button and intent message retrives user name via Firebase
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(), QuizActivity.class);
//                intent.putExtra("myname",user.getDisplayName());
//                startActivity(intent);
//
//            }
//        });
//
//
//    }
//    //Set up methods to launch relevant screens for navigation bar
//    public void launchQuizActivity(String msg) {
//        Intent intent = new Intent(QuizStartPage.this, QuizActivity.class);
//        intent.putExtra(FinalResultActivity.INTENT_MESSAGE, msg);
//        startActivity(intent);
//        System.out.println("working");
//    }
//    // launching new activity from quiz start page (Adoption Activity)
//    public void launchAdoptionActivity(String msg) {
//        Intent intent = new Intent(QuizStartPage.this, AdoptionActivity.class);
//        intent.putExtra(AdoptionActivity.INTENT_MESSAGE, msg);
//        startActivity(intent);
//    }
//    // launching new activty from quiz start page (Home Screen)
//    public void launchHomeActivity(String msg) {
//        Intent intent = new Intent(QuizStartPage.this, HomeDashboardActivity.class);
//        intent.putExtra(HomeDashboardActivity.INTENT_MESSAGE, msg);
//        startActivity(intent);
//    }
//
//
//}
