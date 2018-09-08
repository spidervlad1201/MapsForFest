package com.vakuor.mapsforfest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    Button btnActTwo;
    LinearLayout llBottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    FloatingActionButton fab;
    View viewBottomSheet;
    View mainView;
    private Marker myMarker;
    TextView firstText;
    TextView secondText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//         Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        btnActTwo = (Button) findViewById(R.id.btnActTwo);
//        btnActTwo.setOnClickListener(this);

        fab = findViewById(R.id.fab);
        firstText = findViewById(R.id.firstText);
        secondText = findViewById(R.id.secondText);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState( BottomSheetBehavior.STATE_COLLAPSED);
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        viewBottomSheet = findViewById(R.id.bottom_sheet);
        mainView = findViewById(R.id.map);

        bottomSheetBehavior = BottomSheetBehavior.from(viewBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:{
                        mMap.clear();
                        setUpMark(-34, 151,"Marker in Sydney","Кошачьи бега");
                        setUpMark(47.210583, 38.930604,"Александровская 56","");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        break;}
                    case R.id.action_edit:{

                        mMap.clear();
                        setUpMark(47.216906,38.927864,"Греческая 105","");
                        setUpMark(47.217518,38.812215,"Мариупольское Шоссе 54г","");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                        break;}
                    case R.id.action_remove:{
                        mMap.clear();
                        setUpMark(47.208829,38.948705,"Место прибытия Петра Первого на фестиваль","Прибытие Петра I.Приветствие Петра I таганрожцам; Выступление «Барабанщиц»\n");
                        setUpMark(47.213538,38.939457,"Оркестр","");


                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        break;}
                    case R.id.fab:{
//                        Toast.makeText(MapsActivity.this,"Action Remove Call",Toast.LENGTH_SHORT).show();
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;}
                }
                return true;
            }
        });



        //if (fab.isPressed()){bottomSheetBehavior.setState( BottomSheetBehavior.STATE_COLLAPSED);}
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                if (BottomSheetBehavior.STATE_DRAGGING == newState) {
//                    fab.animate().scaleX(0).scaleY(0).setDuration(300).start();
//                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
//                    fab.animate().scaleX(1).scaleY(1).setDuration(300).start();
//                }
//                Toast.makeText(MapsActivity.this,newState+" ",Toast.LENGTH_SHORT).show();
                switch(newState){
                    case BottomSheetBehavior.STATE_HIDDEN:{fab.setActivated(true); ;break;}
                    case BottomSheetBehavior.STATE_COLLAPSED:{fab.setActivated(true);break;}
                    case BottomSheetBehavior.STATE_EXPANDED:{fab.setActivated(true);break;}
                    default: {break;}
                }
                if(newState == 5)
                fab.setVisibility(View.VISIBLE);
                else fab.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                fab.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        ft.hide(mapFragment).commit();
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

        setUpMark(-34, 151,"Marker in Sydney","Кошачьи бега");
        setUpMark(47.210583, 38.930604,"Александровская 56","");
        setUpMark(47.216906,38.927864,"Греческая 105","");
        setUpMark(47.217518,38.812215,"Мариупольское Шоссе 54г","");
        setUpMark(47.208829,38.948705,"Место прибытия Петра Первого на фестиваль","Прибытие Петра I.Приветствие Петра I таганрожцам; Выступление «Барабанщиц»\n");
        setUpMark(47.213538,38.939457,"Оркестр","");



//        LatLng geo1 = new LatLng(47.210583, 38.930604);
//        mMap.addMarker(new MarkerOptions().position(geo1).title("Александровская 56"));
//        LatLng geo2 = new LatLng(47.216906,38.927864);
//        mMap.addMarker(new MarkerOptions().position(geo2).title("Греческая 105"));
//        LatLng geo3 = new LatLng(47.217518,38.812215);
//        mMap.addMarker(new MarkerOptions().position(geo3).title("Мариупольское Шоссе 54г"));
        LatLng geo4 = new LatLng(47.208829,38.948705);
//        mMap.addMarker(new MarkerOptions().position(geo4).title("Место прибытия Петра Первого на фестиваль\n"));
//        LatLng geo5 = new LatLng(47.213538,38.939457);
//        mMap.addMarker(new MarkerOptions().position(geo5).title("Оркестр"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(geo4));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btnActTwo:
//                // TODO Call second activity
//                break;
            default:
                break;
        }
    }


    private void setUpMark(double c1, double c2, String title,String snippet)
    {
        LatLng latLng = new LatLng(c1, c2);
        mMap.setOnMarkerClickListener(this);

        myMarker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(snippet)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }


    @Override
    public boolean onMarkerClick(final Marker marker) {

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        firstText.setText(marker.getTitle());
        secondText.setText(marker.getSnippet());


        return true;
    }

}
