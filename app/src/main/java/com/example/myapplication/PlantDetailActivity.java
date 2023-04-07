package com.example.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;
public class PlantDetailActivity extends AppCompatActivity{
    private WebView webView;
    private static  final  String IFRAME_EMBED_CODE1="<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/Bz2QA3rJLEI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static  final  String IFRAME_EMBED_CODE2="<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/0RLhvVwefeU\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static  final  String IFRAME_EMBED_CODE3="<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/f5-2oCvxCLc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static  final  String IFRAME_EMBED_CODE4="<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/A4Vs-qDWvWs\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private ImageView iv_reserve,plants_right_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);
        webView = findViewById(R.id.webView);
        plants_right_image = findViewById(R.id.plants_right_image);
        plants_right_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlantDetailActivity.this,ReserveActivity.class);
                startActivity(intent1);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        final String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        iv_reserve = findViewById(R.id.iv_reserve);
        iv_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_reserve.setImageResource(R.drawable.liked);
                MySqlite mySQLite = new MySqlite(PlantDetailActivity.this, 1);
                SQLiteDatabase db= mySQLite.getWritableDatabase();

                ContentValues values=new ContentValues();
                values.put("name",name);
                db.insert("record", null, values);
                db.close();
                Toast.makeText(PlantDetailActivity.this,"added", Toast.LENGTH_SHORT).show();
            }
        });
        TextView plantNameTextView = findViewById(R.id.plant_name_text_view);
        TextView plantDescriptionTextView = findViewById(R.id.plant_details_text_view);
        plantNameTextView.setText(name);
        plantDescriptionTextView.setText(description);
        if(name.equals("Gymea Lilly")){
            webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE1,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }else if(name.equals("Broad-leaved Paperbark")){
            webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE2,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }else if(name.equals("Native Mint")){
            webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE3,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }else if(name.equals("Sandpaper Fig")){
            webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE4,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }else{
            webView.loadDataWithBaseURL("https://www.youtube.com",IFRAME_EMBED_CODE2,"text/html","utf-8","https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }
//        VideoView videoView = findViewById(R.id.plant_video_view);

//        String videoUrl = "https://www.youtube.com/watch?v=Rn5jZWfJVIs"; // replace this with your actual video URL
//        Uri videoUri = Uri.parse(videoUrl);


        // Set the video URI and start playback
//        videoView.setVideoURI(videoUri);
//        videoView.start();

        // Add media controls
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
    }
}
