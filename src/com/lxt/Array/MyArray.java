package com.lxt.Array;

import java.io.Serializable;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArray<E> implements Cloneable, Serializable, RandomAccess {

    transient Object[] elementData;
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

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
        if (elementData == DEFAULT_EMPTY_ELEMENTDATA) {
            miniCapacity = Math.max(miniCapacity, DEFAULT_CAPACITY);
        }
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
        if (newCapacity - miniCapacity < 0) {
            newCapacity = miniCapacity;
        }
        if (newCapacity - oldCapacity < 0) {
            newCapacity = oldCapacity;
        }
        if (newCapacity - MAX_SIZE > 0) {
            newCapacity = MAX_SIZE;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        //检验index是否越界
        rangeCheck(index);
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index + "");
        }
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        int numMoved = size - 1 - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[size - 1] = null;
        size--;
        return oldValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i == size - 1) {
                sb.append("]");
                break;
            }
            sb.append(",");
        }
        return sb.toString();
    }
}
