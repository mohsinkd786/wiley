package com.mohsinkd786.threads;

import java.util.Vector;

public class SyncMainClass {
    public static void main(String[] args) {

        Process process = new Process();
        // create Thread 1
        Thread t1 = new Thread(process,"t1");
        // start the thread
        t1.start();

        // create Thread 2
        Thread t2 = new Thread(process,"t2");
        // start the thread
        t2.start();

        // create Thread 3
        Thread t3 = new Thread(process,"t3");
        // start the second thread
        t3.start();
        // create Thread 4
        Thread t4 = new Thread(process,"t4");
        // start the thread
        t4.start();
        // create Thread 5
        Thread t5 = new Thread(process,"t5");
        // start the thread
        t5.start();
        // create Thread 6
        Thread t6 = new Thread(process,"t6");
        // start the thread
        t6.start();
        // create Thread 7
        Thread t7 = new Thread(process,"t7");
        // start the thread
        t7.start();
        // create Thread 8
        Thread t8 = new Thread(process,"t8");
        // start the thread
        t8.start();

    }
}



//      (Thread Stack)
// t1  --> counter = 1              (Main Memory - Heap)
                                // Process (counter) = 3
// t2  --> counter = 2

// t3  --> counter = 2

// t4  --> counter = 2

// t6  --> counter = 3

// t10 --> counter = 4


// in case of synchronisation

// t2 --> counter = 1
                                    // Process (counter) = 3
// t5 --> counter = 2

// t10 --> counter = 3


class Process implements Runnable{

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        // increment
        counter++;
    }
    public void decrement() {
        counter --;
    }

    @Override
    public void run() {

        // to resolve the race condition we will synchronize the block

        synchronized (this) {
            // this is our critical section /area
            // only a single thread can enter this area at any given point of time
            // increment the counter
            this.increment();
            System.out.println("Sync:: " + Thread.currentThread().getName() + " " + this.getCounter());
        }

        // decrement the counter
        this.increment();

        System.out.println(" "+Thread.currentThread().getName() + " "+this.getCounter() );
    }

}


/*
* t1 => counter = / 0
* t2 => counter = 1  / 2 / 3
* */
