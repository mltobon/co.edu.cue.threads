package org.example;

public class MyThread1 extends Thread{

    @Override
    public void run() {

       /* if(this.isDaemon()) {
            System.out.println("This is a daemon thread that is running");
        }
        else {
            System.out.println("This is a user thread that is running");
        }*/
        for(int i =0;i<10;i++) {
            System.out.println("Thread name : "+Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished : "+Thread.currentThread().getName());
    }
}