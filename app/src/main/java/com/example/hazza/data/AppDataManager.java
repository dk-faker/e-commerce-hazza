package com.example.hazza.data;

import com.example.hazza.data.local.prefs.PreferencesRepository;
import com.example.hazza.data.remote.ApiRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiRepository apiRepository;
    private final PreferencesRepository preferencesRepository;

    @Inject
    public AppDataManager( ApiRepository apiRepository,PreferencesRepository preferencesRepository) {
        this.apiRepository = apiRepository;
        this.preferencesRepository = preferencesRepository;

    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }


    public PreferencesRepository getPreferencesRepository() {
        return preferencesRepository;
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {
        return Observable.just(true);
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {
        return Observable.just(true);
    }

    @Override
    public void updateApiHeader(String accessToken) {
        apiRepository.getApiHeader().getProtectedApiHeader().setToken(accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
            updateUserInfo(null,DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    @Override
    public void updateUserInfo(String accessToken,LoggedInMode loggedInMode) {
        setToken(accessToken);
        setCurrentUserLoggedInMode(loggedInMode);
       updateApiHeader(accessToken);
    }

    @Override
    public String getToken() {
        return preferencesRepository.getToken();
    }

    @Override
    public void setToken(String token) {
        preferencesRepository.setToken(token);
       apiRepository.getApiHeader().getProtectedApiHeader().setToken(token);

    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return preferencesRepository.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        preferencesRepository.setCurrentUserLoggedInMode(mode);
    }
}
