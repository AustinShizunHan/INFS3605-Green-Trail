package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;
public class PlantDetailActivity extends AppCompatActivity{
    private WebView webView;
    private static  final  String IFRAME_EMBED_CODE="<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iban71MLIiM\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
//        String name = getIntent().getStringExtra("name");
//        String description = getIntent().getStringExtra("description");
//
//        TextView plantNameTextView = findViewById(R.id.plant_name_text_view);
//        TextView plantDescriptionTextView = findViewById(R.id.plant_details_text_view);
//        VideoView videoView = findViewById(R.id.plant_video_view);

        // Set the video URL
//        String videoUrl = "https://www.youtube.com/watch?v=Rn5jZWfJVIs"; // replace this with your actual video URL
//        Uri videoUri = Uri.parse(videoUrl);
//
//        // Set the plant name and description in the TextViews
//        plantNameTextView.setText(name);
//        plantDescriptionTextView.setText(description);
//
//        // Set the video URI and start playback
//        videoView.setVideoURI(videoUri);
//        videoView.start();
//
//        // Add media controls
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
    }
}
