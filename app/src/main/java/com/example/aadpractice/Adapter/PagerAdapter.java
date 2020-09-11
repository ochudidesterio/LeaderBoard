package com.example.aadpractice.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.aadpractice.fragment.TopLearner;
import com.example.aadpractice.fragment.TopSkill;

import java.util.ArrayList;
import java.util.List;


public class PagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String>mTitleList = new ArrayList<>();

     public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }
    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mTitleList.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
    return mFragmentList.get(position);

    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
