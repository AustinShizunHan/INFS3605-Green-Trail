package com.example.infs3634;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {
    TimelineModel TimelineModel;
    ArrayList<TimelineModel> timelineArrayList;
    TimelineAdapter TimelineAdapter;
    RecyclerView timelineRecyclerview;
    TextView context;

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


        context = findViewById(R.id.context);
    }


// method to fill array with data
        public static ArrayList<TimelineModel> getTimelineData() {
            ArrayList<TimelineModel> timelineArrayList = new ArrayList<>();
            timelineArrayList.add(new TimelineModel("1990s","The Bush Tucker Trail (previously known as " +
                    "the Green Trail) has been on campus since approximately the 1990s." ));
            timelineArrayList.add(new TimelineModel("2000s","UNSW Estate and students " +
                    "were involved in the early creation, mapping and maintenance of the trail." ));
            timelineArrayList.add(new TimelineModel("2007","The Bush Tucker Trail is opened " +
                    "for the public." ));
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
                    "UNSW Indigenous plants in a creative manner." ));

            timelineArrayList.add(new TimelineModel("March 2023","Students in INFS3605 " +
                    "help generate ideas for the Bush Tucker Trail by designing and " +
                    "pitching applications to stakeholders. " ));
            return timelineArrayList;
        }
    }


