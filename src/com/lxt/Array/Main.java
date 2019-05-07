package com.lxt.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public void test(){
        String[] sArray = new String[]{"sun","xu"};
        /**
         * 构造函数
         */
        ArrayList<String> list =new ArrayList<String>();
        //实现



        //指定容量大小
        ArrayList<String> list2 = new ArrayList<>(10);
        //指定数组
        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList(sArray));






        list.add("Li");
        list.add(1,"wang");
        list.addAll(Arrays.asList(sArray));
        list.addAll(3,Arrays.asList(sArray));
        System.out.println("---------------------------------");
        Object clone = list.clone();
        list.clear();
        boolean result = list.contains("sun");
        System.out.println(result);
        list.ensureCapacity(10);
        list.forEach(item-> System.out.println(item));
        String s = list.get(1);
        System.out.println(s);
        int index = list.indexOf("li");
        System.out.println(index);
        boolean empty = list.isEmpty();
        System.out.println(empty);
        Iterator<String> iterator = list.iterator();
        int lastIndex = list.lastIndexOf("sun");
        System.out.println(lastIndex);
        ListIterator<String> listIterator = list.listIterator();

        ListIterator<String> listIteratorIndex = list.listIterator(1);
        boolean removeResult = list.remove("sun");
        System.out.println(removeResult);
        String remove = list.remove(0);
        boolean b = list.removeAll(Arrays.asList(sArray));

//        list.removeIf()
        //list.replaceAll();
        //list.retainAll();
        //list.set();
        int size = list.size();
        list.sort((o1,o2)->o1.compareTo(o2));
        Object[] objects = list.toArray();
        //list.toArray(String[] as);

    }
}
