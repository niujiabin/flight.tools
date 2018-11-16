package com.qunar.tools.flight.tools.merge.service;



import com.qunar.tools.flight.tools.merge.MergePriceResult;
import com.qunar.tools.flight.tools.packaging.PackageParam;
import com.qunar.tools.flight.tools.router.RouterAggregationBean;

import javax.annotation.Resource;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
@Resource
public class MergePriceServiceImpl implements MergePriceService {



    @Override
    public MergePriceResult queryMergePrice(PackageParam packageParam) {

        final MergePriceResult mergePriceResult = doQueryMergePrice(packageParam);
        return null;
    }

    @Override
    public void doMergeFromMergeSys(String queryId, RouterAggregationBean routerAggregationBean) {

    }

    /**
     * 执行包装报价系统
     *
     * @param packageParam
     * @return 最终的报价结果
     */
    private MergePriceResult doQueryMergePrice(PackageParam packageParam) {

        MergePriceResult mergePriceResult = new MergePriceResult();

        //merge的这块逻辑再看看
        String queryType = packageParam.getQueryType();
        //是否增量
        boolean isIncrement = packageParam.isIncrement();
        int priceCount = 0;

        return null;
    }
}
