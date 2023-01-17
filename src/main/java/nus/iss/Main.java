package nus.iss;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
                }
            }
        });
        thread1.start();

        MyRunnableImplementation RI = new MyRunnableImplementation();
        Thread thread2 = new Thread(RI);
        thread2.start();

        Thread thread3 = new Thread(RI);
        thread3.start();
    }
}