package com.example.infs3634;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//Implement OnMapReadyCallback.
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    UiSettings mUiSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);

      // Create a new SupportMapFragment instance
        SupportMapFragment mapFragment = new SupportMapFragment();

       // Begin the transaction to add the SupportMapFragment to the layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
        .add(R.id.map_container, mapFragment)
        .commit();

        // Set the callback listener for when the map is ready to be used
        mapFragment.getMapAsync(this);


    }


        //Get a handle to the GoogleMap object and display marker.
    @Override
    public void onMapReady(GoogleMap map) {

        mMap = map;

        mUiSettings = mMap.getUiSettings();

        //UI settings for Google map
        mUiSettings.setZoomControlsEnabled(true);
//        map.setMyLocationEnabled(true);
//        map.setOnMyLocationButtonClickListener(this);
//        map.setOnMyLocationClickListener(this);

        //Add Markers
        final LatLng unswLatLng = new LatLng(-33.917285252570245, 151.22632669113395);
        Marker unsw = map.addMarker(
                new MarkerOptions()
                        .position(unswLatLng)
                        .title("unsw"));
        unsw.showInfoWindow();

    }
}