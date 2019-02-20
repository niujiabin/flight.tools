package com.qunar.tools.flight.tools.leetcode;

/**
 * Created by jiabin.niu on 2019.02.09 1:06
 */
public class LeetCode9回文数 {

    public static void main(String[] args) {
        boolean is = new LeetCode9回文数().isPalindrome(121);
        System.out.println(is);
    }
    public boolean isPalindrome(int x) {

        // 12321
        //负数不是回文数
        if (x < 0) {
            return false;
        }
        int result[] = getIntegerArray(x);
        for (int index = 0; index < result.length / 2; index++) {
            if (result[index] != result[result.length - index - 1]) {
                return false;
            }
        }
        return true;
    }

    private int[] getIntegerArray(int x) {

        int count = 0;
        int xx = x;
        while (xx != 0) {
            xx = xx / 10;
            count++;
        }
        int result[] = new int[count];
        xx = x;
        count = 0;
        while (xx != 0) {
            result[count] = xx % 10;
            xx = xx / 10;
            count++;
        }

        return result;
    }

}
