package com.lxt.Map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {

        Map<String,String> testMap = new HashMap<>();

        testMap.put("first","Hello");
        testMap.put("second","World");
        testMap.put("third","hahaha");

        /**
         *  构造方法 public HashMap(int initialCapacity(初始容量), float loadFactor(负载系数))
         *  1：如果初始容量小于0 报错
         *  2：static final int MAXIMUM_CAPACITY = 1 << 30; 初始容量大于 MAX 则初始容量为MAX
         *  3:负载系数小于等于0或者not a number 报错
         *  4：this.loadFactor = loadFactor 给负载系统赋值
         *  tableSizeFor方法保证函数返回值是大于等于给定参数initialCapacity最小的2的幂次方的值
         *  假设 initialCapacity=20 那么经过tableSizeFor方法返回的就是32 2^5
         *  this.threshold = tableSizeFor(initialCapacity)
         *
         *
         *
         */





    }

}
