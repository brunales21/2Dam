package com.example.fragmentweather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SeasonPagerAdapter extends FragmentPagerAdapter {

    public SeasonPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PrimaveraFragment();
            case 1:
                return new VeranoFragment();
            case 2:
                return new OtonoFragment();
            case 3:
                return new InviernoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4; // Número de pestañas
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Primavera";
            case 1:
                return "Verano";
            case 2:
                return "Otoño";
            case 3:
                return "Invierno";
            default:
                return null;
        }
    }
}
