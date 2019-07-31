package com.whales.fragment.base;

import android.app.Application;

/**
 * Created on 2019/07/31
 *
 * @author whales
 */
public abstract class BaseApplication extends Application {

    protected static Application INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        onInitInfrastructure();

        onInitLogModule();

        onInitApp();
    }

    /**
     * 初始化基础设施.
     */
    protected abstract void onInitInfrastructure();

    /**
     * 初始化日志模块.
     */
    protected abstract void onInitLogModule();

    /**
     * 请在这里初始化APP.
     */
    protected abstract void onInitApp();
}
