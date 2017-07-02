package com.kurotkin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Введите Ваше имя: ");
        String name = scanIn.nextLine();

        System.out.print("Место жительства: ");
        String location = scanIn.nextLine();

        System.out.print("Сколько Вам полных лет: ");
        while (!scanIn.hasNextInt()) {
            System.out.println("");
            System.out.print("Введите целое число: ");
            scanIn.nextLine();
        }
        int age = scanIn.nextInt();

        scanIn.nextLine();
        System.out.print("Введите Ваше хобби: ");
        String hobby = scanIn.nextLine();

        printSeparator();
        System.out.println("Имя: " + name);
        System.out.println("Город: " + location);
        System.out.println("Возраст: " + Integer.toString(age));
        System.out.println("Хобби: " + hobby);
        printSeparator();
        System.out.printf("Человек по имени %s живет в городе %s.\n", name, location);
        System.out.printf("Этому человеку %d лет и любит он заниматься %s.\n", age, hobby);
        printSeparator();
        System.out.print(name);
        System.out.println(" - имя");
        System.out.print(location);
        System.out.println(" - город");
        System.out.print(age);
        System.out.println(" - возраст");
        System.out.print(hobby);
        System.out.println(" - хобби");
        printSeparator();
    }

    public static void printSeparator(){
        System.out.println("----------------------------------");
    }

}
