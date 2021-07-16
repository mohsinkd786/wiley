package com.mohsinkd786.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Concurrent implements Runnable {

    // concurrent Collections
    public static List<String> messages = new CopyOnWriteArrayList<>();

    public void process(){

        // add values to the list
        messages.add("one");
        messages.add("two");
//        messages.add("three");
//        messages.add("four");

//        try{ Thread.sleep(6000);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        Concurrent concurrent = new Concurrent();
        //create a thread
        Thread t1 = new Thread(concurrent,"Concurrent Thread");
        // start a thread
        t1.start();

        // define iterator
        Iterator tr = messages.iterator();

        // traverse via the list using the iterator
        while(tr.hasNext()){
            System.out.println(" "+tr.next());
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException ex){
//                ex.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName());
        }
        messages.add("final");
    }
    @Override
    public void run() {
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
        messages.add("run");
    }

    public static void main(String[] args) {

        // not needed now
        //Collections.synchronizedList(messages);

        Concurrent concurrent =new Concurrent();
        concurrent.process();

        //concurrent.process();

    }
}


// Concurrent Collections

// 1. CopyonWriteArrayList
// 2. CopyonWriteArratSet
// 3. ConcurrentHashMap
// 4. BlockingQueue
