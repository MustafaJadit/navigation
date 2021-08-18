package com.example.myapplication;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Application application;

    public static Context getContext(){
        return getApplication().getApplicationContext();
    }


    public static Application getApplication(){
        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //test from f2
        application=this;
    }

    //test




    //test from f1



    //test from f1 part2
}
