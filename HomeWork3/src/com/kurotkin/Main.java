package com.kurotkin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введи размер массива A: ");
        int arraySize = scan.nextInt();
        scan.nextLine();
        int[] Arr = new int[arraySize];
        for (int i = 0; i < Arr.length; i++){
            System.out.printf("A[%d] = ", i);
            Arr[i] = scan.nextInt();
            scan.nextLine();
        }
        int maxArr = Integer.MIN_VALUE;
        int minArr = Integer.MAX_VALUE;
        int num5 = 0;
        for(int val : Arr) {
            if (val > maxArr)
                maxArr = val;
            if (val < minArr)
                minArr = val;
            if (val == 5)
                num5++;
        }
        System.out.println("Минимальное число в массиве: " + minArr);
        System.out.println("Максимальное число в массиве: " + maxArr);
        System.out.println("Число повторений числа \"5\": " + num5);
        int rf = 1;
        while (rf > 0) {
            rf = 0;
            for (int i = 0; i < (Arr.length - 1); i++){
                if(Arr[i] > Arr[i + 1]) {
                    int g = Arr[i];
                    Arr[i] = Arr[i + 1];
                    Arr[i + 1] = g;
                    rf++;
                }
            }
        }
        System.out.print("Отсортированный массив [ ");
        for(int k : Arr){
            System.out.print(k);
            System.out.print(" ");
        }
        System.out.println("]");

    }
}
