package com.kurotkin;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by Vitaly on 12.09.2017.
 */
public class Library {
    private static Scanner scanner = new Scanner(System.in);
    public final static Object door = new Object();
    public final static Semaphore SEMAPHORE = new Semaphore(3, true);

    public static void toLibrary(){
//        int peopleCount, maxAmount;
//        System.out.println("Введите количество людей: ");
//        peopleCount = scanner.nextInt();
//        System.out.println("Введите количество мест в библиотеке: ");
//        maxAmount = scanner.nextInt();

        System.out.println("Библиотека:");
        //SEMAPHORE = new Semaphore(3, true);
        for(int i = 1; i <= 5; i++){
            new Thread(new Peopl(i)).start();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Peopl implements Runnable{
        private int peopleNumber;
        private final Random random = new Random();

        public Peopl(int peopleNumber) {
            this.peopleNumber = peopleNumber;
        }

        @Override
        public void run() {
            if (SEMAPHORE.tryAcquire()){
                System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку");
            } else {
                System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку и ждет у входа");
                //"[" + peopleNumber + "] ждет у входа в библиотеку");
            }

            try {
                SEMAPHORE.acquire();
                System.out.println("[" + peopleNumber + "] вошел в библиотеку");

                long timeSleap = (long)(random.nextInt(5000-1000) + 1000);
                System.out.println("[" + peopleNumber + "] читает книгу " + timeSleap + " ms");
                Thread.sleep(timeSleap);

                System.out.println("[" + peopleNumber + "] вышел из библиотеки ");
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
