package com.lxt.Array;

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list =new LinkedList<>();

        list.add("li");
        list.add("sun");
        list.add("wang");

        System.out.println(list.getFirst());
        System.out.println(list.get(1));


        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.add("su");
        System.out.println(list2.getFirst());


    }
}
