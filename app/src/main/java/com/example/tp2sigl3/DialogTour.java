package com.example.tp2sigl3;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DialogTour extends Dialog {

    private double latitude, longitude;

    //
    LinearLayout bkgTour;
    TextView nomTour;
    TextView descriptionTour;
    DBHelper dbHelper;
    private ArrayList<DataModel> listR;
    private ArrayList<ListModel> listModels;
    Button btn_localisation;

    public DialogTour(@NonNull Context context, int id, int bkgimg, String title, String descr, double longitude, double latitude) {
        super(context, R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
        setContentView(R.layout.activity_dialog_tour);

        bkgTour = findViewById(R.id.layout_tour_dialog);
        nomTour = findViewById(R.id.nom_tour);
        descriptionTour = findViewById(R.id.descript_tour);
        btn_localisation = findViewById(R.id.btn_loca);

        bkgTour.setBackgroundResource(bkgimg);
        nomTour.setText(title);
        descriptionTour.setText(descr);

        dbHelper = new DBHelper(this.getContext());
        listR = dbHelper.recupereSiteParId(id);

        btn_localisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Localisation.class);
                intent.putExtra("longitude", latitude);
                intent.putExtra("latitude", longitude);
                intent.putExtra("titreLieu", title);
                context.startActivity(intent);
            }
        });
    }

    public void construire(){
        show();
    }



}