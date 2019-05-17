package com.koabs.spi;

/**
 * @Author koabs
 * @Date 2019/5/14.
 * @Describe
 */
public class Bumblebee implements Robot{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
