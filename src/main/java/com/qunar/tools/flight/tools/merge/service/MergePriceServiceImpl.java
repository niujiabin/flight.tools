package com.qunar.tools.flight.tools.merge.service;



import com.qunar.tools.flight.tools.merge.MergePriceResult;
import com.qunar.tools.flight.tools.merge.MergeProcessor;
import com.qunar.tools.flight.tools.packaging.PackageParam;
import com.qunar.tools.flight.tools.router.RouterAggregationMessageBean;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
@Resource
public class MergePriceServiceImpl implements MergePriceService {


    @Resource
    private MergeProcessor mergeProcessor;

    @Override
    public MergePriceResult queryMergePrice(PackageParam packageParam) {

        final MergePriceResult mergePriceResult = doQueryMergePrice(packageParam);
        return null;
    }



    @Override
    public void doMergeFromMergeSys(String queryId, RouterAggregationMessageBean routerAggregationBean) {


    }

    /**
     * 执行包装报价系统
     *
     * @param packageParam
     * @return 最终的报价结果
     */
    private MergePriceResult doQueryMergePrice(PackageParam packageParam) {

        String requestId = packageParam.getQueryId();
        MergePriceResult mergePriceResult = new MergePriceResult();
        //merge的这块逻辑再看看
        String queryType = packageParam.getQueryType();
        //是否增量
        boolean isIncrement = packageParam.isIncrement();
        int priceCount = 0;
        Map<String , RouterAggregationMessageBean> result = Collections.emptyMap();
        ReentrantLock reentrantLock = mergeProcessor.getReentrantLock(requestId);

        return null;
    }
}
