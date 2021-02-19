package com.example.tp2sigl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class UrgencesFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private UrgencesViewPager adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_urgences, container, false);
        initUI(v);
        return v;
    }

    private void initUI(View v){

        tabLayout = (TabLayout) v.findViewById(R.id.tabUrgLayout_id);
        viewPager = (ViewPager) v.findViewById(R.id.viewPagerUrg_id);
        adapter = new UrgencesViewPager(getChildFragmentManager());

        //Ajout des fragments
        adapter.ajouterFragment(new NumeroUrgencesFragment(),"Urgences" );
        adapter.ajouterFragment(new ContactsFragment(), "Contacts");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
