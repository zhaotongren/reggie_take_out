package com.itheima.reggie.demo;

import com.itheima.reggie.common.R;

public class Demo2 {
    public static void main(String[] args) {

        int a = 10;
//        a += 1

     /*   System.out.println(a= a+1);  //
        //a += 1;
        System.out.println(a);*/

        add(a);
        System.out.println(a);


        System.out.println("===========");
        R<Integer> e = new R<Integer>();
        R<Integer> ss = e.add("ss", "123");
        System.out.println(ss);




    }

    public static void add(int i){
        i+=1;
        System.out.println(i);
    }

}
