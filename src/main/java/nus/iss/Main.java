package nus.iss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++){
//                    System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
//                }
//            }
//        });
//        thread1.start();

        MyRunnableImplementation RI = new MyRunnableImplementation("Task1");
        MyRunnableImplementation RI2 = new MyRunnableImplementation("Task2");
        MyRunnableImplementation RI3 = new MyRunnableImplementation("Task3");
        MyRunnableImplementation RI4 = new MyRunnableImplementation("Task4");
        MyRunnableImplementation RI5 = new MyRunnableImplementation("Task5");

//        Thread thread2 = new Thread(RI);
//        thread2.start();
//
//        Thread thread3 = new Thread(RI);
//        thread3.start();

        ExecutorService ES = Executors.newCachedThreadPool();
        ES.execute(RI);
        ES.execute(RI2);
        ES.execute(RI3);
        ES.execute(RI4);
        ES.execute(RI5);
        ES.shutdown();
    }
}