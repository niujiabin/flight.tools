package com.qunar.tools.flight.tools.leetcode;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author jiabin.niu
 * @date 2019.02
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * <p>
 * <p>
 * 解决思路可以说是一种贪心法  双指针
 */
public class LeetCode三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                ArrayList<Integer> stepRes = new ArrayList<>();
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    stepRes.add(nums[i]);
                    stepRes.add(nums[l]);
                    stepRes.add(nums[r]);
                    if (!list.contains(stepRes)) {
                        list.add(stepRes);
                    }
                }
                if (sum <= 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
