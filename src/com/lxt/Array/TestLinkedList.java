package com.lxt.Array;

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
//        LinkedList<String> list = new LinkedList<>();

//        list.add("11");
//        list.add("22");
//        list.add("33");
//        list.add("44");
//        list.add("55");
//        list.add(2, "66");
//
//        String remove = list.remove();
//        System.out.println(list + "-------------" + remove);
//        String pop = list.pop();
//        System.out.println(list + "------------" + pop);
//        String poll = list.poll();
//        System.out.println(list + "-----------" + poll);
//        String peek = list.peek();
//        System.out.println(list + "-------------" + peek);
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add(0, "66");
        list.add(1, "77");
        list.add(0, "88");


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
