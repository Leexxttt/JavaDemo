package com.lxt.Map;

public class TestShiftOperation {

    public static void main(String[] args) {
        int i = 1;
        /**
         * i <<3 相当于 i*(2^1)*(2^1)*(2^1)
         */
        //System.out.println(i << 3);
        System.out.println(16 >>> 3);



        int cap = 20;
        int n = cap - 1;
//        n |= n >>> 1;
//        System.out.println("**********"+n);
        /** n=n|n >>> 2 | 二进制的或运算
         *
         *  3&5  则  & 同为1时为1 否则为0
         *  0011
         * &0101
         * =0001=1
         *
         * 3|5 则   | 同为0时为0 否则为1
         *  0011
         * |0101
         * =0111=7
         *
         *
         */
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int i1 = (n < 0) ? 1 : (n >= (i << 32)) ? (i << 32) : n + 1;
        System.out.println(i1);
    }
}
