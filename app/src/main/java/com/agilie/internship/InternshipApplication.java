package com.agilie.internship;

import android.app.Application;
import android.content.Context;

import com.agilie.internship.di_sample.di.AppComponent;

public class InternshipApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);


//        appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .rxModule(new RxModule())
//                .retrofitModule(new RetrofitModule("https://superurl.here"))
//                .build();
    }

    public static InternshipApplication get(Context context) {
        return (InternshipApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
