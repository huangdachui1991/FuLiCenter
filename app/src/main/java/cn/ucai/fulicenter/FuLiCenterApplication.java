package cn.ucai.fulicenter;

import android.app.Application;

/**
 * Created by huangdachui on 2016/10/18.
 */
public class FuLiCenterApplication extends Application{
    private static FuLiCenterApplication instance;
    public static FuLiCenterApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        instance = this;
    }

    public static FuLiCenterApplication getInstance(){
        if(instance==null){
            instance = new FuLiCenterApplication();
        }
        return instance;
    }
}
