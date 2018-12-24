package com.qunar.tools.flight.other;

import java.util.concurrent.FutureTask;

/**
 * Created by jiabin.niu on 2018.12.06 15:59
 */
public class UnSafeTest {

    private int age;

    private static final sun.misc.Unsafe UNSAFE;
    private static final long stateOffset;

    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = UnSafeTest.class;


            stateOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("age"));

            System.out.println(stateOffset);

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {

    }
}
