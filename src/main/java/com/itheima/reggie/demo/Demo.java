package com.itheima.reggie.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
       /* get1();
        get2();*/

        //System.out.println();
/*        System.out.println(new Long(1));
        System.out.println(1L);*/

/*        File file = new File("a1.txt");
        System.out.println(file);*/

        //截取字符串
        /*String a1="abhutdaihf.jpg";
        System.out.println(a1.substring(a1.lastIndexOf(".")));
        System.out.println(a1.substring(a1.indexOf(".")));*/

        //字符流
        //字符输出流，字符的写数据
        byte[] bytes = "中国".getBytes();
        byte[] bytes2 = "abc".getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));

        //字符的读数据
        byte[] read={-28, -72, -83, -27, -101, -67};
        System.out.println(new String(read));

        //字符流
        try {
            //
           // FileOutputStream fos = new FileOutputStream("E:\\myByteStream\\fos.txt");

            File file = new File("E:\\myByteStream");
            if (!file.exists()) {
               file.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("E:\\myByteStream\\fos.txt");



        } catch (Exception e) {
            e.printStackTrace();
        }

        //Lambda


    }


}
