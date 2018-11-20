package com.qunar.tools.flight.tools.common;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class MergeExtData {

    private String key;

    private BigDecimal price;

    private Map<String,String> dataExt;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<String, String> getDataExt() {
        return dataExt;
    }

    public void setDataExt(Map<String, String> dataExt) {
        this.dataExt = dataExt;
    }
}
