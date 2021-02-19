package com.example.tp2sigl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccueilFragment extends Fragment{
    private BottomNavigationView mCallback;

    private  Button btnImgRenc, btnImgeven, btnImgTour, btnImgUrg;
    private Button btn_user;
    private Button btn_locat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View accueil = inflater.inflate(R.layout.fragment_accueil, container, false);
        initUI(accueil);
        return accueil;
    }

    private void initUI(View v){
        //Initialisation

        btnImgRenc = (Button)v.findViewById(R.id.btnimg_renc);
        btnImgeven = (Button)v.findViewById(R.id.btnimg_even);
        btnImgTour = (Button)v.findViewById(R.id.btnimg_tour);
        btnImgUrg = (Button)v.findViewById(R.id.btnimg_urg);
        btn_user = (Button)v.findViewById(R.id.btn_user_accueil);

        btn_locat = (Button)v.findViewById(R.id.btn_loc) ;

        btn_locat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loca = new Intent(getActivity(), Localisation.class);
                startActivity(loca);
            }
        });

        btnImgRenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent renc = new Intent(getActivity(), Rencontre.class);
                startActivity(renc);
            }
        });

        btnImgeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent even = new Intent(getActivity(), Evenement.class);
                startActivity(even);
            }
        });

        btnImgTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tour = new Intent(getActivity(), Tourisme.class);
                startActivity(tour);
            }
        });

        btnImgUrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urg = new Intent(getActivity(), Urgences.class);
                startActivity(urg);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compt = new Intent(getActivity(), Compte.class);
                startActivity(compt);
            }
        });

    }

}
