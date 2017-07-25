package com.koabs.util.thread;

/**
 * Author: koabs
 * 7/3/17.
 * 术语
 * TPS(系统吞吐量) QPS(并发用户数/平均响应时间 每秒查询率)
 * Concurrent 并发  Parallel 并行
 *
 * 关键字 @synchronized
 *
 * monitor  概念
 *
 * http://www.cnblogs.com/wxd0108/p/5479442.html
 */
public class Demo {

    void  threadState() {
        /*
        Thread.State.NEW;
        Thread.State.RUNNABLE;
        Thread.State.BLOCKED;
        Thread.State.WAITING;
        Thread.State.TIMED_WAITING;
        Thread.State.TERMINATED;
        */
    }


    class Thread1 implements Runnable {
        Object lock;
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(lock.toString());
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public synchronized void run() {

        }
    }
}
