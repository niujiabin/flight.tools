package com.qunar.tools.flight.tools.leetcode;

/**
 * @author jiabin.niu
 * @date 2019.02
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 使用双指针法类似一种贪心算法
 */
public class LeetCode11盛最多水的容器 {

    /**
     * 解题思路 如果两个圆柱之间可以装水 ，那么如果存在更高的圆柱，也一定能连带去盛更多的水，所以最终的
     * 任务是把所有最高的圆柱找到
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int lp = 0, rp = height.length - 1;
        int result = 0;
        while (lp != rp && lp < height.length && rp >= 0) {
            if (Math.min(height[lp], height[rp]) * (rp - lp) > result) {
                result = Math.min(height[lp], height[rp]) * (rp - lp);
            }
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int re = new LeetCode11盛最多水的容器().maxArea(new int[]{1, 2, 4, 3});
        System.out.println(re);
    }

}
