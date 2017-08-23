package com.kurotkin.linkedList;

/**
 * Created by Vitaly Kurotkin on 21.08.2017.
 */
public class MyNode<T> {
    public T item;
    public MyNode<T> next;
    public MyNode<T> prev;

    public MyNode(T item, MyNode<T> next, MyNode<T> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
