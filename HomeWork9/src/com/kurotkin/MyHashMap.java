package com.kurotkin;

/**
 * Created by Vitaly Kurotkin on 22.08.2017.
 */
public class MyHashMap<T,K> {
    private MyNodeKV<T,K> first = null;
    private MyNodeKV<T,K> last = null;
    private int size = 0;

    public void put(T key, K value) {
        MyNodeKV<T,K> node;
        if(first == null){
            node = new MyNodeKV<>(key, value, null);
            first = node;
            last = node;
            size++;
        } else {
            node = new MyNodeKV<>(key, value, null);
            last.next = node;
            last = node;
            size++;
        }
    }

    public void remove(T key) {
        if(index == 0) {
            if(size == 1) {
                clear();
                size--;
            } else if (size == 2) {
                first.next = null;
                first.key = null;
                first.value = null;
                first = last;
                size--;
            } else {
                MyNodeKV<T,K> nodeFirst = getNode(1);
                first.next = null;
                first.key = null;
                first.value = null;
                first = nodeFirst;
                size--;
            }
        } else if (index == (size-1)) {
            if (size == 2) {
                first.next = null;
                last.next = null;
                last.key = null;
                last.value = null;
                last = first;
                size--;
            } else {
                MyNodeKV<T,K> nodeLast= getNode(size - 1);
                last.key = null;
                last.value = null;
                nodeLast.next = null;
                last = nodeLast;
                size--;
            }
        } else {
            MyNodeKV<T,K> node = getNode(index);
            MyNodeKV<T,K> nodePrev = getNode(index - 1);
            MyNodeKV<T,K> nodeNext = getNode(index - 1);
            nodePrev.next = nodeNext;
            node.next = null;
            node.key = null;
            node.value = null;
            size--;
        }
    }

    public void clear() {
        MyNodeKV<T,K> iterator = first;
        while (iterator != null){
            if(iterator.next != null){
                MyNodeKV<T,K> nextNode = iterator.next;
                iterator.value = null;
                iterator.key = null;
                iterator.next = null;
                iterator = nextNode;
            } else {
                iterator.value = null;
                iterator.key = null;
            }
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public K get(T key) {
        return getNode(key).value;
    }

    protected MyNodeKV<T,K> getNode(T key){
        MyNodeKV<T,K> iterator = first;
        while (iterator != null){
            if(iterator.key.equals(key))
                return iterator;
            iterator = iterator.next;
        }
        return null;
    }
}
