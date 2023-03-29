package com.example.infs3634;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//Implement OnMapReadyCallback.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.activity_main);

//        // Create a new SupportMapFragment instance
//        SupportMapFragment mapFragment = new SupportMapFragment();
//
//        // Begin the transaction to add the SupportMapFragment to the layout
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//        .add(R.id.map_container, mapFragment)
//        .commit();
//
//        // Set the callback listener for when the map is ready to be used
//        mapFragment.getMapAsync(this);
    }


        //Get a handle to the GoogleMap object and display marker.
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(0, 0))
//                .title("Marker"));
//    }
}