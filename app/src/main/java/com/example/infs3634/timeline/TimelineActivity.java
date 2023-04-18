package com.example.infs3634.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634.MainActivity;
import com.example.infs3634.location.MapViewActivity;
import com.example.infs3634.R;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.plant.QRScanActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {
    com.example.infs3634.timeline.TimelineModel TimelineModel;
    ArrayList<TimelineModel> timelineArrayList;
    com.example.infs3634.timeline.TimelineAdapter TimelineAdapter;
    RecyclerView timelineRecyclerview;
    TextView context;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);

        //timelineArrayList = new ArrayList<TimelineModel>();
        timelineArrayList = getTimelineData();
        TimelineAdapter = new TimelineAdapter(timelineArrayList);


        timelineRecyclerview = findViewById(R.id.timelineRecyclerview);
        timelineRecyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //assign layout to our specified discussionRecyclerView
        timelineRecyclerview.setLayoutManager(layoutManager);
        timelineRecyclerview.setAdapter(TimelineAdapter);

        context = findViewById(R.id.timeline_content);

        //using bar to switch between pages
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.scancode);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        launchHomeActivity();
                        //handle Home tab selection
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
                        // handle time tab selection
                        return true;
                }
                return false;
            }
        });
    }


    // method to fill array with data
    public static ArrayList<TimelineModel> getTimelineData() {
        ArrayList<TimelineModel> timelineArrayList = new ArrayList<>();
        timelineArrayList.add(new TimelineModel("1990s","The Bush Tucker Trail (previously known as " +
                "the Green Trail) has been on campus since approximately the 1990s." ));
        timelineArrayList.add(new TimelineModel("2000s","UNSW Estate and students " +
                "were involved in the early creation, mapping and maintenance of the trail." ));
        timelineArrayList.add(new TimelineModel("2007","The Bush Tucker Trail is opened " +
                "for the public." )); // Reference A
        timelineArrayList.add(new TimelineModel("2021","The Science Sustainability Working Group " +
                "approves an initial budget to employ students to improve the trail." ));

        timelineArrayList.add(new TimelineModel("Oct 2021"," The team collaborates" +
                " with UNSW Estate Management, UNSW Sustainability, " +
                "Nura Gili and students and staff in ADA faculties."));

        timelineArrayList.add(new TimelineModel("Nov 2021","Stocktake of the trail " +
                "revealed areas for improvement such as updating signage, raising awareness " +
                "and increasing representation of Indigenous voice." ));

        timelineArrayList.add(new TimelineModel("Oct 2022","A competition opens for UNSW students " +
                "to submit their logo design. This enables students to engage with " +
                "UNSW Indigenous plants in a creative manner." )); // Reference B

        timelineArrayList.add(new TimelineModel("March 2023","Students in INFS3605 " +
                "help generate ideas for the Bush Tucker Trail by designing and " +
                "pitching applications to stakeholders. " ));
        return timelineArrayList;
    }

    public void launchHomeActivity() {
        Intent intent = new Intent(TimelineActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void launchMapActivity() {
        Intent intent = new Intent(TimelineActivity.this, MapViewActivity.class);
        startActivity(intent);
    }
    public void launchPlantPageActivity() {
        Intent intent = new Intent(TimelineActivity.this, PlantPageActivity.class);
        startActivity(intent);
    }
    public void launchQuizActivity() {
        Intent intent = new Intent(TimelineActivity.this, QuizStartPage.class);
        startActivity(intent);
    }
    public void launchQRScanActivity() {
        Intent intent = new Intent(TimelineActivity.this, QRScanActivity.class);
        startActivity(intent);
    }
}

// References below are used to find data for the timeline,
// remaining data is sourced from INFS3605 course resources provided by teaching staff
/*
Reference A: https://newsroom.unsw.edu.au/news/hit-green-trail
Reference B: https://www.student.unsw.edu.au/notices/2022/09/logo-design-competition-bush-tucker-trail
Other references used: Bush food trail summary (Project A), Green Trail Stocktake Report
 */


