package com.lxt.Java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestLambda {

    @Test
    public void test1() {
        //匿名内部类
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        TreeSet<String> set2 = new TreeSet<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    /**
     * 为什么要使用lambda 使用lambda表达式的好处
     * 下面的方法将list集合中数据元素的大写改成小写
     */
    public void test2() {
        List<String> names = new ArrayList<>();
        names.add("lISi");
        names.add("zhAngSan");
        List<String> newList = new ArrayList<>();
        for (String name : names) {
            newList.add(name.toLowerCase());
        }

        /**
         * lambda表达式的一般语法
         *
         * (Type param1,Type param2,Type param2) -> {
         *     do sonmething;
         *     return;
         * }
         */
        names.stream().map((name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        //当lambda参数只有一个的时候 可以省略小括号
        names.stream().map(name -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        //当lambda语句只有一条语句的时候 可以省略大括号，return和语句结尾的分号
        names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        //使用Method Reference ？？？？？
        names.stream().map(String :: toLowerCase).collect(Collectors.toList());
        //方法引用 构造器引用

    }


}
