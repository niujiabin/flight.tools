package com.qunar.tools.flight.tools.merge;


import com.qunar.tools.flight.tools.router.AgentBean;
import com.qunar.tools.flight.tools.router.RouterAggregationMessageBean;
import com.qunar.tools.flight.tools.router.RouterAggregationResult;
import com.qunar.tools.flight.tools.router.RouterSearchParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
public class MergeProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MergeProcessor.class);

    /**
     * 从原系统中取的参数
     */
    private static ThreadPoolExecutor mergePriceThreadPoolExecutor = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    });

    /**
     * 执行merge 处理
     *
     * @param queryId
     * @param routerAggregationBean
     */
    public void executeMerge(final String queryId, final RouterAggregationMessageBean routerAggregationBean) {

        logger.info("进入merge系统,queryId:{},RouterAggregationMessageBean:{}", queryId, routerAggregationBean);

        mergePriceThreadPoolExecutor.execute(new MergePriceTask(queryId , routerAggregationBean));

    }
}
