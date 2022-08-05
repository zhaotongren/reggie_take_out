package com.itheima.reggie.demo;

import com.itheima.reggie.utils.SMSUtils;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo3 {
    public static void main(String[] args) {
/*
        AtomicInteger ac = new AtomicInteger();
        System.out.println(ac);

        AtomicInteger ac2 = new AtomicInteger(10);
        System.out.println(ac2);

        //AtomicInteger方法
        //1.ac2.getAndIncrement()，自增前
        System.out.println("=============");
        System.out.println(ac2.getAndIncrement());   //相当于后++,这是自增前的值
        System.out.println(ac2.get());

        //2.ac3.incrementAndGet()，自增后
        System.out.println("===========");
        AtomicInteger ac3 = new AtomicInteger(10);
        System.out.println(ac3.incrementAndGet());   //自增后的值
        System.out.println(ac3.get());

        //3.ac4.addAndGet(20)，相加后
        System.out.println("-=======");
        AtomicInteger ac4 = new AtomicInteger(10);
        System.out.println(ac4.addAndGet(20));
        System.out.println(ac4.get());

        //4.ac5.getAndAdd(20)，相加前
        System.out.println("-=======");
        AtomicInteger ac5 = new AtomicInteger(10);
        System.out.println(ac5.getAndAdd(20));
        System.out.println(ac5.get());*/

        //4.ac6.getAndSet(20)，设置前
        System.out.println("-=======");
        AtomicInteger ac6 = new AtomicInteger(10);
        int andSet = ac6.getAndSet(20);
        System.out.println(andSet);
//        System.out.println(ac6.getndSet(20));
        int i=ac6.getAndSet(30);
        System.out.println(i);
        System.out.println(ac6.get());

        System.out.println("==========");
        System.out.println(1+1);
        System.out.println("1"+"1");

        SMSUtils.sendMessage("","","","");


    }

}