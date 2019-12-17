package com.example.projetappmobile.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projetappmobile.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;


    public static MapsFragment newInstance() {
        MapsFragment fragment = new MapsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, null, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng nairobie = new LatLng(-3.042048, 36.752887);
        mMap.addMarker(new MarkerOptions().position(nairobie).title("Nairobi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobie));

        LatLng dubai = new LatLng(25.0657, 55.1713);
        mMap.addMarker(new MarkerOptions().position(dubai).title("Dubai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dubai));

        LatLng bombay = new LatLng(18.9298324, 72.83336088337234);
        mMap.addMarker(new MarkerOptions().position(bombay).title("Bombay"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bombay));

        LatLng bogota = new LatLng(4.59808, -74.0760439);
        mMap.addMarker(new MarkerOptions().position(bogota).title("Bogota"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bogota));

        LatLng wc = new LatLng(38.8948932, -77.0365529);
        mMap.addMarker(new MarkerOptions().position(wc).title("Washington D.C"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wc));

        LatLng santiago = new LatLng(-33.4377968, -70.6504451);
        mMap.addMarker(new MarkerOptions().position(santiago).title("Santiago du Chili"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(santiago));



    }
}