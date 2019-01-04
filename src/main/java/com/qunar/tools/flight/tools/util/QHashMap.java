package com.qunar.tools.flight.tools.util;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.qunar.tools.flight.tools.util.QHashMap.Node.hash;

/**
 * @author jiabin.niu
 * @date 2018.12
 */
public class QHashMap<K, V> {


    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    transient Node<K, V>[] table;
    /**
     * 负载因子
     */
    final float loadFactor;
    /**
     * capacity * loadFactor
     */
    int threshold;

    public QHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }


    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * @param hash         hash for key
     * @param key          the key
     * @param value        the value to put
     * @param onlyIfAbsent if true don't change existing value
     * @param evict
     * @return
     */
    private V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {

        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        //第一次put
        if ((tab = table) == null || (n = tab.length) == 0) {
            //这里n一定是2的次方数
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = newNode(hash, key, value, null);
        }

        return null;
    }

    /**
     * 新建链表节点
     *
     * @param hash
     * @param key
     * @param value
     * @param next
     * @return
     */
    private Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    final Node<K, V>[] resize() {
        Node<K, V>[] oldTable = table;
        int oldCapacity = (oldTable == null) ? 0 : oldTable.length;
        int oldThreshold = threshold;
        /**
         * 新的capacity 和 新的 threshold
         */
        int newCap = 0, newThr = 0;
        /**
         * 第一次resize 采用默认的初始化方式(原来的容量是0 and 原来的临界值是0), 需要初始化设置容量和临界值
         */
        if (oldCapacity == 0 && oldThreshold == 0) {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
        /**
         * 原容量大于0 （说明不是第一resize，或者是第一次resize，但是初始化容量不为0）
         */
        else if (oldCapacity > 0) {
            if (oldCapacity >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTable;
            }
            //正常扩容的代码
            else if ((newCap = oldCapacity << 1) < MAXIMUM_CAPACITY &&
                    oldCapacity >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThreshold << 1;
            }
        }
        //只初始化了threshold  而Capacity的初始化为0
        else if (oldCapacity == 0 && oldThreshold > 0) {
            newCap = oldThreshold;
        }
        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        if (oldTable != null) {
            for (int j = 0; j < oldCapacity; ++j) {
                Node<K, V> e;
                if ((e = oldTable[j]) != null) {
                    oldTable[j] = null;
                    if (e.next == null) {
                        //hash & 1111   如果节点后面没有其它节点，则此节点再新tab的位置，不发生变化
                        newTab[e.hash & (newCap - 1)] = e;
                    }
                    //如果后面有节点 , 并且是红黑树节点
                    else if (e instanceof TreeNode) {
                        //some operation
                    }
                    //正常的链表节点
                    else {
                        /**
                         * 这里lo hi　指的是low 和　high 由于扩大了两倍　low　是指原来的位置　high　是指
                         */
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;

                        do {
                            //下一个节点
                            next = e.next;
                            //hash & 1000  要么等于0 要么不等于0
                            //如果等于0　　
                            if ((e.hash & oldCapacity) == 0) {
                                /**
                                 *    开始的时候
                                 * 　　hash
                                 *    node1  --->  node2  --->  node3
                                 *
                                 *
                                 *
                                 */
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                if (hiTail == null) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCapacity] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    /**
     * HashMap新节点
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements Map.Entry<K, V> {
        /**
         * hash定义其值不能被改变
         */
        final int hash;
        /**
         * Key的值被定义后不能被改变
         */
        final K key;
        V value;
        /**
         * 下一个节点
         */
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }


        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }

        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
    }
}
