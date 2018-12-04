package com.lxt.Enum;

public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private int code;

    private SeasonEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
