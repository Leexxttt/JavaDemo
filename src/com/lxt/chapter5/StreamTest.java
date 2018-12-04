package com.lxt.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> hellos = Arrays.asList("Hello", "World");

        List<String> collect5 = hellos.stream()
                .map(m -> m.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("###############"+collect5);
    }
}
