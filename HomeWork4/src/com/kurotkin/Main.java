package com.kurotkin;

public class Main {

    public static void main(String[] args) {
	    printNumbers(5);
        drawRectangle(9,7);
        drawRectangle(2);
        System.out.println(getMax(1, 2));
        printNumbersRecurs(5);
        System.out.println();
        drawRectangleRecurs(9,7);
    }

    /**
     * Задание 1
     * Написать функцию которая считает в консоли до числа Х.
     * Аргументы функции: число Х Например Х = 5. Вывод программы: 1 2 3 4 5
     */
    public static void printNumbers(int x){
        if (x < 1) throw new IllegalArgumentException("Значение 'x' должно быть больше 0, по факту x = " + x);
        for(int i = 1; i <= x; i++ )
            System.out.print(i + " ");
        System.out.println();
    }

    /**
     * Задание 2
     * Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+'
     * Аргументы функции: ширина прямугольника в символах, высота прямоугольника в символах
     * Например 3 на 2 Вывод программы: + + + + + +
     */
    public static void drawRectangle (int width, int height) {
        if (width < 1 || height < 1) throw new IllegalArgumentException("Значения 'width' и 'height' должны быть больше 0");
        while (height-- > 0) {
            for(int i = 1; i <= width; i++)
                System.out.print("+");
            System.out.println();
        }
    }

    /**
     * Задание 3
     * Перегрузить функцию drawRectangle (задание 2) таким образом, что бы она могла принимать на вход
     * только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами Например 2
     * Вывод программы: + + + + Например 3 Вывод программы: + + + + + + + + +
     */
    public static void drawRectangle (int width) {
        if (width < 1) throw new IllegalArgumentException("Значение 'width' должно быть больше 0");
        int height = width;
        while (height-- > 0) {
            for(int i = 1; i <= width; i++)
                System.out.print("+");
            System.out.println();
        }
    }

    /**
     * Задание 4
     * Написать функцию getMax которая принимает на вход два аргумента в виде чисел.
     * А возврыщает максимальное из этих двух. Так же, необходимо перегрузить эту функцию
     * для работы с разными числовыми типами переменных (int, float)
     */
    public static int getMax (int a, int b) {
        return (a > b) ? a : b;
    }

    public static float getMax (float a, float b) {
        return (a > b) ? a : b;
    }

    public static double getMax (double a, double b) {
        return (a > b) ? a : b;
    }

    /**
     * Задание 5
     * Решить задачу 1, без использования циклов. Использовав рекурсию.
     */
    public static void printNumbersRecurs(int x){
        if (x < 1) throw new IllegalArgumentException("Значение 'x' должно быть больше 0, по факту x = " + x);
        if (x == 1) {
            System.out.print(x + " ");
        } else {
            printNumbersRecurs(x - 1);
            System.out.print(x + " ");
        }
    }

    /**
     * Задание 6
     * Решить задачу 2, без использования циклов. Использовав рекурсию.
     */
    public static void drawRectangleRecurs (int width, int height) {
        if (width < 1 || height < 1) throw new IllegalArgumentException("Значения 'width' и 'height' должны быть больше 0");
        if(height == 1){
            if(width == 1) {
                System.out.print("+");
            } else {
                drawRectangleRecurs(width-1, height);
                System.out.print("+");
            }
        } else {
            drawRectangleRecurs (width, height - 1);
            System.out.println();
            drawRectangleRecurs (width, 1);
        }

    }
}
