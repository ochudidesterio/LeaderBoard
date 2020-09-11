package com.example.aadpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.example.aadpractice.Adapter.PagerAdapter;
import com.example.aadpractice.fragment.TopLearner;
import com.example.aadpractice.fragment.TopSkill;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
   private  Thread mSplashThread;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        mSplashThread = new Thread(){
            @Override
            public void run() {
                try{
                    synchronized (this){
                        wait(5000);
                    }
                }catch (InterruptedException e){
                e.printStackTrace();
                }
                finish();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Home.class);
                startActivity(intent);
            }
        };
        mSplashThread.start();

    }

}
