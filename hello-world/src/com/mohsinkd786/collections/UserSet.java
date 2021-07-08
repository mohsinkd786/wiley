package com.mohsinkd786.collections;

import java.time.Instant;
import java.util.*;

public class UserSet {

    public void main(){
        //
        // set doesnt allow duplication
        // doesnt allow null values
        Set set = new HashSet(); // uses hashmap to store the values

        set.add(11);

        // set.put(1,obj);
        // set.put(2,obj);

        set.add(2);
        set.add("Hello");
        //set.add(null);

        set.add(null);
        set.add("");

        set.forEach(System.out::println);


//        for (int i = 0; i < 5000; i++) {
//            set.add(i);
//        }

        //System.out.println(Instant.now());
        // stream performs sequential execution
        //set.stream().forEach(System.out::println);

       // System.out.println(Instant.now());
        System.out.println("*****************");


       // System.out.println(Instant.now());
        // parallel stream performs concurrent execution i.e. it will perform random processing
        // no order shall be maintained
        //set.parallelStream().forEachOrdered(e1->System.out.println("Parallel Ordered "+e1));

        set.parallelStream().forEach(ee-> System.out.println("Parallel "+ee));

        //System.out.println(Instant.now());

//        LinkedList list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(11);
//
//        list.forEach(l-> System.out.println("l list "+l));


        //Set set1 = new TreeSet(); // inherits from sorted set

//        Iterator itr = set.iterator();
//        System.out.println(Instant.now());
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
//        System.out.println(Instant.now());

        // uses tree map to store values

        System.out.println("TREE SET.... ");
        // treemap doesnt allow null values
        Set<String> set1 = new TreeSet<>(Comparator.reverseOrder()); // inherits from sorted set

        set1.add("Hi");
        set1.add("Hello");
        set1.add("Hola!");

        set1.add(new String("HI"));
        set1.add(new String("HI"));

        // duplicate value
        // not allowed
        set1.add("Hi");
        // null values arent permitted
        //set1.add(null);

//        Integer intt = new Integer(12);
//        set1.add(intt);

        set1.forEach(System.out::println);
    }
}


// Exception in thread "main" java.lang.ClassCastException:
//                  java.lang.Integer cannot be cast to java.lang.String
//	at java.lang.String.compareTo(String.java:111)

// Exception in thread "main" java.lang.ClassCastException:
//                  java.lang.String cannot be cast to java.lang.Integer
//	at java.lang.Integer.compareTo(Integer.java:52)


// 2021-07-08T04:07:24.806Z
//    73
// 2021-07-08T04:07:24.879Z

// 2021-07-08T04:07:24.919Z

// 40

// 2021-07-08T04:10:59.946Z
// 2021-07-08T04:11:00.003Z

// 57
