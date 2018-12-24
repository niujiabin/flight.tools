package com.qunar.tools.flight.other;

/**
 * Created by jiabin.niu on 2018.12.06 16:37
 */
public class TimeCostTest {

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long c = System.nanoTime();
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);

        //---
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long cd = System.currentTimeMillis();
        }
        long b1 = System.currentTimeMillis();
        System.out.println(b1 - a1);

    }
}
