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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class MainActivity extends Activity {
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ParseUser user = new ParseUser();
        user.setUsername("my name");
        user.setPassword("my pass");
        user.setEmail("email@example.com");

    // other fields can be set just like with ParseObject
        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
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
