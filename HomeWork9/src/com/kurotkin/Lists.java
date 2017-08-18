package com.kurotkin;

/**
 * Created by Vitaly Kurotkin on 17.08.2017.
 */
public interface Lists<T> {
    public void add (T value);
    public void remove(int index);
    public void clear();
    public int size();
}
