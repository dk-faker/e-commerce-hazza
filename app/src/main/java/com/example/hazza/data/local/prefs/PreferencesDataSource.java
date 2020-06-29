package com.example.hazza.data.local.prefs;

import com.example.hazza.data.DataManager;

public interface PreferencesDataSource {

    String getToken();
    void setToken(String token);
    int getCurrentUserLoggedInMode();
    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

}
