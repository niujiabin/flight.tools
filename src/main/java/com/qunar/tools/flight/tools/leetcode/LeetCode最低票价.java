package com.qunar.tools.flight.tools.leetcode;

/**
 * @author : jiabin.niu
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * <p>
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 **/
public class LeetCode最低票价 {

    public int mincostTickets(int[] days, int[] costs) {
        // 节省空间，所以不使用365，使用今天旅行的最后一天
        int[] lastAllDaysCost = new int[days[days.length - 1] + 1];
        // 将旅行天数
        int countDays = 1;
        int ticketDay = costs[0];
        int ticketWeek = costs[1];
        int ticketMonth = costs[2];
        lastAllDaysCost[0] = 0;
        lastAllDaysCost[days[0]] = ticketDay;
        // lastAllCost[i] 是截至到今年的第 i 天的总花费.
        // 模拟时间跑起来，从旅行的第二天跑到旅行的最后一天。
        for (int i = days[0] + 1; i <= days[days.length - 1]; i++) {
            if (days[countDays] != i) {
                // 如果这一天不旅行那么直接把上一天的过去总花费拿过来直接使用。
                lastAllDaysCost[i] = lastAllDaysCost[i - 1];
                continue;
            }
            // 开始进入下一个待旅行的日子
            countDays++;
            // 如果一月前，买了月票，会不会更便宜？
            // 如果一周前，买了周票，会不会更便宜？
            // 如果都不会的话，那我暂时先买日票试试呗。
            lastAllDaysCost[i] = Math.min(
                    Math.min(
                            lastAllDaysCost[Math.max(0, i - 1)] + ticketDay
                            , lastAllDaysCost[Math.max(0, i - 7)] + ticketWeek)
                    , lastAllDaysCost[Math.max(0, i - 30)] + ticketMonth);
        }
        return lastAllDaysCost[days[days.length - 1]];
    }
}
