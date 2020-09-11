package com.example.aadpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.aadpractice.Adapter.PagerAdapter;
import com.example.aadpractice.fragment.TopLearner;
import com.example.aadpractice.fragment.TopSkill;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private Button mHomeSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: Starting");

        mHomeSubmit = (Button)findViewById(R.id.homeSubmit);
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mHomeSubmit.setOnClickListener(this);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);

    }
    public void setUpViewPager(ViewPager viewPager){
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TopLearner(),"Learning Leaders");
        adapter.addFragment(new TopSkill(),"Skill IQ Leaders");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homeSubmit:
                startActivity(new Intent(Home.this,Submission.class));
                break;
        }
    }
}
