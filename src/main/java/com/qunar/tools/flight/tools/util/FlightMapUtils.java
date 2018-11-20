package com.qunar.tools.flight.tools.util;

import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.merge.MergePriceTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * map工具类
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightMapUtils {

    public static final int DEFAULT_TAG_CAPACITY = 3;

    public static final int DEFAULT_PRICE_CAPACITY = 2;

    public static Map<String, FlightPriceKey> putNewIfAbsentAirLineKey(Map<String, Map<String, FlightPriceKey>> transformPriceMap, String keyCode) {
        Map<String, FlightPriceKey> map = transformPriceMap.get(keyCode);
        if (map == null) {
            map = transformPriceMap.put(keyCode, new HashMap<>(DEFAULT_TAG_CAPACITY));
        }
        return map;
    }


}
