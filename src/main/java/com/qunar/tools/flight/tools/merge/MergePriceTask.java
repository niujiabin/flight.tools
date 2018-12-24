package com.qunar.tools.flight.tools.merge;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.common.MergeExtData;
import com.qunar.tools.flight.tools.merge.pricefilter.MergeBanSalePriceFilter;
import com.qunar.tools.flight.tools.router.RouterAggregationMessageBean;
import com.qunar.tools.flight.tools.router.RouterAggregationResult;
import com.qunar.tools.flight.tools.router.RouterSearchParam;
import com.qunar.tools.flight.tools.util.FlightMapUtils;
import javafx.util.Pair;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * merge报价任务
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class MergePriceTask implements Runnable {


    private String queryId;

    private RouterAggregationMessageBean message;

    @Resource
    private MergeBanSalePriceFilter mergeBanSalePriceFilter;

    public MergePriceTask(final String queryId, final RouterAggregationMessageBean routerAggregationBean) {
        this.queryId = queryId;
        this.message = routerAggregationBean;
    }

    @Override
    public void run() {
        //router 报价结果
        RouterAggregationResult routerAggregationResult = message.getRouterAggregationResult();
        //router 报价搜索参数
        RouterSearchParam routerSearchParam = message.getRouterSearchParam();
        //禁售过滤
        RouterAggregationResult routerAggregationFilteredResult = mergeBanSalePriceFilter.priceFilter(routerSearchParam, routerAggregationResult);
        //报价分类整理
        Pair<RouterAggregationResult, Map<String, Map<String, FlightPriceKey>>> transformResult = priceTransform(routerAggregationFilteredResult, queryId);
        //产品需求  自营调价   代理商加价算到比较中
        //some product need to handle

        MergeContext mergeContext = new MergeContext();
        //有报价
        if (!transformResult.getValue().isEmpty()) {
            processMergeContext(queryId , routerAggregationFilteredResult , transformResult , message , mergeContext);
        } else {
            processEmptyPrice();
            return;
        }
    }


    private void processMergeContext(String queryId, RouterAggregationResult routerAggregationFilteredResult, Pair<RouterAggregationResult, Map<String, Map<String, FlightPriceKey>>> transformResult, RouterAggregationMessageBean message, MergeContext mergeContext) {


    }

    /**
     * 没有报价返回空报价
     */
    private void processEmptyPrice() {

    }

    /**
     * 报价转换
     *
     * @param result
     * @param queryId
     */
    private Pair<RouterAggregationResult, Map<String, Map<String, FlightPriceKey>>> priceTransform(RouterAggregationResult result, String queryId) {

        /**
         * <航线 , <策略tag,报价key>>
         * 意义：某航线下会有不同的策略tag,每一个策略tag有不同的报价
         */
        final Map<String, Map<String, FlightPriceKey>> transformPriceMap = Maps.newHashMap();

        return doPriceTransform(result, transformPriceMap);


    }

    /**
     * 报价转换
     */
    private Pair<RouterAggregationResult, Map<String, Map<String, FlightPriceKey>>> doPriceTransform(RouterAggregationResult result,
                                                                                                     Map<String, Map<String, FlightPriceKey>> transformPriceMap) {

        Map<FlightPriceKey, FlightPrice> priceMap = result.getPriceMap();
        for (Map.Entry<FlightPriceKey, FlightPrice> entry : priceMap.entrySet()) {
            final FlightPriceKey flightPriceKey = entry.getKey();
            final FlightPrice flightPrice = entry.getValue();
            Map<String, FlightPriceKey> airlineValueMap = FlightMapUtils.putNewIfAbsentAirLineKey(transformPriceMap, flightPriceKey.getCode());
            airlineValueMap.put(flightPriceKey.getPackagingTag(), wrapMergeExt(flightPriceKey, flightPrice));
        }
        return new Pair<>(result, transformPriceMap);

    }

    /**
     * 添加扩展信息
     *
     * @param flightPriceKey
     * @param flightPrice
     * @return
     */
    private FlightPriceKey wrapMergeExt(FlightPriceKey flightPriceKey, FlightPrice flightPrice) {
        MergeExtData mergeExtData = new MergeExtData();
        mergeExtData.setDataExt(Maps.newHashMap());
        mergeExtData.setKey(flightPrice.getKey());
        mergeExtData.setPrice(calculatePriceWithTax(flightPrice));
        flightPriceKey.setMergeExtData(mergeExtData);
        return flightPriceKey;
    }

    /**
     * 计算税相关
     *
     * @param flightPrice
     * @return
     */
    private BigDecimal calculatePriceWithTax(FlightPrice flightPrice) {
        return flightPrice.getTaxAdult();
    }
}
