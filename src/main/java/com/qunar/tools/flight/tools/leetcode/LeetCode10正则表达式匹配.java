package com.qunar.tools.flight.tools.leetcode;

/**
 * @author jiabin.niu
 * @date 2019.02
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class LeetCode10正则表达式匹配 {


    private static final int NORMAL_MATCH = 0;
    private static final String ALL_TOKEN = ".*";
    private static final char ANY_SINGLE = '.';
    private static final char ZERO_OR_MORE = '*';
    private static final int ANY_SINGEL_STATUS = 1;
    private static final int ZERO_OR_MORE_STATUS = 2;
    private static final int ZERO_OR_MORE_STATUS_INIT = 3;

    public static void main(String[] args) {

        boolean re = new LeetCode10正则表达式匹配().isMatch("aab", "c*a*b*");
        System.out.println(re);
    }

    public boolean isMatch(String s, String p) {

        /**
         * 匹配所有字符串
         */
        if (p.equals(ALL_TOKEN)) {
            return true;
        }

        char strs[] = s.toCharArray();
        char strp[] = p.toCharArray();
        int sp = 0;
        int pp = 0;

        //当前匹配状态
        //0 表示匹配普通字符  1 表示进入 [a-z]* 匹配    2 表示进入.* 匹配
        int status = 0;
        char matchItem = '*';


        while (sp < strs.length && pp < strp.length) {

            //当前字符是普通字符
            if (isNormalCh(strp[pp])) {
                //默认是普通匹配
                status = NORMAL_MATCH;
                if (inRange(pp, strp.length - 1)) {
                    //状态升级
                    if (strp[pp + 1] == ZERO_OR_MORE) {
                        status = ZERO_OR_MORE_STATUS_INIT;
                    }
                }
                //当前字符作为匹配字符项
                matchItem = strp[pp];
            }
            //匹配任意单个字符
            else if (strp[pp] == ANY_SINGLE) {
                status = ANY_SINGEL_STATUS;
                matchItem = ANY_SINGLE;

                if (inRange(pp, strp.length - 1)) {
                    //可以匹配任意字符
                    if (strp[pp + 1] == ZERO_OR_MORE) {
                        status = ANY_SINGEL_STATUS;
                        matchItem = ZERO_OR_MORE;
                    }
                }
            }

            //当前是*字符串


            //第一次匹配[a-z]*
            if (status == ZERO_OR_MORE_STATUS_INIT) {
                if (strs[sp] == matchItem) {
                    //升级严格匹配[a-z]*
                    status = ZERO_OR_MORE_STATUS;
                } else {
                    pp = pp + 2;
                }
            } else if (status == ZERO_OR_MORE_STATUS || status == NORMAL_MATCH) {
                //和matchItem 不同说明  没有匹配
                if (strs[sp] != matchItem) {
                    pp = pp + 2;
                }
            } else if (status == ANY_SINGEL_STATUS) {
                pp = pp + 1;
            }
            sp++;
        }


        return sp == strs.length;
    }

    private boolean inRange(int pp, int length) {
        return pp < length;
    }

    private boolean isNormalCh(char c) {
        return c >= 'a' && c <= 'z';
    }

}
