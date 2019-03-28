package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    AlertDialog.Builder builder;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    SharedPreferences sp1;
    String unm, pass;

    private MarkerOptions options = new MarkerOptions();
    private ArrayList<LatLng> latlngs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        try
        {
            sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);
            unm = sp1.getString("Unm", null);
            pass = sp1.getString("Psw", null);
        }catch(NullPointerException e)
        {
            unm=null;
            pass=null;
        }

        builder = new AlertDialog.Builder(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder.setTitle("Toilets available");
                builder.setMessage("We have millions of toilets available for you at your destination please login to continue and find your best suited toilet right next to you.");
                builder.setPositiveButton("Sign In/Up", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(unm == null || pass == null) {
                            MapsActivity.this.startActivity(new Intent(MapsActivity.this, MainActivity.class));
                            MapsActivity.this.finish();
                        }
                        else
                        {
                            MapsActivity.this.startActivity(new Intent(MapsActivity.this, MainRoot.class));
                            MapsActivity.this.finish();
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        },6000);


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

        latlngs.add(new LatLng(22.8402973, 88.3364658)); //some latitude and logitude value
        latlngs.add(new LatLng(22.8302573, 88.3264458));
        latlngs.add(new LatLng(22.8202373, 88.3164258));
        latlngs.add(new LatLng(22.8102673, 88.3064958));
        latlngs.add(new LatLng(22.8002173, 88.3764858));
        latlngs.add(new LatLng(22.8702873, 88.3664158));

        String[] title = {"Ram Singh","Shyam Singh","Sonu","Subhas","Suresh","Ramesh"};
        String[] desc = {"Clean","More Facelities","Cheap","Close","More provision","Open"};

        int i = 0;

        for (LatLng point : latlngs) {
            options.position(point);
            options.title(title[i]);
            options.snippet(desc[i]);
            googleMap.addMarker(options);
            i++;
        }

        // Add a marker in Sydney and move the camera
        LatLng mankundu = new LatLng(22.8402973, 88.3464558);
        mMap.addMarker(new MarkerOptions().position(mankundu).title("Shyam Benegal").snippet("Best"));
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(mankundu,14);
        mMap.animateCamera(cu);

    }
}
