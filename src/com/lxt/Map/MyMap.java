package com.lxt.Map;


import java.util.Collection;
import java.util.Set;

public interface MyMap<K,V> {
    /**
     * Map中键值对的个数，如果Map中键值对的个数超过Integer的最大值(Integer.MAX_VALUE),那么久返回Integer.MAX_VALUE
     */
    int size();
    /**
     * 判断map中是否有键值对
     */
    boolean isEmpty();
    /**
     *在Map中对于给定的key有一个对应的 返回true
     * @param key
     * @return 在Map中有对应的key返回true
     * @throws ClassCastException key的类型不当的类型
     * @throws NullPointerException key为null 但是当前map不允许key为null
     */
    boolean containsKey(Object key);
    /**
     * map中至少有一个key
     */
    boolean containsValue(Object value);
    /**
     *根据key 获取Value
     * 如果map允许null为Value 当返回值为null的时候不一定是Map中不存在，也有可能是key本来对应的值就是value,这两种情况可以用containsKey()来区分
     */
    V get(Object key);
    /**
     * 新增
     */
    V put(K key,V value);

    /**
     * 根据key值移除元素
     * @param key
     * @return
     */
    V remove(Object key);

    /**
     * 批量添加
     * @param m
     */
    void putAll(MyMap<? extends K,? extends V> m);

    /**
     * 清空Map中元素
     */
    void clear();

    /**
     * 获取map中的key集合
     * @return
     */
    Set<K> keySet();

    /**
     * 获取map中的value集合
     * @return
     */
    Collection<V> values();

    MySet<MyEntry<K, V>> entrySet();

    /**
     * 用来表示map中一组键值对的
     * @param <K>
     * @param <V>
     */

    interface MyEntry<K,V>{
        /**
         * 获取key
         * @return
         */
        K getKey();
        /**
         * 获取value
         */
        V getValue();
        /**
         * 设置value
         */
        V setValue(V value);

        @Override
        boolean equals(Object o);
        @Override
        int hashCode();
    }

    @Override
    boolean equals(Object o);
    @Override
    int hashCode();

}
