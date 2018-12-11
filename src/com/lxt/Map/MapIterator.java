package com.lxt.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 遍历Map的几种方式
 */
public class MapIterator {
    public static Map<String,Integer> map =new HashMap<>();
    static {
        map.put("li",12);
        map.put("sun",13);
        map.put("zhu",18);
    }

    public static void main(String[] args) {
        //1.
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }
        System.out.println("============================");
        //2.在只需要key 或者Value 时候使用方便 效率比entrySet略好
        for(String key:map.keySet()){
            System.out.println("key="+key);
        }
        for(Integer value:map.values()){
            System.out.println("value="+value);
        }
        System.out.println("============================");
        //3.1 Iterator 使用泛型 for-each是在jdk1.5中引入 之前的版本遍历map的唯一方式就是通过Iterator 且可以实现remove操作
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("key="+next.getKey()+" value="+next.getValue());
        }
        //3.2 不使用泛型
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry next = (Map.Entry)iterator1.next();
            String key = (String)next.getKey();
            Integer value = (Integer)next.getValue();
            System.out.println("key="+key+" value="+value);
        }
        System.out.println("============================");
        //4 通过键找值 效率低
        for(String key:map.keySet()){
            System.out.println("key="+key+" value="+map.get(key));
        }
    }
}
