package com.qunar.tools.flight.tools;

/**
 * Created by jiabin.niu on 2019.01.03 18:52
 */
public class Mian {

    public static void main(String[] args) {

       byte[][] aa = new byte[2][];

       aa[0] = "niu".getBytes();
       aa[1] = "jia".getBytes();

       ss(aa);

    }

    public static void ss(byte[] ... a){
        System.out.println(new String(a[0]));
    }

}
