package com.example.mauku.hobby;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseTwitterUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private Dialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button facebook=(Button) findViewById(R.id.facebook);
        Button twitter=(Button) findViewById(R.id.twitter);

        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        facebook.setTypeface(type);
        twitter.setTypeface(type);



        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
    }

    public void onLoginClickFacebook(View v) {

        progressDialog = ProgressDialog.show(MainActivity.this, "", "Logging in...", true);

        List<String> permissions = Arrays.asList("public_profile", "email");
        // NOTE: for extended permissions, like "user_about_me", your app must be reviewed by the Facebook team
        // (https://developers.facebook.com/docs/facebook-login/permissions/)

        ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException err) {
                progressDialog.dismiss();
                if (user == null) {
                    Log.d("", "Uh oh. The user cancelled the Facebook login.");
                } else if (user.isNew()) {
                    Log.d("", "User signed up and logged in through Facebook!");
                } else {
                    Log.d("", "User logged in through Facebook!");
                }
            }
        });
    }

    public void onLoginClickTwitter(View v) {

        progressDialog = ProgressDialog.show(MainActivity.this, "", "Logging in...", true);
        // NOTE: for extended permissions, like "user_about_me", your app must be reviewed by the Facebook team
        // (https://developers.facebook.com/docs/facebook-login/permissions/)

        ParseTwitterUtils.logIn(this, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException err) {
                if (user == null) {
                    Log.d("MyApp", "Uh oh. The user cancelled the Twitter login.");
                } else if (user.isNew()) {
                    Log.d("MyApp", "User signed up and logged in through Twitter!");
                } else {
                    Log.d("MyApp", "User logged in through Twitter!");
                }
            }
        });
    }
}
