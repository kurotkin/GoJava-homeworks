package com.kurotkin;

import java.util.concurrent.Semaphore;

public class Th {
    public final static Semaphore semaphore = new Semaphore(4, true);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i <= 8; i++){
            new Thread(new Peop(i)).start();
            Thread.sleep(5);
        }
    }

    public static class Peop implements Runnable{
        private int peopleNumber;

        public Peop(int peopleNumber) {
            this.peopleNumber = peopleNumber;
        }

        @Override
        public void run() {
            try {

                if (!semaphore.tryAcquire()){
                    System.out.println(peopleNumber + " пришел ко входу в библиотеку");
                    System.out.println(peopleNumber + " ждет у входа");
                    System.out.println(peopleNumber + " вошел и читает книгу");
                    Thread.sleep(3000);
                    System.out.println(peopleNumber + " вышел из библиотеки");
                    semaphore.release();
                } else {
                    System.out.println(peopleNumber + " пришел ко входу в библиотеку");
                    System.out.println(peopleNumber + " вошел и читает книгу");
                    Thread.sleep(3000);
                    System.out.println(peopleNumber + " вышел из библиотеки");
                    semaphore.release();
                }

                //semaphore.acquire();
//                System.out.println(peopleNumber + " вошел и читает книгу");
//                Thread.sleep(3000);
//                System.out.println(peopleNumber + " вышел из библиотеки");
//                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
