package com.example.tp2sigl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class TourismeFragment extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TourismeViewPager adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tourisme, container, false);

        tabLayout = v.findViewById(R.id.tabTourLayout_idf);
        viewPager = v.findViewById(R.id.viewPagerTour_idf);
        return v;
    }

    private void initUI(View v){

        /*tabLayout = (TabLayout) v.findViewById(R.id.tabTourLayout_id);
        viewPager = (ViewPager) v.findViewById(R.id.viewPagerTour_id);
        adapter = new TourismeViewPager(getChildFragmentManager());

        //Ajout des fragments
        adapter.ajouterFragment(new SiteCulturelFragment(),"Cultures" );
        /*adapter.ajouterFragment(new SiteReligieuxFragment(), "Religiuex");
        adapter.ajouterFragment(new SiteHoteliersFragment(), "Hotels");*/

        /*viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        TourismeViewPager adapter = new TourismeViewPager(getChildFragmentManager());

        //Ajout des fragments
        adapter.ajouterFragment(new SiteCulturelFragment(),"Cultures" );
        adapter.ajouterFragment(new SiteReligieuxFragment(), "Religiuex");
        adapter.ajouterFragment(new SiteHoteliersFragment(), "Hotels");

        viewPager.setAdapter(adapter);
    }
}
