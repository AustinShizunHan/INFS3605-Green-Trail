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
            timelineArrayList.add(new TimelineModel("1990s","The Bush Tucker Trail has " +
                    "been on campus since the 1990s (approx.)" ));
            timelineArrayList.add(new TimelineModel("2000s","UNSW Estate and students " +
                    "were involved in the early creation, mapping and maintenance of the trail. " ));
            timelineArrayList.add(new TimelineModel("2007s","The Bush Tucker Trail is opened" +
                    "for the public. " ));
            timelineArrayList.add(new TimelineModel("2021","The Science Sustainability Working Group " +
                    "approves an initial budget to employ students to improve the trail." ));
            timelineArrayList.add(new TimelineModel("Nov 2021","A stocktake of the trail " +
                    "was undertaken by UNSW staff and students …. The name of the trail is changed " +
                    "from Green Trail to the ‘Bush Tucker Trail’ to better represent Indigenous voice. " ));
            timelineArrayList.add(new TimelineModel("Oct 2022","A design competition opportunity opens for UNSW students to submit their design for the Bush Tucker Trail. This opportunity will give you a chance to increase awareness and engagement with UNSW Indigenous plants on Kensington Campus. \n" +
                    "\n" +
                    "https://www.student.unsw.edu.au/notices/2022/09/logo-design-competition-bush-tucker-trail \n" ));
            timelineArrayList.add(new TimelineModel("March 2023","Students in INFS3605 are " +
                    "given the task to help generate ideas for the Bush Tucker Trail by designing and " +
                    "pitching applications to stakeholders. " ));
            return timelineArrayList;
        }
    }


