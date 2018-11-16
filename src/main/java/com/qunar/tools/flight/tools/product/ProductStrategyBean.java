package com.qunar.tools.flight.tools.product;

/**
 * Created by jiabin.niu on 2018.11.15 21:59
 */
public class ProductStrategyBean {

    /**
     * 策略名
     */
    private String name;

    public ProductStrategyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
