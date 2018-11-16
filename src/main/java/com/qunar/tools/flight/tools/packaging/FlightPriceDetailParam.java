package com.qunar.tools.flight.tools.packaging;

import com.qunar.tools.flight.tools.router.AgentBean;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 *
 * 报价查询参数
 */
public class FlightPriceDetailParam {

    /**
     * 始发地
     */
    private String origin;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 出发日期
     */
    private String departureDate;

    /**
     * 到达日期
     */
    private String arrivalDate;

    /**
     * 返程日期
     */
    private String returnDate;
    /**
     * 代理商信息
     */
    private AgentBean agentBean;

    /**
     * 航线
     */
    private String airRoute;

    /**
     * 日期范围
     */
    private String dateRange;

    /**
     * 航司
     */
    private FlightCombination flightCombination;

    private String version;

    /**
     * 成人数量
     */
    private int adultCount;

    /**
     * 儿童数量
     */
    private int childrenCount;

    /**
     * 本次查询Id
     */
    private String queryId;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AgentBean getAgentBean() {
        return agentBean;
    }

    public void setAgentBean(AgentBean agentBean) {
        this.agentBean = agentBean;
    }

    public String getAirRoute() {
        return airRoute;
    }

    public void setAirRoute(String airRoute) {
        this.airRoute = airRoute;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public FlightCombination getFlightCombination() {
        return flightCombination;
    }

    public void setFlightCombination(FlightCombination flightCombination) {
        this.flightCombination = flightCombination;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
