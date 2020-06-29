package com.example.hazza.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.hazza.data.DataManager;
import com.example.hazza.di.PreferenceInfo;
import javax.inject.Inject;

public class PreferencesRepository implements PreferencesDataSource {

    private final SharedPreferences mPrefs;
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";


    @Inject
    public PreferencesRepository(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN,null);
    }

    @Override
    public void setToken(String token) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN,token).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }
}
