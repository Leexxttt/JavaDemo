package com.lxt.Array;


public class Test {
    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>();
        arr.add("li");
        arr.add("sun");
        arr.add("wang");
        System.out.println(arr.toString());
        String remove = arr.remove(0);
        System.out.println(arr);
        System.out.println(arr.contains("sun"));
        Object[] objects = arr.toArray();
        System.out.println(objects);
    }

}
