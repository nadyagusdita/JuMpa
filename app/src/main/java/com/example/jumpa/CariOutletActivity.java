package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CariOutletActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_outlet);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        ImageButton arrow_back = findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DropOffActivity.class);
                startActivity(intent);
            }
        });

        Button btn_pilih = findViewById(R.id.btn_pilih);
        btn_pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DropOffActivity.class);
                startActivity(intent);
            }
        });

        Spinner dropDownOutlet = findViewById(R.id.spinner_outlet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.item_outlet, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDownOutlet.setAdapter(adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        float zoomLevel = 16.0f;
        LatLng padang = new LatLng(-0.9231668258508885, 100.36276290267332);
        map.addMarker(new MarkerOptions().position(padang));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(padang, zoomLevel));
    }
}