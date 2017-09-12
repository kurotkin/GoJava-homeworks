package com.kurotkin;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Vitaly on 08.09.2017.
 */
public class People implements Runnable{
    private int peopleNumber;
    private final Random random = new Random();

    public People(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @Override
    public void run() {
        comeIn();
        try {

            System.out.println("В библиотеке " + Library.SEMAPHORE.getQueueLength());
            Library.SEMAPHORE.acquire();

            //inDoor();
            System.out.println("[" + peopleNumber + "] вошел в библиотеку");
            readBook();

            //outDoor();
            System.out.println("[" + peopleNumber + "] вышел из библиотеки ");
            Library.SEMAPHORE.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void comeIn(){
        if (Library.SEMAPHORE.tryAcquire()){
            System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку");
        } else {
            System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку и ждет у входа");
                    //"[" + peopleNumber + "] ждет у входа в библиотеку");
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
