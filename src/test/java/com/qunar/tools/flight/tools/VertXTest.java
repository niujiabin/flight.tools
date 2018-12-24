package com.qunar.tools.flight.tools;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by jiabin.niu on 2018.11.24 15:10
 */
public class VertXTest {

    private static int port = 9001;

    public static void main(String[] args) {

        //当创建Vertx对象时可以指定参数
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        vertx.createHttpServer()
                .requestHandler(httpServerRequest -> {

                });

    }
}
