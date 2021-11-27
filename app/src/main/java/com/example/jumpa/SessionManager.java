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

    private static final String EMAIL = "email";
    private static final String ERROR = "error";

    public SessionManager(Context _context){
        this._context = _context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(_context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(AuthData user){
        editor.putBoolean(ERROR, false);
        editor.putString(EMAIL, user.getEmail());
        editor.commit();
    }

    public HashMap<String,String> getUserData(){
        HashMap<String,String> user = new HashMap<>();
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        return user;
    }

    public void LogoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isError(){
        return sharedPreferences.getBoolean(ERROR, true);
    }
}
