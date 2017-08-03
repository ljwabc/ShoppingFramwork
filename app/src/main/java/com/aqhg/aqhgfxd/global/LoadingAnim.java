package com.aqhg.aqhgfxd.global;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.aqhg.aqhgfxd.R;

/**
 * Created by Colin.JiaWei on 2017/8/1.
 */
public class LoadingAnim {

    public static Dialog dialog;
    /**
     * 加载中的动画
     * @param context 上下文
     * @param tips 加载动画下面的提示信息
     * @return 将对话框对象直接返回
     */
    public static Dialog createAnimationDailog(final Context context, String tips) {
        dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(R.layout.alert_dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        ImageView animationView = (ImageView) dialog.findViewById(R.id.loadingIv);
        TextView textView = (TextView) dialog.findViewById(R.id.loadingTv);
        textView.setText(tips);
        animationView.setBackgroundResource(R.drawable.loading_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) animationView.getBackground();
        animationDrawable.start();
        return dialog;
    }
}
