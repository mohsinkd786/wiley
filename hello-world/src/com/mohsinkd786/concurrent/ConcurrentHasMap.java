package com.mohsinkd786.concurrent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHasMap {
    // capacity : how many elements are allowed to store
    // load factor : at what time we need to scale up the map
    // concurrency level : number of segments created within the map
    ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer, String>(10,0.75f,2);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(16);
        ConcurrentHasMap hasMap = new ConcurrentHasMap();

        Collections.synchronizedMap(hasMap.concurrentHashMap);

        service.execute(hasMap.new WriterTwo());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterOne());
        service.execute(hasMap.new WriterTwo());

        service.execute(hasMap.new WriterTwo());

        service.execute(hasMap.new WriterTwo());
        service.execute(hasMap.new WriterTwo());
        service.execute(hasMap.new WriterTwo());
        service.execute(hasMap.new WriterTwo());
        service.execute(hasMap.new WriterTwo());



        service.execute(hasMap.new Reader());

        //hasMap.concurrentHashMap;

//        [
//
//        // segment 1
//        [// k,v
//        // k,v ]
//
//        // segment 2
//        [
//                // k,v
//        ]
//
//        // segment 3
//        [// k,v
//        // k,v ]
//                ]
        service.shutdown();
    }

    class  WriterOne implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println("Writer One");
                concurrentHashMap.putIfAbsent(i, "A"+i);
            }
        }
    }
    class WriterTwo implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println("Writer Two");
                concurrentHashMap.put(i,"B"+i);
            }
        }
    }

    class Reader implements Runnable{
        @Override
        public void run() {
            Iterator<Integer> itr = concurrentHashMap.keySet().iterator();
            while (itr.hasNext()){
                Integer key = itr.next();
                System.out.println("Key: "+key+ "  Value :"+concurrentHashMap.get(key));
            }
        }
    }
}
