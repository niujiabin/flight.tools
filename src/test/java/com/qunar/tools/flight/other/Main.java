package com.qunar.tools.flight.other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by jiabin.niu on 2018.12.06 14:08
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "jiabin.niu";
            }
        };

        FutureTask futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();

        Callable callable1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "niujiabin";
            }
        };
        FutureTask futureTask1 = new FutureTask<String>(callable1);
        new Thread(futureTask1).start();

        System.out.println(futureTask.get());
        System.out.println(futureTask1.get());

    }
}
