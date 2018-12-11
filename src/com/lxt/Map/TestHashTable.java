package com.lxt.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestHashTable {

    public static void main(String[] args) {
        Map<String,Integer> table=new Hashtable<>();
        table.put("li",12);
        table.put("sun",14);

        Map<String,Integer> map =new HashMap<>();
        map.put("li",12);
        map.put("sun",13);
        map.put("zhu",18);
        map.put(null,12);
        map.put(null,null);
        Integer number = map.get(null);

        boolean b = map.containsKey(12);
        System.out.println(number);
    }
}
