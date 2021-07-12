package com.mohsinkd786.threads;

import com.mohsinkd786.collections.UserSet;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("MainClass "+Thread.currentThread().getId()+" "+Thread.currentThread().getPriority());
        //System.out.println(" -- "+Thread.currentThread().isDaemon());

//        for(int i =0;i<100000;i++){
//            System.out.println("COl Val "+i);
//        }
        System.out.println("MainClass I am good how about u ");

        // create a thread
//        Thread thread2 = new Thread("SampleThread");
//        Thread thread1 = new Thread("MyThread1");
//
//        thread2.setPriority(Thread.MAX_PRIORITY);
//
//        thread1.setDaemon(true);
//        // we can priority to the threads
//        //1 - 10
//        // 1 - lowest
//        // 10 - highest
//        // 5 - Normal
//
//        // starting the thread
//        thread1.start();
//        thread2.start();
//
//        // transform into a daemon thread
//        thread1.setPriority(8);
//
//        System.out.println(thread2.getId() + "-- "+thread2.getPriority());
//        System.out.println(thread1.getId() +"-- "+thread1.getPriority());

        UserService userService1 = new UserService();
        UserService userService2 = new UserService();

        // START : THREAD 1
        userService1.setName("USERSERVICE-1");
        userService1.start();

        // START : THREAD 2
        userService2.setName("USERSERVICE-2");
        userService2.start();

        userService1.setPriority(1);
    }
}

/**
 * ways to create threads
 *  1. Thread class
 *  2. Runnable Interface
 *  3. Callable Interface
 *  4. Executor Service / Framework
 *
 *  Types of Threads
 *  1. Priority Threads - they have high priority & can manipulate the JVM from processing
 *  2. Daemon Threads - they are low priority threads & cant prevent JVM from exiting , they always run in background
 * */

class UserService extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " ---- "+i);
        }
    }
}
