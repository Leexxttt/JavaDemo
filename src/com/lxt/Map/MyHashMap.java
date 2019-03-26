//package com.lxt.Map;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
//public class MyHashMap<K, V> extends MyAbstraMap<K, V> implements MyMap<K, V>, Cloneable, Serializable {
//
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//
//    float loadFactor = 0f;
//    /**
//     * resize之后的大小
//     */
//    int threshold;
//    /**
//     * 默认的负载因子的大小
//     */
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//    /**
//     * map中键值对的个数
//     */
//    transient int size;
//    /**
//     * hashmap的初始数组的大小16
//     */
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//
//    /**
//     * hash表的负载系数
//     */
//
//    /**
//     *
//     */
//    MyNode<K, V>[] table;
//
//    static class MyNode<K, V> implements MyMap.MyEntry<K, V> {
//        int hash;
//        K key;
//        V value;
//        MyNode<K, V> next;
//
//        MyNode(int hash, K key, V value, MyNode<K, V> next) {
//            this.hash = hash;
//            this.value = value;
//            this.value = value;
//            this.next = next;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public int hashCode() {
//            return Objects.hashCode(key) + Objects.hashCode(value);
//        }
//
//        public V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//    }
//
//    /**
//     * 构造方法1
//     *
//     * @param initialCapacity 初始容量大小
//     * @param loadFactor      负载因子
//     */
//    public MyHashMap(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0) {
//            throw new IllegalArgumentException("非法的参数" + initialCapacity);
//        }
//        if (initialCapacity > MAXIMUM_CAPACITY) {
//            initialCapacity = MAXIMUM_CAPACITY;
//        }
//        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
//            throw new IllegalArgumentException("非法的参数" + loadFactor);
//        }
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//
//    /**
//     * 构造方法2：只指定初始容量没有指定负载因子 使用默认的负载因子
//     */
//    public MyHashMap(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//
//    /**
//     * 构造方法3：啥都没有指定
//     */
//    public MyHashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//        //TODO 容量大小应该是在put的时候指定 待验证
//    }
//
//    /**
//     * 构造方法4：给定一个map
//     */
//    public MyHashMap(MyMap<? extends K, ? extends V> m) {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//        //将给定的map放入
//        putMapEntries(m, false);
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public V put(K key, V value) {
//
//    }
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
//        MyNode<K, V>[] tab;
//        MyNode<K, V> p;
//        int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0) {
//            n = (tab.resize()).length;
//        }
//
//
//    }
//
//    final MyNode<K, V>[] resize() {
//        MyNode<K, V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        //在构造函数中这个参数已经初始化好了
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        if (oldCap > 0) {
//            //数组已经声明好了 而且数组的大小已经不能再继续扩容了 直接返回原来的
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
//                newThr = oldThr << 1;
//            }
//        }else if(oldThr>0){
//            /**oldThr>0的情况：在构造函数的时候指定初始容量大小和负载因子 然后调用tableSizefor()获取大于等于这个初始大小差值最小的2的幂
//             * 这个2的幂就是这个Map的初始值大小
//             */
//            newCap=oldThr;
//        }else{
//            newCap=DEFAULT_INITIAL_CAPACITY;
//            newThr=(int)DEFAULT_LOAD_FACTOR*DEFAULT_INITIAL_CAPACITY; //12 不太明白
//        }
//        if(newThr==0){
//
//        }
//
//
//
//    }
//
//
//    /**
//     * ^ 异或 任何数跟0异或都是起本身  >>> 无符号右移16位
//     * <p>
//     * (h = key.hashCode()) ^ (h >>> 16) ：
//     * 高16位不变 ，低16位是高16位和低16位异或的结果
//     * 目的：
//     * 这个与HashMap中table的下标计算有关
//     * n = table.length;
//     * index = (n-1) & hash;
//     * 以为table的长度都是2的幂，因此index仅与hash值的低n位有关(此n非table.length,而是2的幂指数) hash值的高位都被与操作置位0
//     * 假设table.length=2^4=16
//     * h=hashCode() 1111 1111 1111 1111 1111 0000 1110 1010
//     * 计算hash:  h:1111 1111 1111 1111 1111 0000 1110 1010
//     * h>>>16:0000 0000 0000 0000 1111 1111 1111 1111
//     * _____________________________________________________
//     * 1111 1111 1111 1111 0000 1111 0001 0101
//     * index=(n-1) & hash;  16-1=15
//     * 0000 0000 0000 0000 0000 0000 0000 1111
//     * 1111 1111 1111 1111 0000 1111 0001 0101
//     * _____________________________________________________
//     * 0101 = 5
//     * 可以看到只有hash值的低4位参与了运算
//     * 这样很容易产生碰撞 所以讲高16位与低16位异或来减少这种影响 异或一下 不会造成因为高位没有参与下标的计算(table长度较小的时候)，从而引起碰撞
//     */
//    static final int hash(Object key) {
//        int h;
//        if (key == null) {
//            return 0;
//        } else {
//            return (h = key.hashCode()) ^ (h >>> 16);
//        }
//    }
//
//
//    //TODO
//    final void putMapEntries(MyMap<? extends K, ? extends V> m, boolean evict) {
//    }
//
//
//    /**
//     * 返回一个大于等于给定整数的且最接近给定整数的2的幂次方整数
//     * <p>
//     * 假定给定的cap是13 返回值是16
//     * 0000 1101
//     * Step1: n = 12 执行减1操作的目的在于 如果cap已经是2的幂，没有执行减1执行完几次无符号右移操作之后返回的将是cap的2倍
//     * Step2: n |= n >>> 1; >>>无符号右移  | 和 |=  表示：逻辑或 和 或等于
//     * 举个例子：
//     * 逻辑或|  逻辑或操作只有在都是0的时候才是0     1001|0110  结果是 1111
//     * 或等于|=   先逻辑或，结果再赋值给前面的变量  0000 1100  =12
//     * n>>>1 = 0000 0110
//     * 执行或等于  先执行逻辑或 然后将结果赋值给前面的变量
//     * 0000 1100
//     * 0000 0110
//     * <p>
//     * 0000 1110  =14  n=14
//     * Step3:n |= n >>> 2;
//     * 0000 0011
//     * 0000 1110
//     * 0000 1111 15  n=15
//     * <p>
//     * Step4: n |= n >>> 4;
//     * 0000 0000
//     * 0000 1111
//     * 0000 1111 n=15
//     * <p>
//     * Step5: n |= n >>> 8;
//     * 0000 0000
//     * 0000 1111
//     * 0000 1111 n=15
//     * <p>
//     * Step6: n |= n >>> 16;
//     * 0000 0000
//     * 0000 1111
//     * 0000 1111 n=15
//     * 牛逼啊 怎么想到的啊
//     */
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        if (n < 0) {
//            return 1;
//        } else {
//            if (n > MAXIMUM_CAPACITY) {
//                return MAXIMUM_CAPACITY;
//            } else {
//                return n + 1;
//            }
//        }
//
//    }
//
//    @Override
//    public Set<K> keySet() {
//        return null;
//    }
//
//    @Override
//    public Collection<V> values() {
//        return null;
//    }
//
//    @Override
//    public MySet<MyEntry<K, V>> entrySet() {
//        return null;
//    }
//
//}
