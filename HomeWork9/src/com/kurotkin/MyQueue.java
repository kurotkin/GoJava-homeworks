package com.kurotkin;

/**
 * Created by Vitaly Kurotkin on 22.08.2017.
 */
public class MyQueue<T> extends MyLinkedList<T> implements Lists<T> {

    public T peek() {
        return getNode(0).item;
    }

    public T poll() {
        T nodeVal = getNode(0).item;
        remove(0);
        return nodeVal;
    }

}
