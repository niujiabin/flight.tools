package com.qunar.tools.flight.tools.router;

import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;

import java.util.Map;

/**
 * router 聚合报价结果
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class RouterAggregationResult {

    /**
     * 代理商信息
     */
    private AgentBean agentBean;

    /**
     * 报价信息
     */
    private Map<FlightPriceKey, FlightPrice> priceMap;

    /**
     * 代理商信息
     */
    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Map<FlightPriceKey, FlightPrice> getPriceMap() {
        return priceMap;
    }

    public void setPriceMap(Map<FlightPriceKey, FlightPrice> priceMap) {
        this.priceMap = priceMap;
    }

    public AgentBean getAgentBean() {
        return agentBean;
    }

    public void setAgentBean(AgentBean agentBean) {
        this.agentBean = agentBean;
    }
}
