package com.koabs.design.singleton;

/**
 * Created by kevin1 on 6/29/16.
 */
public class Test {

    public static void main(String[] args) {
        // 1.线程安全的单例(饿汉式)
        Singleton.getInstance();

    }
}
