package com.ttjjttjj.easyskills;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/4/26 0026.
 */
public class EditTextUtils {

    /**
     * 自动开启软键盘
     * @param view edittext
     * @param context
     */
    public static void getSoftKey(final View view,final Context context){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                view.requestFocus();
                InputMethodManager inputManager =
                        (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(view, 0);
            }
        }, 500);
    }








}
