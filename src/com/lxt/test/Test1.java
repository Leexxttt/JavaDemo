package com.lxt.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("12345");
        list.add("2222123");
        list.add("1117890");
        if(list.contains(String.valueOf(2222123))){
            System.out.println("sss");
        }
    }
}
