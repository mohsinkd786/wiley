package com.mohsinkd786.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMainClass {
    public static void main(String[] args) {

        // Thread Pool Executor

        // Types of Executor

        // SingleThreadPool Executor - performs sequential execution / allows only one thread
        // FixedThreadPool - we can specify a fixed set of threads
        // ScheduledThreadPool - tasks are executed in intervals
        // CachedThreadPool - keeps the data in an interim state & allows to processs from there


        // create the instance
        ThreadPool object = new ThreadPool();
        ThreadPool object1 = new ThreadPool();
        ThreadPool object2 = new ThreadPool();

        // create a thread
        // Thread t1 = new Thread(threadPool);

        // start the thread
        // t1.start();

        // use the executor service instead

        // use single thread
        //ExecutorService service = Executors.newSingleThreadExecutor();

        ExecutorService service = Executors.newFixedThreadPool(2);
        // executor service facilitates the worker threads


        // spawn the thread pool for the object

        //execute doesnt return us anything
        service.execute(object);

        service.execute(object1);

        service.shutdown();

        service.execute(object2);
        service.execute(object1);

        service.execute(object);

        // we can return

        //service.submit();
        // close of the thread pool
        // just a request to close of the link eventually

    }
}

class ThreadPool implements Runnable{
    void process(){
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.sleep(10);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" "+i);
        }
    }

    @Override
    public void run() {
       process();
    }
}
