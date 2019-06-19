package com.example.myapplication.file;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.MyApplication;
import com.example.myapplication.model.Spot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharePreferenceUtil {


    public static void setSpots(List<Spot> spotList) {
        if (spotList != null && !spotList.isEmpty()) {
            SharedPreferences sharedPref = MyApplication.getContext().getSharedPreferences(
                    "file2019", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            Gson gson = new Gson();
            String string = gson.toJson(spotList);
            editor.putString("spots", string).commit();

        }

    }

    public static List<Spot> getSpots() {
        SharedPreferences sharedPref = MyApplication.getContext().getSharedPreferences(
                "file2019", Context.MODE_PRIVATE);
        String spots = sharedPref.getString("spots", "");
        if (!spots.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Spot>>() {
            }.getType();
            List<Spot> arrPackageData = gson.fromJson(spots, type);
            return arrPackageData;
        }
        return new ArrayList<>();

    }


}
