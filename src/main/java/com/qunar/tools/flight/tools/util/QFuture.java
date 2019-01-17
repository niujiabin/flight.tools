package com.qunar.tools.flight.tools.util;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiabin.niu on 2019.01.04 16:39
 */
public class QFuture<V> implements RunnableFuture<V> {

    private static final String RESULT = "qunar";

    private static final int COMPLETING = 1;

    /**
     * 当前任务的状态
     */
    private volatile int state;

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /**
         * Callable　带有返回值　而且可以抛出异常
         */
        Callable<String> call = () -> {
            Thread.sleep(2000);
            return RESULT;
        };


        /**
         * 记忆要点　FutureTask
         * １.从Task关键字说明是一个任务，一个任务一定要实现Runnable接口,使其具有运行任务的能力
         * 2.从Future关键字马上就能看出来它实现了Future接口　这个接口具有查看任务是否完成　多长时间之内必须拿到结果的功能　　就像类一样　获取某个未来的结果
         */
        FutureTask<String> task = new FutureTask<>(call);
        new Thread(task).start();
        //这个任务不会执行 因为此时 FutureTask  不是NEW状态
        new Thread(task).start();

        String taskResult = task.get();
        System.out.println(taskResult);

        //这个任务不会执行 因为一个FutureTask一次只能一个任务
        new Thread(task).start();
        String taskResult1 = task.get();
        System.out.println(taskResult1);

    }

    /**
     * RunnableFuture的运行
     * 1 判断运行状态，如果该任务已经运行直接返回。或者通过CAS设置该任务的运行者为当前线程失败（说明其它线程已经运行了该任务）直接返回
     * 2 进入主流程 获取callable对象 ，如果callable对象存在且是NEW状态 继续运行
     * 3 定义一个临时的运行结果V result 调用callable.call执行线程
     * 4 线程运行完毕 设置结果值  如果期间线程出现异常，通过cas将当前当前运行状态设置为COMPLETING，
     * 如果设置成功，执行Unsafe.putOrderedInt插入StoreStore内存屏障，避免发生写操作重排序。 结果值为null
     * 当任务执行完的时候，需要获取还在等待执行任务的节点，并通过cas获取其机票吗每一个正在等待的线程，并执行unpark让他们重新从内核态转到用户态去运行，删除等待队列
     * 5 最后无论callable.call 是否执行成功，都要设置futuretasks的 runner为null，表示当前“未来任务”运行者设置为null
     * 6 判断当前状态值是否是中断
     */
    @Override
    public void run() {

    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        int s = state;
        //当前的任务并没有完成
        if (s <= COMPLETING) {
            s = awaitDone(false, 0L);
        }
        return null;
    }

    /**
     * 等待任务完成，或者放弃中断和超时的任务
     *
     * @param timed 是否启用超时时间
     * @param nanos 超时时间后放弃任务
     * @return
     */
    private int awaitDone(boolean timed, long nanos) throws InterruptedException {

        final long deadline = timed ? System.nanoTime() + nanos : 0L;
        WaitNode q = null;

        boolean queued = false;

        for (; ; ) {
            /**
             * 线程处于中断  放弃任务
             */
            if (Thread.interrupted()) {
                //removeWaiter(q);
                throw new InterruptedException();
            }

            int s = state;

            //已经完成
            if (s > COMPLETING) {
                if (q != null) {
                    q.thread = null;
                }
                return s;
            }

            //处于正在完成中的状态
            else if (s == COMPLETING) {
                //查一查作用
                Thread.yield();
            } else if (q == null) {
                q = new WaitNode();
            } else if (!queued) {
                //queued = UNSAFE.compareAndSwapObject(this, waiterOffset, q.next = waiters, q);
            }


        }
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    /**
     * 等待队列节点
     */
    static final class WaitNode {

        volatile Thread thread;
        volatile WaitNode next;

        WaitNode() {
            thread = Thread.currentThread();
        }

    }

    private static final sun.misc.Unsafe UNSAFE;

    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
