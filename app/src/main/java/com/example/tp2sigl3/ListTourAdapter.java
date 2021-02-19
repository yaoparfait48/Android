package com.example.tp2sigl3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ListTourAdapter extends RecyclerView.Adapter<ListTourAdapter.ListTourVh> implements Filterable {
    private List<ListModel> mList;
    private Context mContext;
    private List<ListModel> mListFilter;

    private ArrayList<DataModel> listR;
    DBHelper dbHelper;
    //private RecyclerView recyclerView;
    View view;


    public ListTourAdapter(Context context, ArrayList<ListModel> list){
        this.mContext = context;
        mList = list;
        this.mListFilter = mList;
    }
    public ListTourAdapter(Context context){
        this.mContext = context;
        this.mListFilter = mList;
    }



    @NonNull
    @Override
    public ListTourVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.activity_item_tourisme, parent, false);

        final ListTourAdapter.ListTourVh listTourVh = new ListTourVh(view);/// final en debut

        listTourVh.btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Localisation.class);
                intent.putExtra("longitude", mList.get(listTourVh.getAdapterPosition()).getLatitude());
                intent.putExtra("latitude", mList.get(listTourVh.getAdapterPosition()).getLongitude());
                intent.putExtra("titreLieu", mList.get(listTourVh.getAdapterPosition()).getTitle());
                mContext.startActivity(intent);
            }
        });

        listTourVh.item_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTour dialogTour = new DialogTour(mContext,
                        listTourVh.getAdapterPosition(),
                        mList.get(listTourVh.getAdapterPosition()).getImage(),
                        mList.get(listTourVh.getAdapterPosition()).getTitle(),
                        mList.get(listTourVh.getAdapterPosition()).getDescription(),
                        mList.get(listTourVh.getAdapterPosition()).getLatitude(),
                        mList.get(listTourVh.getAdapterPosition()).getLongitude());
                dialogTour.construire();
            }
        });

        return listTourVh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListTourVh holder, int position) {

        ListModel listModel = mListFilter.get(position);

        ImageView img = holder.mImage;
        TextView titre = holder.mTitle;
        TextView descrip = holder.mDescription;

        img.setImageResource(listModel.getImage());
        titre.setText(listModel.getTitle());
        descrip.setText(listModel.getDescription().substring(0,60)+"...");

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

    public class ListTourVh extends RecyclerView.ViewHolder {

        private CardView item_tour;
        private Button btnLoc;

        private TextView mTitle;
        private TextView mDescription;
        private ImageView mImage;

        public ListTourVh(@NonNull View itemView) {
            super(itemView);

            /**
             *
             */
            mTitle = (TextView) itemView.findViewById(R.id.nom_site_tour);
            mDescription = (TextView) itemView.findViewById(R.id.descript_site_tour);
            mImage = (ImageView) itemView.findViewById(R.id.img_site_tour);

            /**
             *
             */
            item_tour = (CardView) itemView.findViewById(R.id.item_tour);
            btnLoc = (Button) itemView.findViewById(R.id.btn_position);
        }
    }
}
