package com.example.tp2sigl3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DialogMatchRen extends Dialog {

    LinearLayout bkgStade;
    TextView nomStade;
    TextView descriptionStade;
    DBHelper dbHelper;
    private ArrayList<DataModel> listR;
    private ArrayList<ListModel> listModels;
    ListMacthAdapter listMacthAdapter;
    Button btn_loc;

    private RecyclerView recyMatch;

    public DialogMatchRen(@NonNull Context context,int id_etranger, int bkgimg, String title, String descr, Double latitude, Double longitude) {
        super(context, R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
        setContentView(R.layout.activity_dialog_match_ren);

        bkgStade = findViewById(R.id.layout_stade_dialog);
        nomStade = findViewById(R.id.nom_stade);
        descriptionStade = findViewById(R.id.descript_stade);

        btn_loc = findViewById(R.id.btn_lo);

        bkgStade.setBackgroundResource(bkgimg);
        nomStade.setText(title);
        descriptionStade.setText(descr);

        recyMatch = findViewById(R.id.recy_match);
        dbHelper = new DBHelper(this.getContext());
        listR = dbHelper.recupereMacth(id_etranger);

        listModels = new ArrayList<>();

        for (DataModel model : listR) {
            listModels.add(new ListModel(model.getUrlPhotoMatch(), model.getGroupe(), model.getAdversairesMatch(), model.getNiveauMatch(), model.getDateMatch(), model.getHeureMatch()));
        }
        ;

        //LinearLayoutManager layoutManager = new LinearLayoutManager(monDIalog.getContext());
        RecyclerView.LayoutManager rvLayoutMan = new LinearLayoutManager(this.getContext());
        recyMatch.setLayoutManager(rvLayoutMan);
        listMacthAdapter = new ListMacthAdapter(this.getContext(), listModels);
        recyMatch.setAdapter(listMacthAdapter);

        btn_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Localisation.class);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude", latitude);
                intent.putExtra("titreLieu", title);
                context.startActivity(intent);
            }
        });
    }

    public void construire(){
        show();
    }




}