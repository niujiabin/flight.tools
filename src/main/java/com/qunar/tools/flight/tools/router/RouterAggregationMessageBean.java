package com.qunar.tools.flight.tools.router;

/**
 * router聚合结果
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class RouterAggregationMessageBean {

    /**
     * router搜索时的参数
     */
    private RouterSearchParam routerSearchParam;

    /**
     * router聚合报价后的最终结果
     */
    private RouterAggregationResult routerAggregationResult;

    public RouterSearchParam getRouterSearchParam() {
        return routerSearchParam;
    }

    public void setRouterSearchParam(RouterSearchParam routerSearchParam) {
        this.routerSearchParam = routerSearchParam;
    }

    public RouterAggregationResult getRouterAggregationResult() {
        return routerAggregationResult;
    }

    public void setRouterAggregationResult(RouterAggregationResult routerAggregationResult) {
        this.routerAggregationResult = routerAggregationResult;
    }
}
