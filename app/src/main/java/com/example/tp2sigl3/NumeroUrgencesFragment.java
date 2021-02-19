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

public class NumeroUrgencesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ListModel> listModels;
    DBHelper dbHelper;
    private ArrayList<DataModel> listU;
    ListContactAdapter listUrgAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_numero_urgence, container, false);
        initUI(v);
        return v;
    }


    private void initUI(View v) {

        recyclerView = v.findViewById(R.id.recy_num_urg);
        dbHelper = new DBHelper(this.getContext());
        listU = dbHelper.recupereUrgence();
        listModels = new ArrayList<>();

        for (DataModel model : listU) {
            listModels.add(new ListModel(model.getUrg_nom(), model.getUrg_tel()));
        }
        ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);

        listUrgAdapter = new ListContactAdapter(this.getContext(), listModels);

        recyclerView.setAdapter(listUrgAdapter);



    }

}
