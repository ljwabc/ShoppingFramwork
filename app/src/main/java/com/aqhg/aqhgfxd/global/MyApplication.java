package com.aqhg.aqhgfxd.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Colin.JiaWei on 2017/7/31.
 */
public class MyApplication extends Application{
    public static Context context;
    public static Handler mainHandler;

    /**
     * app的入口函数
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //1.初始化Context,Android三大Context:Application,Activity,Service
        context = this;
        //2.初始化mainHandler
        mainHandler = new Handler();
//		new Thread(){
//			public void run() {
//				//在子线程创建handler
//				mainHandler = new Handler();
//				Looper.prepare();//创建轮询器
//				Looper.loop();//开启轮询器
//				mainHandler.sendEmptyMessage(0);
//			};
//		}.start();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
