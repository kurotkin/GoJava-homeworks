package com.kurotkin;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by Vitaly Kurotkin on 18.09.2017.
 */
public class ArrayThreadCalc {
    private static final int size = 80_000_000;
    private static final Scanner scanner = new Scanner(System.in);
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = createArray(size);
        System.out.println("Создан массив из " + arr.length + " элементов");
        System.out.print("Введите количество подсчетов: ");
        int N = scanner.nextInt();
        for(int i = 1; i <= N; i++){
            System.out.print("Режим Thread.      Расчет " + i + " результат:  ");
            multiThread(arr);
            System.out.print("Режим Thread Pool. Расчет " + i + " результат:  ");
            oneThreadPool(arr);
            System.out.println();
        }
        threadPool.shutdown();
    }

    private static int[] createArray(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i ++)
            arr[i] = i;
        return arr;
    }

    private static void multiThread(int[] arr) throws ExecutionException, InterruptedException{
        long time = System.currentTimeMillis();

        FutureTask<Double>[] tasks = new FutureTask[4];
        int step = size / tasks.length;
        for (int i = 0; i < tasks.length; i++){
            int to = (i + 1) * step;
            int from = to - step;
            if(i == (tasks.length-1)){
                to = size;
            }
            tasks[i] = new FutureTask<Double>(new oneThread(arr,from, to));
            new Thread(tasks[i]).start();
        }

        double result = 0;
        for (FutureTask t : tasks){
            result += (double)t.get();
        }
        time = System.currentTimeMillis() - time;
        System.out.println(result + " (выполнено за " + time + " ms)");
    }

    private static void oneThreadPool(int[] arr) throws ExecutionException, InterruptedException{
        long time = System.currentTimeMillis();

        FutureTask<Double>[] tasks = new FutureTask[4];
        int step = size / tasks.length;
        for (int i = 0; i < tasks.length; i++){
            int to = (i + 1) * step;
            int from = to - step;
            if(i == (tasks.length-1)){
                to = size;
            }
            tasks[i] = new FutureTask<Double>(new oneThread(arr,from, to));
            threadPool.submit(tasks[i]);
        }

        double result = 0;
        for (FutureTask t : tasks){
            result += (double)t.get();
        }
        time = System.currentTimeMillis() - time;
        System.out.println(result + " (выполнено за " + time + " ms)");
    }

    private static class oneThread implements Callable{
        int[] arr;
        int from, to;

        public oneThread(int[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }

        @Override
        public Double call() throws Exception {
            double resilt = 0.0;
            for(int i = from; i < to; i++){
                resilt += (Math.sin((double)arr[i]) + Math.cos((double)arr[i]));
            }
            return resilt;
        }
    }

}
