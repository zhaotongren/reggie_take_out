package com.itheima.reggie.demo;

public class MyAtomThread implements Runnable {
    private volatile int count = 0;
    private Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                count++;
                System.out.println("已经发送" + count + "个冰激凌");
            }
        }
    }
}
