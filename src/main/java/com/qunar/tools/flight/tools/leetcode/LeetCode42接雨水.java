package com.qunar.tools.flight.tools.leetcode;

/**
 * @author jiabin.niu
 * @date 2019.02
 */
public class LeetCode42接雨水 {


    public int trap(int[] height) {

        int length = height.length;
        int leftMax[] = new int[length];
        int rightMax[] = new int[length];

        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            int level = Math.min(leftMax[i], rightMax[i]);
            count += Math.max(0, level - height[i]);
        }

        return count;
    }


    public static void main(String[] args) {


    }
}
