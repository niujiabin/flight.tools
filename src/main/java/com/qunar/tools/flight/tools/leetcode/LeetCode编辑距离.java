package com.qunar.tools.flight.tools.leetcode;

/**
 * @author : jiabin.niu
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 **/
public class LeetCode编辑距离 {

    public int minDistance(String word1, String word2) {

        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int dp[][] = new int[char1.length + 1][char2.length + 1];

        for (int i = 0; i <= char1.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= char2.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {

                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[char1.length][char2.length];
    }

    public static void main(String[] args) {


    }
}
