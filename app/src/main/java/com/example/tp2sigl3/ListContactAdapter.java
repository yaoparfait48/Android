package com.example.tp2sigl3;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ListContactAdapter extends RecyclerView.Adapter<ListContactAdapter.LisContactVh> implements Filterable {

    private static final int REQUEST_CALL = 1;

    private List<ListModel> mList;
    private Context mContext;
    private List<ListModel> mListFilter;

    private ArrayList<DataModel> listR;
    DBHelper dbHelper;
    //private RecyclerView recyclerView;
    View view;
    private Activity activity;

    public ListContactAdapter(Context context, ArrayList<ListModel> list){
        this.mContext = context;
        mList = list;
        this.mListFilter = mList;

    }
    public ListContactAdapter(Context context){
        this.mContext = context;
        this.mListFilter = mList;

    }

    @NonNull
    @Override
    public ListContactAdapter.LisContactVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.activity_item_urgences, parent, false);
        final ListContactAdapter.LisContactVh listContactVh = new LisContactVh(view);/// final en debut

        listContactVh.btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = new Contacts();
                String tel = mList.get(listContactVh.getAdapterPosition()).getUrg_tel();
                if(tel.trim().length() >0){
                    if(ContextCompat.checkSelfPermission(mContext,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(activity,
                                new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    }else{
                        String dial = "tel:" + tel;
                        mContext.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    }
                }else {
                    Toast.makeText(mContext, "Entrer un nummero de telephone", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return listContactVh;
    }


    @Override
    public void onBindViewHolder(@NonNull ListContactAdapter.LisContactVh holder, int position) {

        ListModel listModel = mListFilter.get(position);

        TextView nomU = holder.nom;
        TextView telU = holder.tel;

        nomU.setText(listModel.getUrg_nom());
        telU.setText(listModel.getUrg_tel());

    }


    @Override
    public int getItemCount() {
        return mListFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();

                if(key.isEmpty()){
                    mListFilter = mList;
                }else {
                    List<ListModel> filterList = new ArrayList<>();
                    for(ListModel row: mList){
                        if(row.getTitle().toLowerCase().contains(key.toLowerCase())){
                            filterList.add(row);
                        }
                    }

                    mListFilter = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mListFilter = (List<ListModel>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class LisContactVh extends RecyclerView.ViewHolder {

        private TextView nom;
        private TextView tel;
        private Button btnApp;

        public LisContactVh(@NonNull View itemView) {
            super(itemView);

            nom = (TextView) itemView.findViewById(R.id.nom_urg);
            tel = (TextView) itemView.findViewById(R.id.tel_urg);
            btnApp = (Button) itemView.findViewById(R.id.btn_appel);
        }
    }

    private void makePhoneCall(String phoneNumber) {
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else {
                Toast.makeText(this, "Permission refuser", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}
