package com.lxt.Java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TestLambda {

    @Test
    public void test1(){
        //匿名内部类
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        TreeSet<String> set2 = new TreeSet<>((o1,o2)->Integer.compare(o1.length(),o2.length()));

    }
}
