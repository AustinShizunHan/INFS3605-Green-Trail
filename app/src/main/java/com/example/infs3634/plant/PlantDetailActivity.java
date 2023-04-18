package com.example.infs3634.plant;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;


import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.location.MapViewActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.example.infs3634.timeline.TimelineActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class PlantDetailActivity extends AppCompatActivity {
    private WebView webView;
    private static final String IFRAME_EMBED_CODE1 = "<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/Bz2QA3rJLEI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static final String IFRAME_EMBED_CODE2 = "<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/0RLhvVwefeU\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static final String IFRAME_EMBED_CODE3 = "<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/f5-2oCvxCLc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private static final String IFRAME_EMBED_CODE4 = "<iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/A4Vs-qDWvWs\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
    private ImageView iv_reserve, plants_right_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView search;
        BottomNavigationView bottomNavigationView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);
        webView = findViewById(R.id.webView);
        plants_right_image = findViewById(R.id.plants_right_image);
        plants_right_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlantDetailActivity.this, ReserveActivity.class);
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
                SQLiteDatabase db = mySQLite.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name", name);
                db.insert("record", null, values);
                db.close();
                Toast.makeText(PlantDetailActivity.this, "added", Toast.LENGTH_SHORT).show();
            }
        });
        TextView plantNameTextView = findViewById(R.id.plant_name_text_view);
        TextView plantDescriptionTextView = findViewById(R.id.plant_details_text_view);
        plantNameTextView.setText(name);
        plantDescriptionTextView.setText(description);
        if (name.equals("Gymea Lilly")) {
            webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE1, "text/html", "utf-8", "https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        } else if (name.equals("Broad-leaved Paperbark")) {
            webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE2, "text/html", "utf-8", "https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        } else if (name.equals("Native Mint")) {
            webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE3, "text/html", "utf-8", "https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        } else if (name.equals("Sandpaper Fig")) {
            webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE4, "text/html", "utf-8", "https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        } else {
            webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE2, "text/html", "utf-8", "https://developers.google.com/youtube/iframe_api_reference?hl=zh-cn");
        }

        // Click Search for another plant image jump back to the plant page
        search = findViewById(R.id.search);
        search.setClickable(true);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPlantPageActivity();
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
        Intent intent = new Intent(PlantDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
        Intent intent = new Intent(PlantDetailActivity.this, QuizStartPage.class);
        startActivity(intent);
    }

    public void launchPlantPageActivity() {
        Intent intent = new Intent(PlantDetailActivity.this, PlantPageActivity.class);
        startActivity(intent);
    }

    public void launchMapActivity() {
        Intent intent = new Intent(PlantDetailActivity.this, MapViewActivity.class);
        startActivity(intent);
    }

    public void launchQRScanActivity() {
        Intent intent = new Intent(PlantDetailActivity.this, QRScanActivity.class);
        startActivity(intent);
    }
}

