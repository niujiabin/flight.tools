package com.qunar.tools.flight.tools.leetcode;

/**
 * @author jiabin.niu
 * @date 2019.02
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        int length = s.length();

        if (length == 0) {
            return "";
        }
        //i - j 是否是回文子串
        boolean[][] isPalind = new boolean[length][length];

        //长度为1的最长回文子串
        for (int i = 0; i < length; i++) {
            isPalind[i][i] = true;
        }

        int im = 0, jm = 0;

        //长度为2的最长回文子串
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalind[i][i + 1] = true;
                im = i;
                jm = i + 1;
            }
        }

        int max = Integer.MIN_VALUE;

        //长度为3-n的最长回文子串长度
        for (int i = 2; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (isPalind[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) {
                    isPalind[j][j + i] = true;
                    if (i > max) {
                        max = i;
                        im = j;
                        jm = j + i;
                    }
                }
            }
        }

        return s.substring(im, jm + 1);
    }

    public static void main(String[] args) {
        String ss = new LongestPalindromeSubstring().longestPalindrome("cbbd");
        System.out.println(ss);
    }

}
