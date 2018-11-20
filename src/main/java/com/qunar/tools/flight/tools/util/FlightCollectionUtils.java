package com.qunar.tools.flight.tools.util;

import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightCollectionUtils {


    /**
     * 获取map大小
     *
     * @param map
     * @return
     */
    public static int mapSize(Map<? extends Object, ? extends Object> map) {
        return map == null ? 0 : map.size();
    }

    /**
     * 某个集合大小是否大于size
     *
     * @param collection
     * @param size
     * @return
     */
    public static boolean sizeLargerThan(Collection<? extends Object> collection, int size) {
        return !CollectionUtils.isEmpty(collection) && collection.size() > size;
    }
}
