package com.qunar.tools.flight.tools.leetcode;
import java.util.Stack;
/**
 * @author : jiabin.niu
 **/
public class LeetCode最长有效括号 {
    public int longestValidParentheses(String s) {
        int max = 0, start = 0;
        if (null == s) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < len; index++) {
            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
            if ('(' == s.charAt(index)) {
                stack.push(index);
                continue;
            } else {
                if (stack.isEmpty()) {
                    start = index + 1;
                    continue;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, index - start + 1);
                    } else {
                        max = Math.max(max, index - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
