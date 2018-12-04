package com.lxt.Enum;

/**
 * javac  javap -c
 */
public enum GenderEnum {
    MAN(1), WOMAN(2);

    private int code;

    private GenderEnum(int code) {
        this.code = code;
    }
}
