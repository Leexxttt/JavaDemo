package com.lxt.Map;

public interface MyCollection<E> extends MyIterable<E>{

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    @Override
    MyIterator<E> iterator();

    Object[] toArray();

    //TODO ???
    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(MyCollection<?> c);

    boolean addAll(MyCollection<? extends E> c);

    boolean removeAll(MyCollection<?> c);

    boolean retainAll(MyCollection<?> c);

    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
