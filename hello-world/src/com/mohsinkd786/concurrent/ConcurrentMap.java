package com.mohsinkd786.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap implements Runnable {
    //private static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {

//        ConcurrentMap concurrentMap = new ConcurrentMap();
//        Thread t1 = new Thread(concurrentMap);
//
//        t1.start();
//
//        // traverse via the map
//        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
//
//        for(Map.Entry entry: entrySet){
//            System.out.println(" K "+entry.getKey() + " V : "+entry.getValue());
//        }


        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("one","one");
        map.put("two","two");
        map.put("three","three");
        map.put("four","four");

        Iterator<String> itrs = map.keySet().iterator();

        while (itrs.hasNext()){
            String key = itrs.next();
        //    if(key.equals("three")){
                // add a new value in the map
                //map.put(key + "_","key"+"_");
                map.remove(key);
          //  }
            System.out.println(" K "+key);
        }


       // map.forEach((k,v)-> System.out.println(k + " "+v));


        //System.out.println(map);

        //map.forEach((k,v)-> System.out.println("K "+k+" V: "+v));

//        ConcurrentMap concurrent = new ConcurrentMap();
//        Thread thread1 = new Thread(concurrent);
//        thread1.start();
    }

    @Override
    public void run() {
//        map.put("Google",400);
//        map.put("Microsoft",600);
//        map.put("Apple",1100);
//        map.put("Tesla",700);
        Map<String,String> map = new HashMap<>();
        map.put("one","one");
        map.put("two","two");
        map.put("three","three");
        map.put("four","four");

        Iterator<String> itrs = map.keySet().iterator();

        while (itrs.hasNext()){
            String key = itrs.next();
            if(key.equals("three")){
                // add a new value in the map
                map.put(key + "_","key"+"_");
                map.remove(key);
            }
//            try {
//                Thread.sleep(100);
//
//            }catch (InterruptedException ex){
//                ex.printStackTrace();
//            }
            System.out.println(" K "+key);
        }
        System.out.println(map);
    }
}
