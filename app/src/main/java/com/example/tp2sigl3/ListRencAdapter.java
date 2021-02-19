package com.example.tp2sigl3;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ListRencAdapter extends RecyclerView.Adapter<ListRencAdapter.ListModelVh> implements Filterable {

    private List<ListModel> mList;
    private Context mContext;
    private List<ListModel> mListFilter;
    Dialog monDIalog;

    private ArrayList<DataModel> listR;
    DBHelper dbHelper;
    //private RecyclerView recyclerView;
    private ArrayList<ListModel> listModels;
    ListRencAdapter listRencAdapter;
    View view;


    public ListRencAdapter(Context context, ArrayList<ListModel> list){
        this.mContext = context;
        mList = list;
        this.mListFilter = mList;

    }
    public ListRencAdapter(Context context){
        this.mContext = context;
        this.mListFilter = mList;

    }

    @NonNull
    @Override
    public ListModelVh onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.activity_item_rencontre, parent, false);

        final ListModelVh listModelVh = new ListModelVh(view);/// final en debut

        /**
         * Click sur un item du recyclerview
         */
        listModelVh.item_renc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monDIalog = new Dialog(mContext);

                DialogMatchRen dialogMatchRen = new DialogMatchRen(mContext,
                        listModelVh.getAdapterPosition()+1,
                        mList.get(listModelVh.getAdapterPosition()).getImage(),
                        mList.get(listModelVh.getAdapterPosition()).getTitle(),
                        mList.get(listModelVh.getAdapterPosition()).getDescription(),
                        mList.get(listModelVh.getAdapterPosition()).getLatitude(),
                        mList.get(listModelVh.getAdapterPosition()).getLongitude());
                dialogMatchRen.construire();
            }
        });

        return listModelVh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListModelVh holder, int position) {

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

    public class ListModelVh extends RecyclerView.ViewHolder {

        private CardView item_renc;

        private TextView mTitle;
        private TextView mDescription;
        private ImageView mImage;

        public ListModelVh(@NonNull View itemView) {
            super(itemView);

            /**
             *
             */
            mTitle = (TextView) itemView.findViewById(R.id.titre_recy_renc);
            mDescription = (TextView) itemView.findViewById(R.id.descript_recy_renc);
            mImage = (ImageView) itemView.findViewById(R.id.img_stade_renc);

            /**
             *
             */
            item_renc = (CardView) itemView.findViewById(R.id.item_renc);
        }
    }
}
