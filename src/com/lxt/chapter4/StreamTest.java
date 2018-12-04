package com.lxt.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH) );
        List<String> collect = menu.stream().
                filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                }).
                map(d -> {
                    System.out.println("maping " + d.getName());
                    return d.getName();
                }).
                limit(3).
                collect(Collectors.toList());
        System.out.println(collect);

        /**
         * 获取每个单词的长度
         */
        List<String> words = Arrays.asList("Java8", "Lambda", "In", "Action");
        List<Integer> collect1 = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        /**
         * 获取每道菜名的长度
         */
        List<Integer> collect2 = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        /**
         * 给定单词["Hello","World"] 返回["H,e,l,o,w,o,r,l,d....."]
         */
        List<String> hellos = Arrays.asList("Hello", "World");
        List<String[]> collect3 = hellos.stream()
                .map(item -> item.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("====================="+collect3);

        String[] arrayOfWords = {"Goodbye","World"};
        Stream<String> streamofWords = Arrays.stream(arrayOfWords);
        List<Stream<String>> collect4 = hellos.stream()
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> collect5 = hellos.stream()
                .map(m -> m.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());


        System.out.println("###############"+collect5);


    }
}
