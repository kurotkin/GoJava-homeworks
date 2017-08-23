package com.kurotkin.linkedList;

import com.kurotkin.Lists;
import com.kurotkin.linkedList.MyNode;

/**
 * Created by Vitaly Kurotkin on 17.08.2017.
 */
public class MyLinkedList<T> implements Lists<T> {
    private MyNode<T> first = null;
    private MyNode<T> last = null;
    private int size = 0;

    @Override
    public void add(T value) {
        MyNode<T> node;
        if(first == null){
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
            if(size == 1) {
                clear();
                size--;
            } else if (size == 2) {
                last.prev = null;
                first.next = null;
                first.item = null;
                first = last;
                size--;
            } else {
                MyNode<T> nodeFirst = getNode(index + 1);
                first.next = null;
                first.item = null;
                nodeFirst.prev = null;
                first = nodeFirst;
                size--;
            }
        } else if (index == (size-1)) {
            if (size == 2) {
                first.next = null;
                last.prev = null;
                last.item = null;
                last = first;
                size--;
            } else {
                MyNode<T> nodeLast= getNode(size - 1);
                last.prev = null;
                last.item = null;
                nodeLast.next = null;
                last = nodeLast;
                size--;
            }
        } else {
            MyNode<T> node = getNode(index);
            MyNode<T> nodePrev = node.prev;
            MyNode<T> nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            node.prev = null;
            node.next = null;
            node.item = null;
            size--;
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
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public T get(int index) {
        return getNode(index).item;
    }

    protected MyNode<T> getNode(int index){
        MyNode<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if(node == null)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size());
        }
        return node;
    }
}
