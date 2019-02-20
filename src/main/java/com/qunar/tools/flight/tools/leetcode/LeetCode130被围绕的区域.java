package com.qunar.tools.flight.tools.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiabin.niu
 * @date 2019.02
 */
public class LeetCode130被围绕的区域 {

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 深度优先搜索
     *
     * @param board
     * @param x
     * @param y
     */
    private void dfs(char[][] board, int x, int y) {
        int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        //当前位置坐标
        int[] location = new int[]{x, y};
        queue.offer(location);
        //设置为*
        board[x][y] = '*';

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = point[0] + dir[i][0];
                int newy = point[1] + dir[i][1];
                if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[newx].length) {
                    continue;
                }
                if (board[newx][newy] == 'O') {
                    board[newx][newy] = '*';
                    int[] t = {newx, newy};
                    queue.offer(t);
                }
            }
        }

    }


    public static void main(String[] args) {

        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new LeetCode130被围绕的区域().solve(board);

    }
}
