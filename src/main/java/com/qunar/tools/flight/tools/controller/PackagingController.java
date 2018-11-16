package com.qunar.tools.flight.tools.controller;

import com.qunar.tools.flight.tools.common.FlightExtensionInfo;
import com.qunar.tools.flight.tools.packaging.FlightPriceDetailParam;
import com.qunar.tools.flight.tools.packaging.PackageResult;
import com.qunar.tools.flight.tools.packaging.service.PackagingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiabin.niu
 * @date 2018.11
 * <p>
 * 包装系统Controller
 */
@RestController("beta/package")
public class PackagingController {

    //当前环境
    private static String ENV = "beta";

    @Resource
    private PackagingService packagingService;

    @RequestMapping(value = "queryFlightPriceDetail", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryFlightPriceDetail(FlightPriceDetailParam flightPriceDetailParam) {
        try {
            PackageResult packageResult = packagingService.queryFlightPriceDetail(flightPriceDetailParam,ENV);
        } catch (Exception e) {

        }
        return "";
    }
}
