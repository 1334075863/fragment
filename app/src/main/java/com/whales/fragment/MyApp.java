package com.whales.fragment;

import android.util.Log;

import com.blankj.utilcode.util.Utils;
import com.whales.fragment.base.BaseApplication;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

/**
 * Created on 2019/07/31
 *
 * @author whales
 */
public class MyApp extends BaseApplication {

    private static final String TAG ="MyApp";

    private static MyApp getInstance(){
        return (MyApp)INSTANCE;
    }

    @Override
    protected void onInitInfrastructure() {
        Utils.init(this);
    }

    @Override
    protected void onInitLogModule() {
        if (BuildConfig.LOG_DEBUG){
            Timber.plant(new Timber.DebugTree());
        }else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
                    if (priority == Log.VERBOSE || priority == Log.DEBUG){
                        return;
                    }

                    if (priority == Log.ERROR){
                        Log.e(TAG, message,t);
                    }else {
                        Log.println(priority,tag,message);
                    }
                }
            });
        }
    }

    @Override
    protected void onInitApp() {
        Timber.d("initMyApp");

    }
}
