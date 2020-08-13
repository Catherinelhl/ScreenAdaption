package com.cathy.screenadaptiondemo.utils;

/**
 * +--------------------------------------+
 * + @author Catherine Liu
 * +--------------------------------------+
 * + 2020/8/5 19:34
 * +--------------------------------------+
 * + Des:
 * +--------------------------------------+
 */


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * 通过固定屏幕宽度为375，进行设计
 * @author Catherine Liu
 */
public class DensityUtil {
    private static String TAG = DensityUtil.class.getSimpleName();
    private static final float WIDTH = 375;
    private static float appDensity;
    private static float appScaleDensity;

    public static void setDensity(final Application application, Activity activity) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0) {
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;
            //添加字体大小变化监听的回调
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {
                    LogUtilKt.d(TAG,"onLowMemory");
                }
            });
        }
        float targetDensity = displayMetrics.widthPixels / WIDTH;
        float targetScaleDensity = targetDensity * (appScaleDensity / appDensity);
        int targetDensityDpi = (int) (targetDensity * 160);
        //进行替换
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        dm.density = targetDensity;
        dm.scaledDensity = targetScaleDensity;
        dm.densityDpi = targetDensityDpi;
    }
}
