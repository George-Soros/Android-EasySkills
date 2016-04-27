package com.ttjjttjj.easyskills;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Administrator on 2016/4/22 0022.
 *
 * @author ttjjttjj
 */

    public class EasyApplicaion extends Application {
    private static final String TAG = "EasyApplicaion";

    @Override
    public void onCreate() {
        super.onCreate();

        String processName = getProcessName();
        if(!TextUtils.isEmpty(processName)
                && processName.equals(this.getPackageName())){
            Log.d(TAG, "开始应用的初始化事件...");

        }

    }


    /**
     * 获取应用进程的名称
     * 解决点：oncreate多次执行，主要因为是在manifest中有定义的其他的进程的
     * 这里通过判断是否在当前的进程中保证了只执行一次
     *
     * @return 返回的是当前应用的包名
     */
    public static String getProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }









}
