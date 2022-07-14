package com.itheima.reggie.demo;

public class Demo2 {


    /*public static void main(String[] args) {
        int a =0;
        for (int i=0; i<10; i++) {

            a+=i;
        }
        for (int i=0; i<10; i++) {
            System.out.println(a);
        }

    }*/


    static int b =10;
    static int a=1;

    public static void main(String[] args) {
        int a =0;
        if(a==0){
            a=100;
        }
        System.out.println(a);  //100
        method1();
    }

   static void method1(){
       System.out.println(b);  //10
       System.out.println(a);   //1
    }

}
