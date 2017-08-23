package com.kurotkin.myHashMap;

/**
 * Created by Vitaly Kurotkin on 22.08.2017.
 */
public class MyNodeKV<T,K> {
    public T key;
    public K value;
    public MyNodeKV<T,K> next;

    public MyNodeKV(T key, K value, MyNodeKV<T, K> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
