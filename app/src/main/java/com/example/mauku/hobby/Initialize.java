package com.example.mauku.hobby;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;

/**
 * Created by mauku on 3/05/15.
 */
public class Initialize extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Context contexto = this;
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "zHeAvzqmxitOsmaDsX5KNdD8xztxp5tf8Q8ZjToe", "BIBxsTYvIX3MY7ZiF4DPSzZbkIKS2P6NmfOMKIWH");
    }
}
