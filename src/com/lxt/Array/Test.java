package com.lxt.Array;


import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
//        MyArray<String> arr = new MyArray<>();
//        arr.add("li");
//        arr.add("sun");
//        arr.add("wang");
//        System.out.println(arr.toString());
//        String remove = arr.remove(0);
//        System.out.println(arr);
//        System.out.println(arr.contains("sun"));
//        Object[] objects = arr.toArray();
//        System.out.println(objects);
//        System.out.println("----------------------");
//        MyIterator<String> iterator1 = arr.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }

        ArrayList<String> list = new ArrayList<String>();
        list.add("li");
        list.add("sun");
        list.add("wang");
        Iterator<String> iterator = list.iterator();
        for (String s : list) {
            list.remove("sun");
        }

        /**
         *  Iterator var2 = var1.iterator();
         *
         *         while(var2.hasNext()) {
         *             String var3 = (String)var2.next();
         *             var1.remove("sun");
         *         }
         */
    }

}
