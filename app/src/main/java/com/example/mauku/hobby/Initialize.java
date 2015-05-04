package com.example.mauku.hobby;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseTwitterUtils;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by mauku on 3/05/15.
 */
public class Initialize extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "xUwnDBwoh3ULFgrW1B9AOjdJn";
    private static final String TWITTER_SECRET = "TdRm8RYcIPlDoMJIqmbILmavlTsphph5l8C0f0SC3U3PLXpL8S";

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        Parse.initialize(this, "sd1P6bgbus2MPGXF0TDIDKaX62tZT9RGbqQhiiNQ", "NFCIULEhNch0kei5uhXwefm49HiaMJFSAO25GQgM");
        ParseFacebookUtils.initialize(getResources().getString(R.string.app_id));
        ParseTwitterUtils.initialize(TWITTER_KEY, TWITTER_SECRET);
    }
}
