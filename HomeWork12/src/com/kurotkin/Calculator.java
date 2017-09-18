package com.kurotkin;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by Vitaly Kurotkin on 18.09.2017.
 */
public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("A = ");
        int A = scanner.nextInt();
        System.out.println("B = ");
        int B = scanner.nextInt();
        System.out.println("Введите номер операции:");
        System.out.println("\t1. +\n" +
                "\t2. -\n" +
                "\t3. *\n" +
                "\t4. /\n" +
                "\t5. %\n" +
                "\t6. ==\n" +
                "\t7. >\n" +
                "\t8. <\n" +
                "Номер операции:");
        int C = scanner.nextInt();
        Calc calc = new Calc(A, B, C);
        Object result = null;
        try {
            result = calc.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Результат: " + result);
    }

    private static class Calc implements Callable{
        private int A, B, C;

        public Calc(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }

        @Override
        public Object call() throws Exception {
            Thread.sleep(500);
            switch (C){
                case 1:
                    return A + B;
                case 2:
                    return A - B;
                case 3:
                    return A * B;
                case 4:
                    return A / B;
                case 5:
                    return A % B;
                case 6:
                    return A == B;
                case 7:
                    return A > B;
                case 8:
                    return A < B;
                default:
                    return null;
            }
        }
    }
}
