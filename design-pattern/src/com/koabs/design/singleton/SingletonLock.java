package com.koabs.design.singleton;

/**
 * Created by kevin1 on 6/29/16.
 * 单例模式 加锁
 * 会导致每次获取实例时都需要加锁检测
 */
public class SingletonLock {
    private static SingletonLock instance = null;

    private SingletonLock() {
        //私有构造函数防止外部初始化
    }

    public static synchronized SingletonLock getInstance(){
        if (instance == null) {
            instance = new SingletonLock();
        }

        return instance;
    }
}
