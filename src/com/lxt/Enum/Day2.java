package com.lxt.Enum;

public enum Day2 {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五");

    private String desc;

    private Day2(String desc) {
        this.desc = desc;
    }
}
