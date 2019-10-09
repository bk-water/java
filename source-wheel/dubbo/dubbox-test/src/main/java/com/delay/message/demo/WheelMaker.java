package com.delay.message.demo;

import com.alibaba.dubbo.common.URL;

/**
 * @Author koabs
 * @Date 2019/5/17.
 * @Describe
 */
public interface WheelMaker {
    Wheel makeWheel(URL url);
}
