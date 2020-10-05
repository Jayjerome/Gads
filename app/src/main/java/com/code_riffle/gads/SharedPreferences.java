package com.code_riffle.gads;

import android.content.Context;

public class SharedPreferences {
    Context context;
    String value;

    public SharedPreferences(Context context){
        this.context = context;
    }

    public void save(String key, String value){
        android.content.SharedPreferences preferences = context.getSharedPreferences("data", context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String retrieve(String key){
        android.content.SharedPreferences preferences = context.getSharedPreferences("data", context.MODE_PRIVATE);
        value = preferences.getString(key, "");
        return value;
    }
}
