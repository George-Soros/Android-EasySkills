package com.ttjjttjj.easyskills;

/**
 * Created by Administrator on 2016/4/26 0026.
 *
 * 双重效验锁写法
 *
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){}

    private static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
