package com.qunar.tools.flight.tools.router;

import java.io.Serializable;

/**
 * 报价结果中的交通工具key表示
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightBasicRouteSegmentKey implements Serializable {

    private static final long serialVersionUID = 2196064527985277603L;

    /**
     * 交通工具代码
     */
    private String code;

    /**
     * 起飞日期
     */
    private String departureDate;

    /**
     * 起飞地  一般是机场三字码
     */
    private String origin;

    /**
     * 出发时间范围
     */
    private String timeRange;

    /**
     *
     */
    private float probality = -1f;

    /**
     * 到达地
     */
    private String destination;

    /**
     * 报价源
     */
    private String priceSource;


    public FlightBasicRouteSegmentKey(String code, String departureDate, String origin, String timeRange, float probality, String destination) {
        this.code = code;
        this.departureDate = departureDate;
        this.origin = origin;
        this.timeRange = timeRange;
        this.probality = probality;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlightBasicRouteSegmentKey that = (FlightBasicRouteSegmentKey) o;
        if (Float.compare(that.probality, probality) != 0) {
            return false;
        }
        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null) {
            return false;
        }
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) {
            return false;
        }
        if (timeRange != null ? !timeRange.equals(that.timeRange) : that.timeRange != null) {
            return false;
        }
        return destination != null ? destination.equals(that.destination) : that.destination == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (timeRange != null ? timeRange.hashCode() : 0);
        result = 31 * result + (probality != +0.0f ? Float.floatToIntBits(probality) : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightCodeKey{" +
                "code='" + code + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", origin='" + origin + '\'' +
                ", timeRange='" + timeRange + '\'' +
                ", probality=" + probality +
                ", destination='" + destination + '\'' +
                '}';
    }
}
