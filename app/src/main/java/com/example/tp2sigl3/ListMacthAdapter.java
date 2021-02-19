package com.example.tp2sigl3;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ListMacthAdapter extends RecyclerView.Adapter<ListMacthAdapter.ListMatchvh> {

    private List<ListModel> mList;
    private Context mContext;
    View view;

    public ListMacthAdapter(Context mContext, List<ListModel> mList) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListMacthAdapter.ListMatchvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.activity_item_match, parent, false);

        final ListMatchvh listMatchvh = new ListMatchvh(view);/// final en debut

        return listMatchvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListMacthAdapter.ListMatchvh holder, int position) {

        ListModel listModel = mList.get(position);

        ImageView imgAd = holder.mImgAdvers;
        TextView groupe = holder.mGroupe;
        TextView monAdv = holder.mNomAdvers;
        TextView niveau = holder.mNiveau;
        TextView dateM = holder.mDateMatch;
        TextView heurM = holder.mHeurMatch;

        imgAd.setImageResource(listModel.getImageAdvers());
        groupe.setText(listModel.getGroupe());
        monAdv.setText(listModel.getNomAdvers());
        niveau.setText(listModel.getNiveau());
        dateM.setText(listModel.getDatMatch());
        heurM.setText(listModel.getHeureMatch());

    }

    @Override
    public int getItemCount() {
        return  mList.size();
    }

    public class ListMatchvh extends RecyclerView.ViewHolder{
        CardView item_match;

        private ImageView mImgAdvers;
        private TextView mGroupe;
        private TextView mNomAdvers;
        private TextView mNiveau;
        private TextView mDateMatch;
        private TextView mHeurMatch;

        public ListMatchvh(@NonNull View itemView) {
            super(itemView);

            mImgAdvers = (ImageView) itemView.findViewById(R.id.drapeauAdv);
            mGroupe = (TextView) itemView.findViewById(R.id.groupe);
            mNomAdvers = (TextView) itemView.findViewById(R.id.nom_equipe);
            mNiveau = (TextView) itemView.findViewById(R.id.niveau_competition);
            mDateMatch = (TextView) itemView.findViewById(R.id.date_renc);
            mHeurMatch = (TextView) itemView.findViewById(R.id.heure_renc);

            item_match = (CardView) itemView.findViewById(R.id.item_match);
        }
    }
}
