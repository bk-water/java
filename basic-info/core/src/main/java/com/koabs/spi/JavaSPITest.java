package com.koabs.spi;

import java.util.ServiceLoader;

/**
 * @Author koabs
 * @Date 2019/5/14.
 * @Describe
 */
public class JavaSPITest {
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

    public static void main(String[] args) throws Exception {
        new JavaSPITest().sayHello();
    }
}
