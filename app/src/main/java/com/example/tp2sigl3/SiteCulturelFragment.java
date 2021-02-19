package com.example.tp2sigl3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SiteCulturelFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<ListModel> listModels;
    DBHelper dbHelper;
    private ArrayList<DataModel> listT;
    EditText searchInput;
    ListTourAdapter listTourAdapter;
    View v;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_site_culturel, container, false);
        initUI(v);
        return v;
    }


    private void initUI(View v) {

        searchInput = v.findViewById(R.id.edit_text_search_culture);//Bar de recherche

        recyclerView = v.findViewById(R.id.recy_site_cult);
        dbHelper = new DBHelper(this.getContext());
        listT = dbHelper.recupereSite("Culture");
        listModels = new ArrayList<>();

        for (DataModel model : listT) {
            listModels.add(new ListModel(model.getNomSite(), model.getDescription(), model.getUrlImgSite(),model.getLatitudSite(),model.getLongitudSite()));
        }
        ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);

        listTourAdapter = new ListTourAdapter(this.getContext(), listModels);

        recyclerView.setAdapter(listTourAdapter);


        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                listTourAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    }
