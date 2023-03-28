package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;
public class PlantDetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");

        TextView plantNameTextView = findViewById(R.id.plant_name_text_view);
        TextView plantDescriptionTextView = findViewById(R.id.plant_details_text_view);
        VideoView videoView = findViewById(R.id.plant_video_view);

        // Set the video URL
        String videoUrl = "https://www.youtube.com/watch?v=Rn5jZWfJVIs"; // replace this with your actual video URL
        Uri videoUri = Uri.parse(videoUrl);

        // Set the plant name and description in the TextViews
        plantNameTextView.setText(name);
        plantDescriptionTextView.setText(description);

        // Set the video URI and start playback
        videoView.setVideoURI(videoUri);
        videoView.start();

        // Add media controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
