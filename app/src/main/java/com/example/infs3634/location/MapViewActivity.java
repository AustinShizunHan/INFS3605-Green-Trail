package com.example.infs3634.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;
import com.example.infs3634.plant.PlantDetailActivity;
import com.example.infs3634.plant.PlantPageActivity;
import com.example.infs3634.plant.QRScanActivity;
import com.example.infs3634.quiz.QuizStartPage;
import com.example.infs3634.timeline.TimelineActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MapViewActivity extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener{

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

    private MapView mMapView;
    private GoogleMap mGoogleMap;
    UiSettings mUiSettings;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview_page);

        mMapView = findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
//                mGoogleMap.setOnInfoWindowClickListener(this);
                mGoogleMap = googleMap;
                mUiSettings = mGoogleMap.getUiSettings();

                // Set up the Google Map with desired options
                mUiSettings.setZoomControlsEnabled(true);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Plant23,15));

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
            }
        });


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
//                        launchMapViewActivity();
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

                        return true;

                }
                return false;
            }
        });
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

    public void launchMapViewActivity() {
        Intent intent = new Intent(MapViewActivity.this, MapViewActivity.class);
        startActivity(intent);
    }

    public void launchQRScanActivity() {
        Intent intent = new Intent(MapViewActivity.this, QRScanActivity.class);
        startActivity(intent);
    }

    //Navigate to PlantDetail Page when click on the info window of the marker
    @Override
    public void onInfoWindowClick(Marker marker) {
        // Launch the new activity or fragment here
        Intent intent = new Intent(this, PlantDetailActivity.class);
        startActivity(intent);
    }
}
