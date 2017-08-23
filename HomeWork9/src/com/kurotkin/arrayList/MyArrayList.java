package com.kurotkin.arrayList;

import com.kurotkin.Lists;

/**
 * Created by Vitaly Kurotkin on 17.08.2017.
 */
public class MyArrayList<T> implements Lists<T> {
    private T array[];
    private int size;

    public MyArrayList() {
        clear();
    }

    @Override
    public void add(T value) {
        int arrSize = array.length;
        if(arrSize < (size + 1)) {
            int newSize = arrSize * 3 / 2 + 1;
            T temp[] = (T[]) new Object[arrSize];
            System.arraycopy(array, 0, temp, 0, arrSize);
            array = (T[]) new Object[newSize];
            System.arraycopy(temp, 0, array, 0, arrSize);
        }
        array[size++] = value;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;

        int arrSize = array.length;
        if(arrSize > size * 3) {
            int newSize = size * 3 / 2 + 1;
            T temp[] = (T[]) new Object[arrSize];
            System.arraycopy(array, 0, temp, 0, arrSize);
            array = (T[]) new Object[newSize];
            System.arraycopy(temp, 0, array, 0, arrSize);
        }
    }

    @Override
    public void clear() {
        array = (T[]) new Object[3];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public T get(int index) {
        return array[index];
    }
}
