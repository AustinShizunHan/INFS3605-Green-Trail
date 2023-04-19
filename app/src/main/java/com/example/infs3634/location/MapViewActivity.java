package com.example.infs3634.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.plant.QRScanActivity;
import com.example.infs3634.plant.ReserveActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.example.infs3634.timeline.TimelineActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MapViewActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final LatLng Plant1 = new LatLng(-33.917285252570245, 151.22632669113395);
    private final LatLng Plant2 = new LatLng(-33.916645315222944, 151.2262411027797);
    private final LatLng Plant3 = new LatLng(-33.91630749036646, 151.22659608574637);
    private final LatLng Plant4 = new LatLng(-33.91584253218571, 151.22655161189016);
    private final LatLng Plant5 = new LatLng(-33.915705812226626, 151.2266507675203);
    private final LatLng Plant6 = new LatLng(-33.91560960175358, 151.2269390815834);
    private final LatLng Plant7 = new LatLng(-33.9157387263109, 151.22688263914776);
    private final LatLng Plant8 = new LatLng(-33.91616914009568, 151.2281274236717);
    private final LatLng Plant9 = new LatLng(-33.91704135470922, 151.2321298350483);
    private final LatLng Plant10 = new LatLng(-33.91714915629148, 151.2321245554784);
    private final LatLng Plant11 = new LatLng(-33.917267147556736, 151.2321026809012);
    private final LatLng Plant12 = new LatLng(-33.917388769151465, 151.232056744289);
    private final LatLng Plant13 = new LatLng(-33.91676798388708, 151.23435984481068);
    private final LatLng Plant14 = new LatLng(-33.91642864509301, 151.2344620946466);
    private final LatLng Plant15 = new LatLng(-33.916642767184044, 151.2346874954994);
    private final LatLng Plant16 = new LatLng(-33.91674367510937, 151.23479723012508);
    private final LatLng Plant17 = new LatLng(-33.918001655529864, 151.23480754896852);
    private final LatLng Plant18 = new LatLng(-33.91796921418948, 151.2345278792056);
    private final LatLng Plant19 = new LatLng(-33.91796697588549, 151.23430314502295);
    private final LatLng Plant20 = new LatLng(-33.91782355422574, 151.23211756484113);
    private final LatLng Plant21 = new LatLng(-33.9179504280738, 151.23207330724446);
    private final LatLng Plant22 = new LatLng(-33.91820298300065, 151.23206040709246);
    private final LatLng Plant23 = new LatLng(-33.91712504171482, 151.23007736997792);
    private final LatLng Plant24 = new LatLng(-33.91733435405896, 151.230168887348);
    private final LatLng Plant25 = new LatLng(-33.9173941368591, 151.22761792802163);
    private final LatLng Nura_Gilli = new LatLng(-33.9178784,151.2312391);
    private final LatLng Aboriginal_Flag_Raised = new LatLng(-33.916704, 151.234616);
    private final LatLng Shaded_Study_Area1 = new LatLng(-33.9175074,151.2311203);
    private final LatLng Shaded_Study_Area2 = new LatLng(-33.917670, 151.228235);
    private final LatLng Shaded_Study_Area3 = new LatLng(-33.916171, 151.229247);

    private Marker marker1;
    private Marker marker2;
    private Marker marker3;
    private Marker marker4;
    private Marker marker5;
    private Marker marker6;
    private Marker marker7;
    private Marker marker8;
    private Marker marker9;
    private Marker marker10;
    private Marker marker11;
    private Marker marker12;
    private Marker marker13;
    private Marker marker14;
    private Marker marker15;
    private Marker marker16;
    private Marker marker17;
    private Marker marker18;
    private Marker marker19;
    private Marker marker20;
    private Marker marker21;
    private Marker marker22;
    private Marker marker23;
    private Marker marker24;
    private Marker marker25;
    private Marker marker_nuragilli;
    private Marker marker_flag;
    private Marker marker_shade1;
    private Marker marker_shade2;
    private Marker marker_shade3;

    MapView mapView;
    GoogleMap map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview_page);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        BottomNavigationView bottomNavigationView;

        //handle bottomNavigationBar (switch pages)
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.location);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        launchHomeActivity();
                        // handle Home tab selection
                        return true;
                    case R.id.location:
//                        launchMapActivity();
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
                Intent intent = new Intent(MapViewActivity.this, ReserveActivity.class);
                // Start the QRScanActivity
                startActivity(intent);
            }
        });

        //set radio button activity
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Plant23,15));
                marker1.setVisible(true);
                marker2.setVisible(true);
                marker3.setVisible(true);
                marker4.setVisible(true);
                marker5.setVisible(true);
                marker6.setVisible(true);
                marker7.setVisible(true);
                marker8.setVisible(true);
                marker9.setVisible(true);
                marker10.setVisible(true);
                marker11.setVisible(true);
                marker12.setVisible(true);
                marker13.setVisible(true);
                marker14.setVisible(true);
                marker15.setVisible(true);
                marker16.setVisible(true);
                marker17.setVisible(true);
                marker18.setVisible(true);
                marker19.setVisible(true);
                marker20.setVisible(true);
                marker21.setVisible(true);
                marker22.setVisible(true);
                marker23.setVisible(true);
                marker24.setVisible(true);
                marker25.setVisible(true);
                marker_nuragilli.setVisible(false);
                marker_flag.setVisible(false);
                marker_shade1.setVisible(false);
                marker_shade2.setVisible(false);
                marker_shade3.setVisible(false);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Plant10,16));
                marker1.setVisible(false);
                marker2.setVisible(false);
                marker3.setVisible(false);
                marker4.setVisible(false);
                marker5.setVisible(false);
                marker6.setVisible(false);
                marker7.setVisible(false);
                marker8.setVisible(false);
                marker9.setVisible(false);
                marker10.setVisible(false);
                marker11.setVisible(false);
                marker12.setVisible(false);
                marker13.setVisible(false);
                marker14.setVisible(false);
                marker15.setVisible(false);
                marker16.setVisible(false);
                marker17.setVisible(false);
                marker18.setVisible(false);
                marker19.setVisible(false);
                marker20.setVisible(false);
                marker21.setVisible(false);
                marker22.setVisible(false);
                marker23.setVisible(false);
                marker24.setVisible(false);
                marker25.setVisible(false);
                marker_nuragilli.setVisible(true);
                marker_flag.setVisible(true);
                marker_shade1.setVisible(false);
                marker_shade2.setVisible(false);
                marker_shade3.setVisible(false);
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Shaded_Study_Area3,16));
                marker1.setVisible(false);
                marker2.setVisible(false);
                marker3.setVisible(false);
                marker4.setVisible(false);
                marker5.setVisible(false);
                marker6.setVisible(false);
                marker7.setVisible(false);
                marker8.setVisible(false);
                marker9.setVisible(false);
                marker10.setVisible(false);
                marker11.setVisible(false);
                marker12.setVisible(false);
                marker13.setVisible(false);
                marker14.setVisible(false);
                marker15.setVisible(false);
                marker16.setVisible(false);
                marker17.setVisible(false);
                marker18.setVisible(false);
                marker19.setVisible(false);
                marker20.setVisible(false);
                marker21.setVisible(false);
                marker22.setVisible(false);
                marker23.setVisible(false);
                marker24.setVisible(false);
                marker25.setVisible(false);
                marker_nuragilli.setVisible(false);
                marker_flag.setVisible(false);
                marker_shade1.setVisible(true);
                marker_shade2.setVisible(true);
                marker_shade3.setVisible(true);

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        // Set up the Google Map with desired options
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Plant23,15));


        //Add Markers
        marker1 = googleMap.addMarker(new MarkerOptions()
                .position(Plant1)
                .title("Hills Fig"));

        marker2 = googleMap.addMarker(new MarkerOptions()
                .position(Plant2)
                .title("Gymea Lily"));

        marker3 = googleMap.addMarker(new MarkerOptions()
                .position(Plant3)
                .title("Broad-leaved Paperbark"));

        marker4 = googleMap.addMarker(new MarkerOptions()
                .position(Plant4)
                .title("Crimson Bottlebrush"));

        marker5 = googleMap.addMarker(new MarkerOptions()
                .position(Plant5)
                .title("Heath Banksia"));

        marker6 = googleMap.addMarker(new MarkerOptions()
                .position(Plant6)
                .title("Mountain Ceder Wattle"));

        marker7 = googleMap.addMarker(new MarkerOptions()
                .position(Plant7)
                .title("Native Mint"));

        marker8 = googleMap.addMarker(new MarkerOptions()
                .position(Plant8)
                .title("Tuckeroo"));

        marker9 = googleMap.addMarker(new MarkerOptions()
                .position(Plant9)
                .title("Prickly Leaved tea Tree"));

        marker10 = googleMap.addMarker(new MarkerOptions()
                .position(Plant10)
                .title("Water Vine"));

        marker11 = googleMap.addMarker(new MarkerOptions()
                .position(Plant11)
                .title("Rock Lily"));

        marker12 = googleMap.addMarker(new MarkerOptions()
                .position(Plant12)
                .title("Sandpaper Fig"));

        marker13 = googleMap.addMarker(new MarkerOptions()
                .position(Plant13)
                .title("Burrawang"));

        marker14 = googleMap.addMarker(new MarkerOptions()
                .position(Plant14)
                .title("Plum Pine/Brown Pine"));

        marker15 = googleMap.addMarker(new MarkerOptions()
                .position(Plant15)
                .title("Tussock Grass"));

        marker16 = googleMap.addMarker(new MarkerOptions()
                .position(Plant16)
                .title("Cabbage Tree Palm"));

        marker17 = googleMap.addMarker(new MarkerOptions()
                .position(Plant17)
                .title("Bolwarra"));

        marker18 = googleMap.addMarker(new MarkerOptions()
                .position(Plant18)
                .title("Blue Flax Lily"));

        marker19 = googleMap.addMarker(new MarkerOptions()
                .position(Plant19)
                .title("Old Man Banksia"));

        marker20 = googleMap.addMarker(new MarkerOptions()
                .position(Plant20)
                .title("Matrush"));

        marker21 = googleMap.addMarker(new MarkerOptions()
                .position(Plant21)
                .title("Ribery"));

        marker22 = googleMap.addMarker(new MarkerOptions()
                .position(Plant22)
                .title("Grass Tree"));

        marker23 = googleMap.addMarker(new MarkerOptions()
                .position(Plant23)
                .title("Native Ginger"));

        marker24 = googleMap.addMarker(new MarkerOptions()
                .position(Plant24)
                .title("Flame Tree"));

        marker25 = googleMap.addMarker(new MarkerOptions()
                .position(Plant25)
                .title("Port Jackson Fig"));

        marker_nuragilli = googleMap.addMarker(new MarkerOptions()
                .position(Nura_Gilli)
                .title("Nura_Gilli")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        marker_flag = googleMap.addMarker(new MarkerOptions()
                .position(Aboriginal_Flag_Raised)
                .title("Aboriginal_Flag_Raised")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        marker_shade1 = googleMap.addMarker(new MarkerOptions()
                .position(Shaded_Study_Area1)
                .title("Shaded_Study_Area 1")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        marker_shade2 = googleMap.addMarker(new MarkerOptions()
                .position(Shaded_Study_Area2)
                .title("Shaded_Study_Area 2")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        marker_shade3 = googleMap.addMarker(new MarkerOptions()
                .position(Shaded_Study_Area3)
                .title("Shaded_Study_Area 3")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


    }
    public void launchHomeActivity() {
        Intent intent = new Intent(MapViewActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void launchQuizActivity() {
        Intent intent = new Intent(MapViewActivity.this, QuizStartPage.class);
        startActivity(intent);
    }

    public void launchPlantPageActivity() {
        Intent intent = new Intent(MapViewActivity.this, PlantPageActivity.class);
        startActivity(intent);
    }

    public void launchMapActivity() {
        Intent intent = new Intent(MapViewActivity.this, MapViewActivity.class);
        startActivity(intent);
    }

    public void launchQRScanActivity() {
        Intent intent = new Intent(MapViewActivity.this, QRScanActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}