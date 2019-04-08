package com.lxt.object.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPersonComparable {

    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("li", 14));
        list.add(new Person("sun", 15));
        list.add(new Person("zhou", 189));
        list.add(new Person("wu", 1));
        list.add(new Person("zheng", 74));
        Collections.sort(list);
        System.out.println(list);
    }
}
