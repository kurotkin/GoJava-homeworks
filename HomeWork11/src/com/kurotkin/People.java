package com.kurotkin;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Vitaly on 08.09.2017.
 */
public class People implements Runnable{
    private int peopleNumber;
    private final Semaphore SEMAPHORE;
    final Random random = new Random();

    public People(int peopleNumber, Semaphore SEMAPHORE) {
        this.peopleNumber = peopleNumber;
        this.SEMAPHORE = SEMAPHORE;
    }

    @Override
    public void run() {
        if (SEMAPHORE.tryAcquire()){
            System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку");
        } else {
            System.out.println("[" + peopleNumber + "] пришел ко входу в библиотеку\n" +
                    "[" + peopleNumber + "] ждет у входа в библиотеку");
        }

        try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + peopleNumber + "] вошел в библиотеку");
        System.out.println("[" + peopleNumber + "] читает книгу ");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + peopleNumber + "] читает книгу ");
        SEMAPHORE.release();
    }
}
