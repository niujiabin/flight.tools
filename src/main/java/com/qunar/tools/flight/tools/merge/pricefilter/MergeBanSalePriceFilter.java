package com.qunar.tools.flight.tools.merge.pricefilter;

import com.qunar.flight.block.price.model.BlockRequest;
import com.qunar.tools.flight.tools.common.FlightOriginDesWithRetBean;
import com.qunar.tools.flight.tools.common.FlightPrice;
import com.qunar.tools.flight.tools.common.FlightPriceKey;
import com.qunar.tools.flight.tools.common.TripType;
import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;
import com.qunar.tools.flight.tools.router.*;
import com.qunar.tools.flight.tools.util.FlightCollectionUtils;
import com.qunar.tools.flight.tools.util.MoneyUtils;
import com.qunar.tools.flight.tools.util.TripTypeUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * merge 过程中对禁售报价进行过滤
 *
 * @author jiabin.niu
 * @date 2018.11
 */
@Component
public class MergeBanSalePriceFilter {


    /**
     * 报价过滤
     *
     * @param routerSearchParam       router搜索参数
     * @param routerAggregationResult router 报价聚合结果
     */
    public RouterAggregationResult priceFilter(RouterSearchParam routerSearchParam, RouterAggregationResult routerAggregationResult) {

        if (filterOpen()
                && Objects.nonNull(routerAggregationResult)
                && Objects.nonNull(routerSearchParam)
                && !(retryCheck(routerSearchParam))) {

            int priceCountBerforeFilter = FlightCollectionUtils.mapSize(routerAggregationResult.getPriceMap());
            //构建禁售参数
            BlockRequest blockRequest = buildCheckBanSaleParam(routerSearchParam);
            //执行报价过滤
            routerAggregationResult = doFilter(routerSearchParam, routerAggregationResult, blockRequest);
        }

        return routerAggregationResult;
    }

    /**
     * 执行报价过滤
     *
     * @param routerSearchParam
     * @param routerAggregationResult
     * @return
     */
    private RouterAggregationResult doFilter(RouterSearchParam routerSearchParam, RouterAggregationResult routerAggregationResult, BlockRequest blockRequest) {

        //获取router聚合报价
        Map<FlightPriceKey, FlightPrice> priceMap = routerAggregationResult.getPriceMap();
        //获取航班代码
        Map<FlightBasicRouteSegmentKey, FlightCodeValue> codeMap = routerSearchParam.getFlightCodeValueMap();
        //代理商信息
        Map<String, AgentBean> agentMap = routerSearchParam.getAgentBeanMap();
        //代理商域名
        String domain = routerAggregationResult.getDomain();
        //行程类型
        TripType tripType = TripTypeUtils.getTripType(routerSearchParam.getFlightOriginDestinationBeanList());
        /**
         *  遍历报价信息
         */
        for (Map.Entry<FlightPriceKey, FlightPrice> price : priceMap.entrySet()) {

            FlightPriceKey priceKey = price.getKey();
            FlightPrice priceValue = price.getValue();
            //是否在黑名单列表
            if (isInBlackList(domain, agentMap, priceKey, priceValue, codeMap, tripType.getType(), blockRequest)) {

            }
        }
        return null;
    }

    /**
     * 是否在黑名单列表
     *
     * @param domain         代理商域名
     * @param agentBeanMap   代理商列表
     * @param priceKey       价格key
     * @param priceValue     报价信息
     * @param segmentCodeMap 行程代码信息
     * @param type           行程类型
     * @param blockRequest
     * @return 是否在黑名单中
     */
    private boolean isInBlackList(String domain, Map<String, AgentBean> agentBeanMap, FlightPriceKey priceKey, FlightPrice priceValue,
                                  Map<FlightBasicRouteSegmentKey, FlightCodeValue> segmentCodeMap, int type, BlockRequest blockRequest) {
        //价格
        BigDecimal price = MoneyUtils.getMoneyNoNullOrZero(priceValue.getViewPrice(), priceValue.getAdultPrice());
        //代理商信息
        AgentBean agentBean = agentBeanMap.get(domain);
        //判断是否是采购分销
        if (isDistributePolicy(priceValue)) {
            //采购分销domain 替换成供应商
            domain = getProviderSite(priceValue);
            //采购分销wrapper取不到  设置为空
            agentBean.setOneWayWrapperId("");
            agentBean.setRoundTripWrapperId("");
        }
        //成人税费
        BigDecimal tax = priceValue.getTaxAdult();

        List<List<FlightBasicRouteSegmentKey>> segmentKeys = priceValue.getBasicSegmentKeys();
        return true;
    }

    private String getProviderSite(FlightPrice priceValue) {
        return null;
    }

    /**
     * 判断是否是采购分销政策
     *
     * @param priceValue
     * @return 如果是采购分销政策返回true
     */
    private boolean isDistributePolicy(FlightPrice priceValue) {

        String policyInfo = priceValue.getPolicyInfo();
        if (!StringUtils.isEmpty(policyInfo)) {
            //政策代码
            String policyCode = policyInfo.substring(0, 2);

        }
        return true;
    }

    /**
     * 构建禁售参数
     *
     * @param routerSearchParam
     * @return
     */
    private BlockRequest buildCheckBanSaleParam(RouterSearchParam routerSearchParam) {

        List<FlightOriginDestinationBean> flist = routerSearchParam.getFlightOriginDestinationBeanList();

        FlightOriginDesWithRetBean fb = TripTypeUtils.getFlightOriginDesWithRes(flist);

        BlockRequest blockRequest = new BlockRequest();
        blockRequest.setDepDate(fb.getDepartureDate());
        blockRequest.setFromCity(fb.getOrigin());
        blockRequest.setRetDate(fb.getReturnDate());
        blockRequest.setToCity(fb.getDestination());
        blockRequest.setSource(routerSearchParam.getRequestSource());

        return blockRequest;
    }

    private boolean retryCheck(RouterSearchParam routerSearchParam) {
        return false;
    }

    private boolean filterOpen() {
        return true;
    }
}
