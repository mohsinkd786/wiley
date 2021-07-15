package com.mohsinkd786.threads;

import java.util.Optional;
import java.util.concurrent.*;

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

        // service.shutdown();
//
//        try{
//            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

//        service.execute(object2);
//        service.execute(object1);
//
//        service.execute(object);

        // we can return

        //service.submit();
        // close of the thread pool
        // just a request to close of the link eventually

        CallService callService = new CallService();

        Future<String> callFuture = service.submit(callService); // task 1

        try{
            if(callFuture.isDone()){
                String res1 = callFuture.get();
            }

            System.out.println("Future from Call Service "+callFuture.get());

        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        //service.shutdown();

        Future<String>  callFuture1 = service.submit(callService); // task 2

        callFuture.isDone();


        //Callable callable = () -> callService.call();

        FutureTask<String> futureTask = new FutureTask<>(callService);

        Thread t = new Thread(futureTask,"CallableFuture-1");
        t.start();

        try{
            String futureResponse="";
            if(futureTask.isDone()){
                futureResponse = futureTask.get();
            }

            System.out.println("FUTURE RESPONSE :: "+futureResponse);
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }


        // interrupt a running thread
        callFuture1.cancel(true);

        if(callFuture1.isCancelled()){
            try{
            System.out.println("cancelled "+callFuture1.get());

            }catch (InterruptedException | ExecutionException ex){
                ex.printStackTrace();
            }
        }

    }
}

class ThreadPool implements Runnable{
    void process(){
        for (int i = 0; i < 5 ; i++) {
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

class CallService implements Callable<String>{

    @Override
    public String call() {
        StringBuilder response = new StringBuilder();
        for(int i= 0;i< 100;i++){
//            try{
//                Thread.sleep(10);
//            }catch (InterruptedException ex){
//                ex.printStackTrace();
//            }
            response.append(i);
            response.append("_");
            System.out.println(Thread.currentThread().getName() + " "+i);
        }
        return response.toString();
    }
}
