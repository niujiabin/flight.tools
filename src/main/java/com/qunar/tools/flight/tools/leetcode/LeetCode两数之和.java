package com.qunar.tools.flight.tools.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiabin.niu on 2019.02.11 16:13
 */
public class LeetCode两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
            if (map.get(target - nums[i]) != null && i != map.get(target - nums[i])) {
                return new int[]{Math.min(i, map.get(target - nums[i])), Math.max(i, map.get(target - nums[i]))};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int ss[] = new LeetCode两数之和().twoSum(new int[]{3, 2, 4}, 6);
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
        }
    }
}
