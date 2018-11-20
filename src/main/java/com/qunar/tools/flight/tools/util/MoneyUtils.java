package com.qunar.tools.flight.tools.util;

import java.math.BigDecimal;

/**
 * 金额工具类
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class MoneyUtils {

    /**
     * 取两个金额不为空且不为零的
     *
     * @param priceFirst
     * @param mainPrice
     * @return 都为空返回第二个
     */
    public static BigDecimal getMoneyNoNullOrZero(BigDecimal priceFirst, BigDecimal mainPrice) {
        if (priceFirst == null || BigDecimal.ZERO.compareTo(priceFirst) == 0) {
            return mainPrice;
        } else {
            return priceFirst;
        }
    }
}
