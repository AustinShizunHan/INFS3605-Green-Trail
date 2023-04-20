package com.example.infs3634;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.location.MapViewActivity;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.plant.QRScanActivity;
import com.example.infs3634.plant.ReserveActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.example.infs3634.timeline.TimelineActivity;
import com.google.android.gms.maps.MapView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
        /*
        References
        Used an image for acknowledgement page: https://unsplash.com/photos/LanGUEBuDPY

        Used images on main activity layout:
        https://www.indigenous.unsw.edu.au/sites/default/files/styles/teaser_desktop/public/images/3.jpg?h=d318f057&itok=rUpQX4cm
        https://www.indigenous.unsw.edu.au/sites/default/files/styles/massive/public/images/Nura-Gili-flags-bg2.jpg?itok=8WJIDYQ2
        */
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView Nura_gili;
    ImageView Guruwaal_Stories;
    ImageView BTT_timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //handle bottomNavigationBar (switch pages)
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                        launchHomeActivity();
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

        //Press list button to open favorite plant page
        ImageView list_button = findViewById(R.id.plants_right_image);
        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the QRScanActivity
                Intent intent = new Intent(MainActivity.this, ReserveActivity.class);
                // Start the QRScanActivity
                startActivity(intent);
            }
        });

        // Click Nura Gili image (referred from the website below) jump to the website
        Nura_gili = findViewById(R.id.Nura_gili);
        Nura_gili.setClickable(true);
        Nura_gili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.indigenous.unsw.edu.au"));
                startActivity(browserIntent);
            }
        });

        // Click Guruwaal_Stories image (referred from the website below) jump to the website
        Guruwaal_Stories = findViewById(R.id.Guruwaal_stories);
        Guruwaal_Stories.setClickable(true);
        Guruwaal_Stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.indigenous.unsw.edu.au/strategy/culture-and-country/guruwaal-stories"));
                startActivity(browserIntent);
            }
        });

        //Click bush tack trail image (referred from the website below) jump to timeline page
        BTT_timeline = findViewById(R.id.BTT_timeline);
        BTT_timeline.setClickable(true);
        BTT_timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTimelineActivity();
            }
        });

    }

    public void launchHomeActivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
        Intent intent = new Intent(MainActivity.this, QuizStartPage.class);
        startActivity(intent);
    }

    public void launchPlantPageActivity() {
        Intent intent = new Intent(MainActivity.this, PlantPageActivity.class);
        startActivity(intent);
    }

    public void launchMapActivity() {
        Intent intent = new Intent(MainActivity.this, MapViewActivity.class);
        startActivity(intent);
    }

    public void launchTimelineActivity() {
        Intent intent = new Intent(MainActivity.this, TimelineActivity.class);
        startActivity(intent);

    }
    public void launchQRScanActivity() {
        Intent intent = new Intent(MainActivity.this, QRScanActivity.class);
        startActivity(intent);
    }
}
