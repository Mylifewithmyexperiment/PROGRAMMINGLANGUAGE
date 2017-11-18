package com.wordpress.sjatyourservice.programminglanguage;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
  private final int SPLASH_DISPLAY_LENGTH =2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-5278704802151871~6743811219");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent shashi = new Intent(MainActivity.this, ListViewItemClick1.class);
                MainActivity.this.startActivity(shashi);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}

















