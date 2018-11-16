package com.qunar.tools.flight.tools.merge.service;

import com.qunar.tools.flight.tools.merge.MergePriceResult;
import com.qunar.tools.flight.tools.packaging.PackageParam;
import com.qunar.tools.flight.tools.router.RouterAggregationBean;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public interface MergePriceService {
    /**
     * 查询merge报价
     * @param packageParam 包装报价参数
     * @return merge报价结果
     */
    MergePriceResult queryMergePrice(PackageParam packageParam);

    /**
     * router调用merge进行报价整合
     *
     * @param queryId  查询id
     * @param routerAggregationBean router系统的聚合结果
     */
    void doMergeFromMergeSys(String queryId,final RouterAggregationBean routerAggregationBean);
}
