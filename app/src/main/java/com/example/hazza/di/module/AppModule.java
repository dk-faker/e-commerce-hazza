package com.example.hazza.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.example.hazza.BuildConfig;
import com.example.hazza.data.local.prefs.PreferencesDataSource;
import com.example.hazza.data.local.prefs.PreferencesRepository;
import com.example.hazza.data.remote.network.ApiHeader;
import com.example.hazza.data.remote.network.ApiService;
import com.example.hazza.di.ApiInfo;
import com.example.hazza.di.DatabaseInfo;
import com.example.hazza.di.PreferenceInfo;
import com.example.hazza.utils.AppConstants;
import com.example.hazza.utils.rx.AppSchedulerProvider;
import com.example.hazza.utils.rx.SchedulerProvider;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.hazza.utils.AppConstants.TOKEN;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return TOKEN;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {

            return new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@PreferenceInfo String prefName, Context context) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    PreferencesDataSource providePreferencesHelper(PreferencesRepository appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(PreferencesDataSource preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                preferencesHelper.getToken());
    }

}
