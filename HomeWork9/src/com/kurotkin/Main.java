package com.kurotkin;

import com.kurotkin.arrayList.MyArrayList;
import com.kurotkin.linkedList.MyLinkedList;
import com.kurotkin.myHashMap.MyHashMap;
import com.kurotkin.queue.MyQueue;
import com.kurotkin.stack.MyStack;

public class Main<K> {

    public static void main(String[] args) {
        System.out.println("MyArrayList");
        MyArrayList<String> myArrayList = new MyArrayList<>();
	    // Добавляем
	    for(int i = 0; i <= 100 ; i += 1){
            myArrayList.add(Integer.toString(i));
        }
        // Удаляем
        for(int i = 0; i < myArrayList.size() ; i++){
	        if(i%3 != 0)
                myArrayList.remove(i);
        }
        // Выводим на экран
        for(int i = 0; i < myArrayList.size() ; i++){
            System.out.println(myArrayList.get(i));
        }
        System.out.println("_________________________");


        System.out.println("MyLinkedList");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        // Добавляем
        for(int i = 100; i <= 150 ; i += 1){
            myLinkedList.add(Integer.toString(i));
        }
        // Удаляем
        for(int i = 0; i < myLinkedList.size() ; i++){
            if(i%2 != 0)
                myLinkedList.remove(i);
        }
        // Выводим на экран
        for(int i = 0; i < myLinkedList.size() ; i++){
            System.out.println(myLinkedList.get(i));
        }
        System.out.println("_________________________");


        System.out.println("MyQueue");
        MyQueue<String> myQueue = new MyQueue<>();
        // Добавляем
        for(int i = 300; i <= 450 ; i += 1){
            myQueue.add(Integer.toString(i));
        }
        // Удаляем
        for(int i = 0; i < myQueue.size() ; i++){
            if(i%5 == 0)
                myQueue.remove(i);
        }

        // Выводим на экран
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println("_________________________");


        System.out.println("MyStack");
        MyStack<String> myStack = new MyStack<>();
        // Добавляем
        for(int i = 0; i <= 10 ; i += 1){
            myStack.push(Integer.toString(i));
        }

        // Выводим на экран
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println("_________________________");


        System.out.println("MyHashMap");
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        // Добавляем
        for(int i = 0; i < 10 ; i += 1){
            myHashMap.put(i, "Число = " + Integer.toString(i));
        }
        // Удаляем
        System.out.println("Размер коллекции = " + myHashMap.size());
        myHashMap.remove(5);
        myHashMap.remove(2);
        myHashMap.remove(8);
        System.out.println("Размер коллекции = " + myHashMap.size());
        // Выводим на экран
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(4));
        System.out.println(myHashMap.get(9));

    }

}
