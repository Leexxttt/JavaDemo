package com.lxt.Map;

public interface MySet<E> extends MyCollection<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(MyCollection<?> c);

    boolean addAll(MyCollection<? extends E> c);

    boolean retainAll(MyCollection<?> c);

    boolean removeAll(MyCollection<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();
}
