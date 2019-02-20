package com.qunar.tools.flight.tools.leetcode;

/**
 * Created by jiabin.niu on 2019.02.10 22:05
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class LeetCode岛屿的个数 {


    static int dx[] = new int[]{-1, 1, 0, 0};
    static int dy[] = new int[]{0, 0, -1, 1};

    /**
     * 解法一 DFS 深度优先遍历
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int height = grid.length;
        int width = grid[0].length;

        int[][] mark = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mark[i][j] == 0 && grid[i][j] == '1') {
                    dfs(mark, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] mark, char[][] grid, int x, int y) {

        mark[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nextx = dx[i] + x;
            int nexty = dy[i] + y;
            if (nextx < 0 || nextx >= mark.length || nexty < 0 || nexty >= mark[nextx].length) {
                continue;
            }
            if (mark[nextx][nexty] == 0 && grid[nextx][nexty] == '1') {
                dfs(mark, grid, nextx, nexty);
            }
        }
    }

}
