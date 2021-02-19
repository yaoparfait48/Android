package com.example.tp2sigl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogLocation extends AppCompatActivity {

    //
    LinearLayout bkgTour;
    TextView nomTour;
    TextView descriptionTour;
    DBHelper dbHelper;
    private ArrayList<DataModel> listR;
    private ArrayList<ListModel> listModels;
    Button btn_localisation;

    public DialogLocation(int id, int bkgimg, String title, String descr, double longitude, double latitude){
        bkgTour = findViewById(R.id.layout_tour_dialog);
        nomTour = findViewById(R.id.nom_tour);
        descriptionTour = findViewById(R.id.descript_tour);
        btn_localisation = findViewById(R.id.btn_loca);

        bkgTour.setBackgroundResource(bkgimg);
        nomTour.setText(title);
        descriptionTour.setText(descr);

        dbHelper = new DBHelper(this);
        listR = dbHelper.recupereSiteParId(id);

        btn_localisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogLocation.this, Localisation.class);
                intent.putExtra("longitude", latitude);
                intent.putExtra("latitude", longitude);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_tour);
    }
}
