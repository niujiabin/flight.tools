package com.qunar.tools.flight.tools.util;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author : jiabin.niu
 **/
public class QArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E> {

    /**
     * 存储数组的元素
     */
    private Object[] items;

    private ReentrantLock lock;

    private final Condition notEmpty;

    private final Condition notFull;

    /**
     * 当前队列大小
     */
    private int count;
    private int putIndex;

    public QArrayBlockingQueue(int capacity) {
        items = new Object[capacity];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                notFull.await();
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        return null;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    /**
     * 如果能添加到队列 返回true，不能添加到队列直接返回false
     *
     * @param e
     * @return
     */
    @Override
    public boolean offer(E e) {
        //使用一个不可变的引用 指向lock，保证本次offer操作的lock不会发生改变
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length) {
                return false;
            }
            //队列没有满直接入队  肯定返回成功
            enqueue(e);
            return true;
        } catch (Exception exception) {

        } finally {
            lock.unlock();
        }

        return false;
    }

    private void enqueue(E e) {
        final Object[] items = this.items;
        items[putIndex] = e;
        //这里类似使用数组实现一个环形队列
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        //可以放入元素 说明队列非空
        notEmpty.signal();
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }


    /**
     * 如果添加失败 直接抛出异常
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        return super.add(e);
    }
}
