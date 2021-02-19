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

public class ListEventAdapter extends RecyclerView.Adapter<ListEventAdapter.ListEventVh> implements  Filterable{
    private List<ListModel> mList;
    private Context mContext;
    private List<ListModel> mListFilter;
    Dialog monDIalog;

    private ArrayList<DataModel> listR;
    DBHelper dbHelper;
    //private RecyclerView recyclerView;
    private ArrayList<ListModel> listModels;
    ListEventAdapter listEventAdapter;
    View view;



    public ListEventAdapter(Context context, ArrayList<ListModel> list){
        this.mContext = context;
        mList = list;
        this.mListFilter = mList;

    }
    public ListEventAdapter(Context context){
        this.mContext = context;
        this.mListFilter = mList;

    }

    @NonNull
    @Override
    public ListEventAdapter.ListEventVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.activity_item_event, parent, false);

        final ListEventAdapter.ListEventVh listEventVh = new ListEventAdapter.ListEventVh(view);/// final en debut

        listEventVh.btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Localisation.class);
                intent.putExtra("longitude", mList.get(listEventVh.getAdapterPosition()).getLatitude());
                intent.putExtra("latitude", mList.get(listEventVh.getAdapterPosition()).getLongitude());
                intent.putExtra("titreLieu", mList.get(listEventVh.getAdapterPosition()).getTitle());
                mContext.startActivity(intent);
            }
        });

        listEventVh.item_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTour dialogTour = new DialogTour(mContext,
                        listEventVh.getAdapterPosition(),
                        mList.get(listEventVh.getAdapterPosition()).getImage(),
                        mList.get(listEventVh.getAdapterPosition()).getTitle(),
                        mList.get(listEventVh.getAdapterPosition()).getDescription(),
                        mList.get(listEventVh.getAdapterPosition()).getLatitude(),
                        mList.get(listEventVh.getAdapterPosition()).getLongitude());
                dialogTour.construire();
            }
        });

        return listEventVh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListEventAdapter.ListEventVh holder, int position) {

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

    public class ListEventVh extends RecyclerView.ViewHolder {
        private CardView item_event;

        private TextView mTitle;
        private TextView mDescription;
        private ImageView mImage;
        Button btnLoc;

        public ListEventVh(@NonNull View itemView) {
            super(itemView);

            /**
             *
             */
            mTitle = (TextView) itemView.findViewById(R.id.titre_recy_even);
            mDescription = (TextView) itemView.findViewById(R.id.descript_recy_even);
            mImage = (ImageView) itemView.findViewById(R.id.img_event);

            /**
             *
             */
            item_event = (CardView) itemView.findViewById(R.id.item_even);
            btnLoc = (Button) itemView.findViewById(R.id.btn_even_itin);

        }
    }
}

