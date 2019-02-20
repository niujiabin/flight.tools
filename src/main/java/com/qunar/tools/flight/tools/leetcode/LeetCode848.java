package com.qunar.tools.flight.tools.leetcode;

/**
 * @author jiabin.niu
 * @date 2019.02
 */
public class LeetCode848 {

    public static void main(String[] args) {

        System.out.println((char) ('a' + 0));
        new LeetCode848().shiftingLetters("z", new int[]{52});

    }


    public String shiftingLetters(String S, int[] shifts) {

        char[] chars = S.toCharArray();

        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i + 1] + shifts[i]) % 26;
        }
        shifts[shifts.length - 1] = shifts[shifts.length - 1] % 26;

        for (int i = 0; i < shifts.length; i++) {
            if (chars[i] + shifts[i] > 'z') {
                chars[i] = (char) (shifts[i] - ('z' - chars[i]) + 'a' - 1);
            } else {
                chars[i] = (char) (chars[i] + shifts[i]);
            }
        }
        for (int i = 0; i < shifts.length; i++) {
            System.out.print(chars[i]);
        }
        return chars.toString();
    }

}
