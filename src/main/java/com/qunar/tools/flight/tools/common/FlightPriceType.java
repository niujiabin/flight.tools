package com.qunar.tools.flight.tools.common;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 所有价格类型
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightPriceType {

    public static Map<String,String> priceTypeMap = Maps.newHashMap();

    static {
        priceTypeMap.put("CPA","CPA报价节点");
        priceTypeMap.put("CPC","CPC报价节点");
        priceTypeMap.put("AGE_LIMIT","年龄限制");
        priceTypeMap.put("TIME_RANGE","模糊航班-国内超值飞");
        priceTypeMap.put("INTER","国际机票报价");
        priceTypeMap.put("PROBABILITY","概率预约");
        priceTypeMap.put("REDIRECT_APPLY","跳转预约");
        priceTypeMap.put("NPROB","国内概率预约");
        priceTypeMap.put("POLICY","政策调价");
        priceTypeMap.put("TKP","出票报价");
        priceTypeMap.put("ITTS","ITTS报价");
        priceTypeMap.put("IFS","旗舰店运价直连接入");
    }
}
