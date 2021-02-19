package com.example.tp2sigl3;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class UrgencesViewPager extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitre = new ArrayList<>();

    public UrgencesViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitre.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitre.get(position);
    }

    /**
     *
     */

    public void ajouterFragment(Fragment fragment, String titre){
        lstFragment.add(fragment);
        lstTitre.add(titre);
    }
}
