package com.qunar.tools.flight.tools.merge;

import com.qunar.tools.flight.tools.router.AgentBean;
import com.qunar.tools.flight.tools.router.RouterAggregationMessageBean;
import com.qunar.tools.flight.tools.router.RouterAggregationResult;
import com.qunar.tools.flight.tools.router.RouterSearchParam;

/**
 * merge报价任务
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class MergePriceTask implements Runnable {


    private String queryId;

    private RouterAggregationMessageBean routerAggregationMessageBean;

    public MergePriceTask(final String queryId, final RouterAggregationMessageBean routerAggregationBean) {
        this.queryId = queryId;
        this.routerAggregationMessageBean = routerAggregationBean;
    }

    @Override
    public void run() {
        //router 报价结果
        RouterAggregationResult routerAggregationResult = routerAggregationMessageBean.getRouterAggregationResult();
        //router 搜索参数
        RouterSearchParam routerSearchParam = routerAggregationMessageBean.getRouterSearchParam();
        //代理商域名
        String agentDomain = routerAggregationResult.getAgentBean().getDomain();



    }
}
