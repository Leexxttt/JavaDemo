package com.lxt.object.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(new Cat("li", 12), new Cat("sun", 1), new Cat("qian", 178));
        Collections.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge() > o2.getAge() ? 1 : o1.getAge() == o2.getAge() ? 0 : -1;
            }
        });
        System.out.println(cats);

    }

    @Test
    public void test(){
        List<Cat> cats = Arrays.asList(new Cat("li", 12), new Cat("sun", 1), new Cat("qian", 178));
        Collections.sort(cats,new MyComparator());
        System.out.println(cats);
    }

    class MyComparator implements Comparator<Cat>{

        @Override
        public int compare(Cat o1, Cat o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
}
