package com.kurotkin.myHashMap;

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
        MyNodeKV<T,K> node = getNode(key);
        MyNodeKV<T,K> nodePrev = getPrevNode(key);

        if (nodePrev == null){
            first = node.next;
            node.next = null;
            node.key = null;
            node.value = null;
            size--;
        } else if(node.next == null) {
            nodePrev.next = null;
            last = nodePrev;
            node.key = null;
            node.value = null;
            size--;
        } else {
            nodePrev.next = node.next;
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

    protected MyNodeKV<T,K> getPrevNode(T key){
        MyNodeKV<T,K> iterator = first;
        while (iterator != null){
            if(iterator.next != null && iterator.next.key.equals(key))
                return iterator;
            iterator = iterator.next;
        }
        return null;
    }
}
