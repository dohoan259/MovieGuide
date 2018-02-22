package com.example.hoanbk.movieguide.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.annotation.Resource;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoanbk on 22/02/2018.
 */

@Module
public class AppModule {
    private Context mContext;

    AppModule(Application application)
    {
        mContext = application;
    }

    @Provides
    @Singleton
    public Context provideContext()
    {
        return mContext;
    }

    @Provides
    @Singleton
    public Resources provideResources(Context context)
    {
        return context.getResources();
    }
}
