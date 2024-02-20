package org.example;

public class Main2{

    public static void main(String[] args) throws InterruptedException{

        // Create a subclass of Thread
        MyThread1 thread1 = new MyThread1();

        //or

        //implement Runnable interface and pass instance as an argument to Thread()
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        Thread thread3 = new Thread(new MyRunnable());


        //thread1.setDaemon(true);
        //thread2.setDaemon(true);

        thread1.start();
        thread3.start();
        thread1.join(); //calling thread (ex.main) waits until the specified thread dies or for x milliseconds
        thread2.start();

        //System.out.println(1/0);
    }
}