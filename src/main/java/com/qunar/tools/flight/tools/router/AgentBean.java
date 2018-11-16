package com.qunar.tools.flight.tools.router;

import javafx.util.Pair;

import java.util.Set;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 *
 * 代理商信息
 * 包括 代理商域名 和 代理商单程往返wrapperId
 */
public class AgentBean {

    /**
     * 代理商域名
     */
    private String domain;

    /**
     * 单程wrapperId
     */
    private String oneWayWrapperId;

    /**
     * 往返wrapperId
     */
    private String roundTripWrapperId;

    public String getOneWayWrapperId() {
        return oneWayWrapperId;
    }

    public void setOneWayWrapperId(String oneWayWrapperId) {
        this.oneWayWrapperId = oneWayWrapperId;
    }

    public String getRoundTripWrapperId() {
        return roundTripWrapperId;
    }

    public void setRoundTripWrapperId(String roundTripWrapperId) {
        this.roundTripWrapperId = roundTripWrapperId;
    }


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


}
