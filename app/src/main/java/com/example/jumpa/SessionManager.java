package com.example.jumpa;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.jumpa.model.AuthData;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String UNIQUE_ID = "unique_id";

    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(AuthData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putInt(ID, user.getId());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(UNIQUE_ID, user.getUniqueId());
        editor.commit();
    }

    public HashMap<String,String> getUserData(){
        HashMap<String,String> user = new HashMap<>();
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(UNIQUE_ID, sharedPreferences.getString(UNIQUE_ID, null));
        return user;
    }

    public Integer getId(){
        Integer getId = sharedPreferences.getInt(ID, 0);
        return getId;
    }

    public void LogoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
