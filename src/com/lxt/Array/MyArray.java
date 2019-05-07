package com.lxt.Array;

import java.io.Serializable;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArray<E> implements Cloneable, Serializable, RandomAccess {

    transient Object[] elementData;
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};
    /**
     * 集合中元素的数量
     */
    private int size;

    /**
     * 无参构造函数
     */
    public MyArray() {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }
    //指定容量大小构造函数
    //指定初始集合构造行数

    /**
     * add
     */
    public boolean add(E e) {
        //判断数组是否需要扩容 现在需要的最小的数组容量size+1
        ensureCapacityEnough(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityEnough(int miniCapacity) {
        if (miniCapacity - elementData.length > 0) {
            //需要扩容
            grow(miniCapacity);
        }

    }

    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int miniCapacity) {
        int oldCapacity = elementData.length;
        // 新容量 = 旧容量 + 旧容量>>1  15=10+5
        int newCapacity = oldCapacity + oldCapacity >> 1;

        if (newCapacity - oldCapacity < 0) {
            newCapacity = oldCapacity;
        }
        if (newCapacity - MAX_SIZE > 0) {
            newCapacity = MAX_SIZE;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


}
