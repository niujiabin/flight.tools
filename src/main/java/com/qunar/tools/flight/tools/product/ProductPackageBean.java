package com.qunar.tools.flight.tools.product;

import java.util.Set;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class ProductPackageBean {

    private int id;

    /**
     * 名称
     */
    private int name;

    /**
     * tag
     */
    private ProductTagBean productTagBean;

    /**
     * 策略
     */
    private ProductStrategyBean productStrategyBean;
    /**
     * 包含商品
     */
    private Set<ProductGoodsBean> includeProductGoodsBeans;
    /**
     * 必须包含商品
     */
    private Set<ProductGoodsBean> necessaryIncludeGoods;
    /**
     * 状态
     */
    private boolean status;

    /**
     * 生效日期
     */
    private String effectiveDate;

    /**
     * 修改日期
     */
    private String modifyDate;

}
