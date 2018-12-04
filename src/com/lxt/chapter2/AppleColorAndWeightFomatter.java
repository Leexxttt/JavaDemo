package com.lxt.chapter2;

public class AppleColorAndWeightFomatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "Apple.weight:"+apple.getWeight()+"  Apple.color:"+apple.getColor();
    }
}
