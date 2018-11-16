package com.qunar.tools.flight.tools.packaging.service;

import com.qunar.tools.flight.tools.packaging.FlightPriceDetailParam;
import com.qunar.tools.flight.tools.packaging.PackageResult;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 *
 * 包装service
 *
 */

public interface PackagingService {

    /**
     * 获取包装结果
     * @param flightPriceDetailParam
     * @param env
     * @return 获取最终的包装结果
     */
    PackageResult queryFlightPriceDetail(FlightPriceDetailParam flightPriceDetailParam, String env);
}
