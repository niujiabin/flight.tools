package com.qunar.tools.flight.tools.leetcode;

import java.util.*;

/**
 * @author jiabin.niu
 * @date 2019.02
 */
public class LeetCode课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.get(prerequisites[i][1]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            } else {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer c = queue.poll();
            List<Integer> clist = map.get(c);
            if (clist == null) {
                continue;
            } else {
                for (int i = 0; i < clist.size(); i++) {
                    degree[clist.get(i)]--;
                    if (degree[clist.get(i)] == 0) {
                        queue.offer(clist.get(i));
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean re = new LeetCode课程表().canFinish(2, new int[][]{{0, 1}});
        System.out.println(re);
    }

}
