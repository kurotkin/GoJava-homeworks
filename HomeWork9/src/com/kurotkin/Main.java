package com.kurotkin;

public class Main {

    public static void main(String[] args) {
	    MyArrayList<String> list = new MyArrayList<>();
	    // Добавляем
	    for(int i = 100; i <= 200 ; i += 1){
	        list.add(Integer.toString(i));
        }
        // Удаляем
        for(int i = 0; i < list.size() ; i++){
	        if(i%2 != 0)
	            list.remove(i);
        }
        // Выводим на экран
        for(int i = 0; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
    }
}
