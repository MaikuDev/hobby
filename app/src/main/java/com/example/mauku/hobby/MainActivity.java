package com.example.mauku.hobby;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button facebook=(Button) findViewById(R.id.facebook);
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        facebook.setTypeface(type);

        facebook.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Log.d("Prueba", "facebook");
            }
        });

        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
    }
}
