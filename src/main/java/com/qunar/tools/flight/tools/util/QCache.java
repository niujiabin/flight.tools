package com.qunar.tools.flight.tools.util;

import com.google.common.base.Supplier;
import com.google.common.cache.AbstractCache;

/**
 * Created by jiabin.niu on 2019.01.29 11:58
 */
public class QCache {


    static final Supplier<Test> CACHE_STATS_COUNTER =
            new Supplier<Test>() {
                @Override
                public Test get() {
                    return new Niu();
                }
            };


    public static void main(String[] args) {
        CACHE_STATS_COUNTER.get();
        CACHE_STATS_COUNTER.get();

    }
}
