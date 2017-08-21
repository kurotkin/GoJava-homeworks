package com.kurotkin;

import java.util.LinkedList;

/**
 * Created by Vitaly Kurotkin on 17.08.2017.
 */
public class MyLinkedList<T> implements Lists<T> {
    private MyNode<T> first;
    private MyNode<T> last;
    private int size = 0;

    @Override
    public void add(T value) {
        MyNode<T> node;
        if(first.equals(null)){
            node = new MyNode<>(value, null, null);
            first = node;
            last = node;
            size++;
        } else {
            node = new MyNode<>(value, null, last);
            last.next = node;
            last = node;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if(index == 0) {
            MyNode<T> node = first.next;
            node.prev = null;
            first.next = null;
            first.item = null;
            first = null;
            first = node;
        } else if(index == size) {

        }

        for (int i = 0; i < index; i++) {
            node = node.next;
            if(node == null)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size());
        }

    }

    @Override
    public void clear() {
        MyNode<T> iterator = first;
        while (iterator != null){
            if(iterator.next != null){
                iterator = iterator.next;
                iterator.prev.item = null;
                iterator.prev.prev = null;
                iterator.prev.next = null;
                iterator.prev = null;
            } else {
                iterator.item = null;
                iterator.prev = null;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    public T get(int index) {
        MyNode<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if(node == null)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size());
        }
        return (T) node;
    }
}
