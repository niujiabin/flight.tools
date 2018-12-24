package com.qunar.tools.flight.tools.merge;

import com.google.common.collect.Maps;
import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.router.RouterAggregationResult;
import org.apache.commons.collections.MapUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * merge
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class MergeContext {


    private final Map<String, Map<String, FixSizeMinPriorityQueue>> priceMap = Maps.newConcurrentMap();

    private void mergePrice(final RouterAggregationResult routerAggregationResult,
                            Map<String, Map<FlightPriceKey, Set<String>>> itemTobeSelected,
                            Map<String, Map<String, FlightPriceKey>> airLineTagRriceKeyMaps) {
        //router结果报价信息
        Map<FlightPriceKey, FlightPrice> priceKeyFlightPriceMap = routerAggregationResult.getPriceMap();
        //域名
        String domain = routerAggregationResult.getDomain();
        //airline-tag-priceKey
        for (Map.Entry<String, Map<String, FlightPriceKey>> entry : airLineTagRriceKeyMaps.entrySet()) {
            Map<String, FlightPriceKey> flightPriceMap = entry.getValue();
            //tag-priceKey
            for (Map.Entry<String, FlightPriceKey> tagPriceEntry : flightPriceMap.entrySet()) {
                try {
                    //flightPrice获取报价信息
                    FlightPrice flightPrice = priceKeyFlightPriceMap.get(tagPriceEntry.getValue());
                    //添加航线附加信息

                } catch (Exception e) {

                }
            }
        }
    }

    /**
     * 报价merge
     */
    private void doPriceMerge(String tag, String domain, FlightPriceKey flightPriceKey, String qualification,
                              FlightPrice flightPrice, Map<String, Map<FlightPriceKey, Set<String>>> itemTobeSelected) {

        String flightCode = flightPriceKey.getCode();
        //某个航线的最小优先对比队列
        Map<String, FixSizeMinPriorityQueue> fixSizeMinPriorityQueueMap = newMapAndPutIfAbsent(flightCode, priceMap.get(flightCode));
        //获取对比当前tag的优先队列
        FixSizeMinPriorityQueue fixSizeMinPriorityQueue = newQueueIfAbsent(fixSizeMinPriorityQueueMap.get(tag), tag);
        FlightPriceWithKey flightPriceWithKey = new FlightPriceWithKey(flightPriceKey, flightPrice, domain, flightPriceKey.getMergeExtData(), 0L);
        //入队比价
        boolean isCompareSuccess = fixSizeMinPriorityQueue.offerComparePrice(flightPriceWithKey);

    }


    private FixSizeMinPriorityQueue newQueueIfAbsent(FixSizeMinPriorityQueue fixSizeMinPriorityQueue, String tag) {
        //优先队列为空
        if (Objects.isNull(fixSizeMinPriorityQueue)) {
            fixSizeMinPriorityQueue = new FixSizeMinPriorityQueue(1);
        }
        return fixSizeMinPriorityQueue;
    }

    private Map<String, FixSizeMinPriorityQueue> newMapAndPutIfAbsent(String flightCode, Map<String, FixSizeMinPriorityQueue> fixSizeMinPriorityQueueMap) {

        if (MapUtils.isEmpty(fixSizeMinPriorityQueueMap)) {
            fixSizeMinPriorityQueueMap = Maps.newConcurrentMap();
            priceMap.put(flightCode, fixSizeMinPriorityQueueMap);
        }
        return fixSizeMinPriorityQueueMap;
    }
}
