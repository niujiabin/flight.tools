package com.qunar.tools.flight.tools.merge;

import com.google.common.collect.Maps;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * merge队列比较器
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class FixSizeMinPriorityQueue {

    private final PriorityQueue<FlightPriceWithKey> priorityQueue;

    /**
     * key代理商  value最低价
     * 每个代理商保留一个最低价
     */
    private Map<String, FlightPriceWithKey> priceWithKeyMap = Maps.newConcurrentMap();

    private final int maxSize;

    public FixSizeMinPriorityQueue(int queueSize) {
        this.maxSize = queueSize;
        this.priorityQueue = new PriorityQueue<>(queueSize);
    }

    /**
     * 入队merge比价
     *
     * @param flightPriceWithKey 需要比价的报价
     * @return 是否比较成功
     */
    public boolean offerComparePrice(FlightPriceWithKey flightPriceWithKey) {

        if (Objects.isNull(flightPriceWithKey)) {
            return false;
        }

        if (priorityQueue.size() < maxSize && !priceWithKeyMap.entrySet().contains(flightPriceWithKey.getDomain())) {

        } else {
            //达到队列长度
            if (!priceWithKeyMap.entrySet().contains(flightPriceWithKey.getDomain())){
                FlightPriceWithKey topFlightPrice = priorityQueue.peek();
                //对比两个报价
                /*if (topFlightPrice.){

                }*/
            }
        }
        return true;
    }
}
