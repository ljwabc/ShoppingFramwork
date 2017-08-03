package com.aqhg.aqhgfxd.global;

import android.content.Context;
import android.os.Handler;

/**
 * Created by Colin.JiaWei on 2017/8/1.
 */
public class LoadingAnimUtil {

    /**
     * 对网络请求动画加载类的封装
     * */

    public static void loadingStatus(String str,Context context){
        switch (str.toString()){
            case "in":
                loadingIn(context);
                break;

            case "success":
                loadingLaterSuccessful(context);
                break;

            case "error":
                loadingLaterError(context);
                break;
        }
    }

    public static void loadingIn(Context context){
        LoadingAnim.createAnimationDailog(context,"拼命加载中").show();
    }

    public static void loadingLaterSuccessful(Context context){
        if (LoadingAnim.dialog != null){
            LoadingAnim.dialog.dismiss();
        }
        LoadingAnim.createAnimationDailog(context,"加载成功!").show();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                LoadingAnim.dialog.dismiss();
            }
        }, 1500);
    }

    public static void loadingLaterError(Context context){
        if (LoadingAnim.dialog != null){
            LoadingAnim.dialog.dismiss();
        }
        LoadingAnim.createAnimationDailog(context,"网络出现问题..请稍后再试").show();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                LoadingAnim.dialog.dismiss();
            }
        }, 1500);
    }
}
