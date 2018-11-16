package com.qunar.tools.flight.tools.product;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class ProductTagBean {

    public static final ProductTagBean ALL_TAG = new ProductTagBean("*",null);

    /**
     * tag名称
     */
    private String tagName;

    /**
     * 对应的包装策略
     */
    private ProductStrategyBean packageStrategyBean;


    public ProductTagBean(String tagName, ProductStrategyBean packageStrategyBean) {
        this.tagName = tagName;
        this.packageStrategyBean = packageStrategyBean;
    }
}
