package com.lxt.object.compare;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return name + age;
    }

    @Override
    public int compareTo(Person person) {
        return age < person.age ? -1 : age == person.age ? 0 : 1;
    }
}
