package com.qunar.tools.flight.tools.leetcode;

import java.util.Stack;

/**
 * @author : jiabin.niu
 **/
public class LeetCode柱状图中的最大矩形 {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0 || heights == null) return 0;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                int j = s.pop();
                int k = s.isEmpty() ? -1 : s.peek();
                int curArea = (i - k - 1) * heights[j];
                res = Math.max(res, curArea);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int i = s.pop();
            int k = s.isEmpty() ? -1 : s.peek();
            int curArea = (heights.length - k - 1) * heights[i];
            res = Math.max(res, curArea);
        }
        return res;
    }
}
