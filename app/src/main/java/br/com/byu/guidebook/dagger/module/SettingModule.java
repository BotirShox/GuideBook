package br.com.byu.guidebook.dagger.module;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingModule {

    public static final String BASE_URL = "https://guidebook.com/service/v2/upcomingGuides/";

    @Provides
    @Singleton
    @Named(BASE_URL)
    String providesServerUrl(Context context) {
        return "https://guidebook.com/service/v2/";
    }
}
