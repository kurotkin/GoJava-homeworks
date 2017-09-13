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
    public static Semaphore semaphore;
    public static int peopleCount, maxAmount, currentAmount;
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Введите количество людей: ");
        peopleCount = scanner.nextInt();
        System.out.println("Введите количество мест в библиотеке: ");
        maxAmount = scanner.nextInt();
        currentAmount = maxAmount;

        System.out.println("Библиотека:");
        semaphore = new Semaphore(maxAmount, true);

        for(int i = 1; i <= peopleCount; i++){
            new Thread(new People(i)).start();
            try {
                long timeSleap = (long)random.nextInt(300);
                Thread.sleep(timeSleap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class People implements Runnable{
        private int peopleNumber;


        public People(int peopleNumber) {
            this.peopleNumber = peopleNumber;
        }

        @Override
        public void run() {
            comeIn();
            try {
                Library.semaphore.acquire();
                currentAmount--;
                inDoor();
                System.out.println("[" + peopleNumber + "] вошел в библиотеку");
                readBook();
                outDoor();
                System.out.println("[" + peopleNumber + "] вышел из библиотеки ");
                Library.semaphore.release();
                currentAmount++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void comeIn(){
            if (currentAmount <= 0){
                System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку  \n" +
                        "[" + peopleNumber + "] ждет у входа в библиотеку");
            } else {
                System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку");
            }
        }

        private void readBook(){
            long timeSleap = (long)(random.nextInt(5000-1000) + 1000);
            System.out.println("[" + peopleNumber + "] читает книгу " + timeSleap + " ms");
            try {
                Thread.sleep(timeSleap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void inDoor(){
            synchronized (Library.door) {
                System.out.println("[" + peopleNumber + "] подошел к двери с улицы");
                System.out.println("[" + peopleNumber + "] проходит через дверь внутрь");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[" + peopleNumber + "] прошел через дверь внутрь");
            }
        }

        private void outDoor(){
            synchronized (Library.door) {
                System.out.println("[" + peopleNumber + "] подошел к двери изнутри");
                System.out.println("[" + peopleNumber + "] проходит через дверь наружу");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[" + peopleNumber + "] прошел через дверь наружу");
            }
        }

    }
}
