package com.qunar.tools.flight.tools.leetcode;

/**
 * @author : jiabin.niu
 **/
public class LeetCode最小路径和1 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        int[][] s = new int[row][col];
        s[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            s[0][i] = s[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            s[i][0] = s[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                s[i][j] = Math.min(s[i - 1][j], s[i][j - 1]) + grid[i][j];
            }
        }

        return s[row - 1][col - 1];
    }
}
