package com.qunar.tools.flight.tools.packaging.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.qunar.tools.flight.tools.merge.MergePriceResult;
import com.qunar.tools.flight.tools.merge.service.MergePriceService;
import com.qunar.tools.flight.tools.packaging.*;
import com.qunar.tools.flight.tools.product.ProductStrategyBean;
import com.qunar.tools.flight.tools.product.ProductTagBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author jiabin.niu
 * @date 2018.11
 */
@Service
public class PackagingServiceImpl implements PackagingService {

    @Resource
    private MergePriceService mergePriceService;

    @Override
    public PackageResult queryFlightPriceDetail(FlightPriceDetailParam fp, String env) {

        Preconditions.checkNotNull(fp, "参数 flightPriceDetailParam 不能为空 ^_^ ");

        Map<String, Object> attachment = Maps.newHashMap();
        attachment.put("flight.packaging.detail", true);
        /**
         * 返程日期不为空
         */
        List<FlightOriginDestinationBean> flightOriginDestinationBeans;
        if (StringUtils.isNotBlank(fp.getReturnDate())) {
            flightOriginDestinationBeans = Lists.newArrayList(
                    new FlightOriginDestinationBean(fp.getOrigin(), fp.getDestination(), fp.getDepartureDate()),
                    new FlightOriginDestinationBean(fp.getDestination(), fp.getOrigin(), fp.getReturnDate())
            );
        } else {
            flightOriginDestinationBeans = Lists.newArrayList(
                    new FlightOriginDestinationBean(fp.getOrigin(), fp.getDestination(), fp.getDepartureDate())
            );
        }
        /**
         * 包装主要参数
         */
        PackageParam packageParam = new PackageParam();
        packageParam.setAdultNumber(fp.getAdultCount());
        packageParam.setChildrenNumber(fp.getChildrenCount());
        packageParam.setFlightOriginDestinationBean(flightOriginDestinationBeans);
        packageParam.setRequestSource("self-beta");
        packageParam.setQueryId(fp.getQueryId());
        packageParam.setExt(attachment);

        PackageResult packageResult;

        if (StringUtils.isEmpty(fp.getAirRoute())) {
            packageResult = packageFlightList(packageParam);
        } else {
            packageParam.setFlightCombinations(Sets.newHashSet(fp.getFlightCombination()));
            packageResult = packageFlightDetailList(packageParam);
        }

        return null;
    }

    /**
     * 查询航班列表详情
     *
     * @param packageParam
     * @return
     */
    private PackageResult packageFlightDetailList(PackageParam packageParam) {
        return null;
    }

    /**
     * 查询航班列表
     *
     * @param packageParam
     * @return
     */
    private PackageResult packageFlightList(PackageParam packageParam) {

        if (CollectionUtils.isEmpty(packageParam.getProductTagBeanSet())) {
            packageParam.setProductTagBeanSet(Sets.newHashSet(ProductTagBean.ALL_TAG));
        }
        //查航班列表
        packageParam.setQueryType("flightList");
        //设置为增量包装
        packageParam.setIncrement(true);
        //设置需要的包装策略
        packageParam.setProductStrategyBeans(Sets.newHashSet(
                new ProductStrategyBean("LPP"),
                new ProductStrategyBean("LPN"),
                new ProductStrategyBean("CHP")
        ));
        //执行包装
        PackageResult packageResult = doPackageFlightList(packageParam);

        return packageResult;
    }

    /**
     * @param packageParam 包装参数
     * @return 包装结果
     */
    private PackageResult doPackageFlightList(PackageParam packageParam) {

        //根据queryId获取缓存 后面再实现

        /**
         * 根据包装参数查询merge报价
         */
        MergePriceResult mergePriceResult = mergePriceService.queryMergePrice(packageParam);
        return null;
    }
}
