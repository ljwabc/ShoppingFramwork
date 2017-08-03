package com.aqhg.aqhgfxd.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Colin.JiaWei on 2017/7/31.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    /**
     * 贴附的activity
     */
    protected Activity mActivity;

    /**
     * 根view
     */
    protected View mRootView;

    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        mActivity = getActivity();
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mRootView = inflater.inflate(setLayoutResouceId(), container, false);

        findViews();

        initData();

        initView();
        
        initEvent();

        setDataOnView();

        mIsPrepare = true;

        onLazyLoad();

        setListener();

        return mRootView;


    }

    /**
     * 设置根布局资源id
     * @author JW
     * @return
     */
    protected abstract int setLayoutResouceId();


    /**
     * 寻找控件id
     * @author JW
     */
    protected abstract void findViews();


    /**
     * 初始化View
     * @author JW
     */
    abstract protected void initView();

    /**
     * 初始化数据
     * @author JW
     */
    abstract protected void initData();



    protected abstract void initEvent();
    /**
     * 设置监听事件
     * @author JW
     */
    protected void setListener()
    {

    }

    /**
     * 绑定数据
     * @author JW
     */
    abstract protected void setDataOnView();



    /**
     * ------------------------------------------------------------------------------------------------------------------------------------
    * 以下为选用部分
    * */

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);

        this.mIsVisible = isVisibleToUser;

        if (isVisibleToUser)
        {
            onVisibleToUser();
        }
    }

    /**
     * 用户可见时执行的操作
     * @author JW
     */
    protected void onVisibleToUser()
    {
        if (mIsPrepare && mIsVisible)
        {
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     * @author JW
     */
    protected void onLazyLoad()
    {

    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int id)
    {
        if (mRootView == null)
        {
            return null;
        }

        return (T) mRootView.findViewById(id);
    }


}
