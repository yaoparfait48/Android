package com.example.tp2sigl3;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<ListModel> listModels;
    DBHelper dbHelper;
    private ArrayList<DataModel> listT;
    EditText searchInput;
    ListContactAdapter listContactAdapter;
    View v;
    Button btnAppel;
    private static final int REQUEST_CALL = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contacts, container, false);
        initUI(v);
        return v;
    }


    private void initUI(View v) {
        //access au contenues du mobile

        /*if(cursor == null){
            Log.d("RecupérationContact", "Eurreu du cursseur");
        }
        else{*/



        searchInput = v.findViewById(R.id.edit_text_search_contact);//Bar de recherche

        recyclerView = v.findViewById(R.id.recy_contact);
        dbHelper = new DBHelper(this.getContext());
        listT = recupererContacts();
        listModels = new ArrayList<>();

        for (DataModel model : listT) {
            listModels.add(new ListModel(model.getUrg_nom(), model.getUrg_tel()));
        }
        ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);

        listContactAdapter = new ListContactAdapter(this.getContext(), listModels);

        recyclerView.setAdapter(listContactAdapter);


        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                listContactAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    public ArrayList<DataModel> recupererContacts(){
        ArrayList<DataModel> listContactRetoune = new ArrayList<>();
        ContentResolver contentResolver = this.getActivity().getContentResolver();

        //Recuperation des contactes dans le cursseur
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                        ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String nomC = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                String telC = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                DataModel newdataModel = new DataModel(nomC, telC);
                listContactRetoune.add(newdataModel);
            }while(cursor.moveToNext());
        }
        else{

            Log.d("RecupContact", "Recution impossible");
        }


        cursor.close();
        return listContactRetoune;
    }

}
