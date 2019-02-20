package com.qunar.tools.flight.tools.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiabin.niu on 2019.02.02 11:32
 */
public class LeetCode6 {

    public static void main(String[] args) {

        String re = new LeetCode6().convert("LEETCODEISHIRING", 3);
        System.out.println(re);

    }

    private static final int DOWN = 0;
    private static final int UP_AND_RIGHT = 1;

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

    }

    private char[] getResult(char[][] chars, int length) {

        char[] re = new char[length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char[] a = chars[i];
            for (int j = 0; j < a.length; j++) {
                re[index++] = a[j];
            }
        }
        return re;
    }
}
