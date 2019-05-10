package com.lxt.Array;

import java.util.NoSuchElementException;

/**
 * LinkedList 增删改查
 *
 * @param <E>
 */
public class MyLinkedList<E> {

    private Node<E> last;
    private Node<E> first;
    private int size;
    private int modeCount;

    public boolean add(E element) {
        linkLast(element);
        return true;
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(index, element);
        }

    }

    private void linkBefore(int index, E element) {
        Node<E> node = node(index);
        Node<E> prevNode = node.prev;
        Node<E> newNode = new Node<>(prevNode, element, node);
        if (prevNode == null) {
            first = newNode;
        } else {
            prevNode.next = newNode;
        }
        node.prev = newNode;
        size++;
        modeCount++;
    }

    private void linkLast(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modeCount++;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {

        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        modeCount++;
        size--;
        return unLinkFirst(f);
    }

    private E unLinkFirst(Node<E> n) {
        Node<E> next = n.next;
        E element = n.item;
        n.item = null;
        n.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        return element;
    }


    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f;
        } else {
            Node<E> l = last;
            for (int i = size - 1; i > index; i--) {
                l = l.prev;
            }
            return l;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}
