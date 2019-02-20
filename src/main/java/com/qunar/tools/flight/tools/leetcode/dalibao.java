package com.qunar.tools.flight.tools.leetcode;

/**
 * Created by jiabin.niu on 2019.01.29 16:46
 */

import java.util.List;

/**
 * 在LeetCode商店中， 有许多在售的物品。
 * <p>
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * <p>
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * <p>
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * <p>
 * 任意大礼包可无限次购买。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 * 示例 2:
 * <p>
 * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * 输出: 11
 * 解释:
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和2B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 * 说明:
 * <p>
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 */
public class dalibao {

    public static void main(String[] args) {


    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = Integer.MAX_VALUE;
        //对于每一个礼包
        for (int i = 0; i < special.size(); i++) {
            boolean isValid = true;
            List<Integer> offer = special.get(i);
            //使用了某个礼包
            for (int j = 0; j < needs.size(); j++) {
                int remain = needs.get(j) - offer.get(j);
                if (remain < 0) {
                    isValid = false;
                }
                //更新购物列表需求值
                needs.set(j, remain);
            }
            if (isValid) {
                //当前结果 和 子任务 + 当前礼包值   比较
                res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(needs.size()));
            }
            //计算解结果后恢复到上个状态
            for (int j = 0; j < needs.size(); i++) {
                needs.set(j, needs.get(j) + offer.get(j));
            }
        }
        int nonOffer = 0;
        for (int i = 0; i < needs.size(); i++) {
            nonOffer += needs.get(i) * price.get(i);
        }
        return Math.min(nonOffer, res);
    }
}
