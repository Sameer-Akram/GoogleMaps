package com.example.googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btn1=(Button)findViewById(R.id.normal);
        btn2=(Button)findViewById(R.id.satellite);
        btn3=(Button)findViewById(R.id.terrain);
        btn4=(Button)findViewById(R.id.hybrid);
   btn1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
       }
   });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng WahCantt = new LatLng(33.7715, 72.7511);
//        normal_map:
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        hybrid_map:
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//        terrin_map:
//        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        satellite_map:
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.addMarker(new MarkerOptions().position(WahCantt).title("Marker in Wah Cantt"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WahCantt,15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20),2000,null);
//        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

    }
}