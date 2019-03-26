package com.lxt.Serializable;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -6012858069498899791L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name="+name+"   age="+age;
    }
}
