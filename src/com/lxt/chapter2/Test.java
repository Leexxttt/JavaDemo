package com.lxt.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
//        Apple red = new Apple("red", 120);
//        Apple blue = new Apple("blue", 100);
//        List<Apple> apples =new ArrayList<>();
//        apples.add(red);
//        apples.add(blue);

        List<Apple> apples = Arrays.asList(new Apple("red", 120), new Apple("blue", 100));

        prettyPrintApple(apples,new AppleColorAndWeightFomatter());
        prettyPrintApple(apples, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                return "Apple："+apple.getColor();
            }
        });

        List<Apple> filter = filter(apples, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println("------------");

    }
    public static void prettyPrintApple(List<Apple> appleList,AppleFormatter formatter){
        for(Apple apple:appleList){
            String accept = formatter.accept(apple);
            System.out.println(accept);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> returnList =new ArrayList<>();
        for(T t:list){
            if(p.test(t)){
                returnList.add(t);
            }
        }
        return returnList;
    }
}
