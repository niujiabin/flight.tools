package com.qunar.tools.flight.tools.router;

import com.qunar.tools.flight.tools.common.TripType;
import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;
import sun.management.Agent;

import java.util.List;
import java.util.Map;

/**
 * router搜索参数
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class RouterSearchParam {


    /**
     *
     */
    private List<FlightOriginDestinationBean> flightOriginDestinationBeanList;

    /**
     * 单程 往返  缺口
     */
    private List<TripType> tripType;


    /**
     * 请求源
     */
    private String requestSource;

    /**
     * 代理商信息
     */
    private Map<String, AgentBean> agentBeanMap;

    /**
     * 航班代码信息
     */
    private Map<FlightBasicRouteSegmentKey, FlightCodeValue> flightCodeValueMap;


    public Map<FlightBasicRouteSegmentKey, FlightCodeValue> getFlightCodeValueMap() {
        return flightCodeValueMap;
    }

    public void setFlightCodeValueMap(Map<FlightBasicRouteSegmentKey, FlightCodeValue> flightCodeValueMap) {
        this.flightCodeValueMap = flightCodeValueMap;
    }

    public Map<String, AgentBean> getAgentBeanMap() {
        return agentBeanMap;
    }

    public void setAgentBeanMap(Map<String, AgentBean> agentBeanMap) {
        this.agentBeanMap = agentBeanMap;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public List<TripType> getTripType() {
        return tripType;
    }

    public void setTripType(List<TripType> tripType) {
        this.tripType = tripType;
    }

    public List<FlightOriginDestinationBean> getFlightOriginDestinationBeanList() {
        return flightOriginDestinationBeanList;
    }

    public void setFlightOriginDestinationBeanList(List<FlightOriginDestinationBean> flightOriginDestinationBeanList) {
        this.flightOriginDestinationBeanList = flightOriginDestinationBeanList;
    }
}
