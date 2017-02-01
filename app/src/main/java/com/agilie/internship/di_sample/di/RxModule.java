package com.agilie.internship.di_sample.di;

import com.agilie.internship.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serg on 12/11/16.
 */

@Module
public class RxModule {

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.ANDROID_NETWORK;
    }
}
