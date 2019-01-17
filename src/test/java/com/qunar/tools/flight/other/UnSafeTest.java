package com.qunar.tools.flight.other;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.FutureTask;

/**
 * Created by jiabin.niu on 2018.12.06 15:59
 */
public class UnSafeTest {

   /* private int age;

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
    }*/

    public static void main(String[] args) {

        HashSet<String> s1 = Sets.newHashSet();
        s1.add("a");
        s1.add("b");

        HashSet<String> s2 = Sets.newHashSet();
        s2.add("a");
        s2.add("b");
        s2.add("c");
        System.out.println(strictMatch(s1,s2));
    }

    public static boolean strictMatch(Set<String> data,Set<String> candidates) {

        for (String item : data) {
            if (!candidates.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
