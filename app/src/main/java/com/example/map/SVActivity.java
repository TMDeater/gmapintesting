package com.example.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class SVActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {


    private double lat;
    private double lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sv);
        StreetViewPanoramaFragment mF = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.sview);
        mF.getStreetViewPanoramaAsync(this);
    }
    @Override
    public void onStreetViewPanoramaReady (StreetViewPanorama panorama) {
        Intent intent = getIntent();
        lat = intent.getDoubleExtra("Lat", 0);
        lng = intent.getDoubleExtra("Long", 0);
        panorama.setPosition(new LatLng(lat, lng));

    }
}
