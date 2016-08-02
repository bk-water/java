package com.koabs.design.singleton;

/**
 * Created by kevin1 on 6/29/16.
 * 线程安全的单例类
 * 饿汉式
 */
public class Singleton {
    private final static Singleton instance = new Singleton();

    private Singleton(){
        // TODO: 防止外部实例化
    }

    public static Singleton getInstance(){
        return instance;
    }
}
