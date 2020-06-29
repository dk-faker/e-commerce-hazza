package com.example.hazza.data;

import com.example.hazza.data.local.prefs.PreferencesDataSource;
import io.reactivex.Observable;

public interface DataManager extends PreferencesDataSource {
    Observable<Boolean> seedDatabaseOptions();

    Observable<Boolean> seedDatabaseQuestions();

    void updateApiHeader(String accessToken);
    void setUserAsLoggedOut();
    void updateUserInfo(
            String accessToken,
            LoggedInMode loggedInMode);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
