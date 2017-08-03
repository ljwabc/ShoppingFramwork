package com.aqhg.aqhgfxd.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.aqhg.aqhgfxd.R;
import com.aqhg.aqhgfxd.fragment.DiscoverFragment;
import com.aqhg.aqhgfxd.fragment.SelectionFragment;
import com.aqhg.aqhgfxd.fragment.StoreFragment;
import com.aqhg.aqhgfxd.fragment.UserFragment;
import com.aqhg.aqhgfxd.global.LoadingAnimUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends BaseActivity {
    private TextView tv_select;
    private TextView tv_faxian;
    private TextView tv_dianpu;
    private TextView tv_my;
    private FragmentTransaction fTransaction;
    private FragmentManager fManager;
    private SelectionFragment selectionFragment;
    private DiscoverFragment discoverFragment;
    private StoreFragment storeFragment;
    private UserFragment userFragment;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        让状态栏透明
////        View decorview = getWindow().getDecorView();
////        if(Build.VERSION.SDK_INT>=21){//5.0以上的系统支持
////            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;//表示让应用主题内容占据系统状态栏的空间
////            decorview.setSystemUiVisibility(option);
////            getWindow().setStatusBarColor(Color.parseColor("#00ffffff"));//设置状态栏颜色为透明
////        }
//
//
//    }


    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        fManager = getSupportFragmentManager();
        tv_select = (TextView) findViewById(R.id.tv_select);
        tv_dianpu = (TextView) findViewById(R.id.tv_dianpu);
        tv_faxian = (TextView) findViewById(R.id.tv_faxian);
        tv_my = (TextView) findViewById(R.id.tv_my);


    }





    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        LoadingAnimUtil.loadingStatus("in",this);   //网络请求加载中 加载动画为in指令
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LoadingAnimUtil.loadingStatus("error",MainActivity.this);  //网络请求加载错误  加载动画为"error"指令
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LoadingAnimUtil.loadingStatus("success",MainActivity.this);//网络请求加载完毕 加载成功  加载动画为"success"指令
                    }

                });

    }

    @Override
    protected void initEvent() {
        tv_select.setOnClickListener(this);
        tv_dianpu.setOnClickListener(this);
        tv_faxian.setOnClickListener(this);
        tv_my.setOnClickListener(this);

        tv_select.performClick();//模拟一次点击  进去直接显示selectfragment
    }

    @Override
    protected void setDataOnView() {

    }


    @Override
    public void onClick(View v) {
        fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tv_select:
                if (selectionFragment==null){
                    selectionFragment=new SelectionFragment();
                    fTransaction.add(R.id.fl,selectionFragment);
                }else {
                    fTransaction.show(selectionFragment);
                }
                break;
            case R.id.tv_faxian:
                if (discoverFragment==null){
                    discoverFragment=new DiscoverFragment();
                    fTransaction.add(R.id.fl,discoverFragment);
                }else {
                    fTransaction.show(discoverFragment);
                }
                break;
            case R.id.tv_dianpu:
                if (storeFragment==null){
                    storeFragment=new StoreFragment();
                    fTransaction.add(R.id.fl,storeFragment);
                }else {
                    fTransaction.show(storeFragment);
                }
                break;
            case R.id.tv_my:
                if (userFragment==null){
                    userFragment=new UserFragment();
                    fTransaction.add(R.id.fl,userFragment);
                }else {
                    fTransaction.show(userFragment);
                }
                break;
        }
        fTransaction.commit();
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        //隐藏所有Fragment
        if(discoverFragment != null)fragmentTransaction.hide(discoverFragment);
        if(userFragment != null)fragmentTransaction.hide(userFragment);
        if(storeFragment != null)fragmentTransaction.hide(storeFragment);
        if(selectionFragment != null)fragmentTransaction.hide(selectionFragment);
    }
}
