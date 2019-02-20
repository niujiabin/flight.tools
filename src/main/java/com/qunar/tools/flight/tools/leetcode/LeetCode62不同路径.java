package com.qunar.tools.flight.tools.leetcode;

/**
 * @author : jiabin.niu
 **/
public class LeetCode62不同路径 {

    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n);
        int[] store = new int[min];
        int max = Math.max(m, n);
        for (int i = 0; i < min; i++) {
            store[i] = 1;
        }
        for (int i = 1; i < max; i++) {
            for (int j = 0; j < min; j++) {
                if (j == 0) {
                    store[0] = 1;
                } else {
                    store[j] = store[j] + store[j - 1];
                }
            }
        }
        return store[min - 1];
    }
}
