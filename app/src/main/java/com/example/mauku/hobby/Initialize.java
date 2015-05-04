package com.example.mauku.hobby;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by mauku on 3/05/15.
 */
public class Initialize extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "sd1P6bgbus2MPGXF0TDIDKaX62tZT9RGbqQhiiNQ", "NFCIULEhNch0kei5uhXwefm49HiaMJFSAO25GQgM");
        ParseFacebookUtils.initialize(getResources().getString(R.string.app_id));
    }
}
