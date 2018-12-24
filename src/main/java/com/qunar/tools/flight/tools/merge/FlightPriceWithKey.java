package com.qunar.tools.flight.tools.merge;

import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.common.MergeExtData;

import java.util.Map;
import java.util.Objects;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightPriceWithKey implements Comparable<FlightPriceWithKey> {

    private FlightPriceKey flightPriceKey;
    private FlightPrice flightPrice;
    private String domain;
    private MergeExtData priceExt;
    private long createTime;

    public FlightPriceWithKey(FlightPriceKey flightPriceKey, FlightPrice flightPrice, String domain, MergeExtData priceExt, long createTime) {
        this.flightPriceKey = flightPriceKey;
        this.flightPrice = flightPrice;
        this.domain = domain;
        this.priceExt = priceExt;
        this.createTime = createTime;
    }


    public FlightPriceKey getFlightPriceKey() {
        return flightPriceKey;
    }

    public void setFlightPriceKey(FlightPriceKey flightPriceKey) {
        this.flightPriceKey = flightPriceKey;
    }

    public FlightPrice getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(FlightPrice flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public MergeExtData getPriceExt() {
        return priceExt;
    }

    public void setPriceExt(MergeExtData priceExt) {
        this.priceExt = priceExt;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public int compareTo(FlightPriceWithKey other) {
        return Objects.equals(this, other) ? 0 : compareContainTaxPrice(this, other);
    }

    /**
     * merge比价
     * @param flightPriceWithKey
     * @param other
     * @return
     */
    private int compareContainTaxPrice(FlightPriceWithKey flightPriceWithKey, FlightPriceWithKey other) {



        return 0;
    }
}
