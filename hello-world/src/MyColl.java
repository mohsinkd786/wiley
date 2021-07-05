import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

class MyColl {
    public static void main(String[] args) {



        // Collections - class , defines all the commonly used utility methods
        // Collection - interface
        /**
         * Iterable
             * Collection
                 * List - preserves the order of insertion
                        * Vector - synchronised list
                        * ArrayList - stores data in array , array type will be object
                        * LinkedList
                 * Set
                 * Queue
         *
         * Map
         * Stack
         *
         *
         *
         *
         * */

        // load factor - 0.75
        // capacity / size - 10
        //

        MyArrList list = new MyArrList();
        Vector vector = new Vector();

        for(int i=0;i<21;i++){
            list.add(i);
        }
//        System.out.println(list.size());
//
//        list.remove(1);
//
        list.trimToSize();

        System.out.println(list.getCapacity());

        list.remove(1);

        list.remove(1);
        System.out.println(list.getCapacity());

        list.trimToSize();

        System.out.println(list.getCapacity());

        LinkedList linkedList = new LinkedList();

        //Deque que = new LinkedList();

        // o-1,ref of 2 <--> ref of 1,2, ref of 3<-->ref of 2, 3

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //linkedList.remove(1);

        linkedList.addFirst(0);
        linkedList.addLast(5);

        for (Object i:linkedList) {
            System.out.println(i);
        }

        System.out.println(linkedList.getLast());

        // A class

        A aa = new A();
        aa.example();
    }

}

class MyArrList extends ArrayList{

    private int currentCapacity = 10;

    public int getCapacity(){
        return currentCapacity;
    }
    public void ensureCapacity(int cap){
        currentCapacity = cap;
        super.ensureCapacity(cap);
    }
    public void trimToSize(){
        currentCapacity = size();
        super.trimToSize();
    }
}


/**
 *  fail fast
 *      Arraylist, Hashmap, treemap
 *  fail safe
 *      concurrent api , concurrenthashmap, copyonwritearraylist
 *
 * */


class Car{

    public void driveMe() throws Exception {

    }
}

class SuperCar extends Car{

    @Override
    public void driveMe() throws RuntimeException {

    }
}

class A{
    public void example(){
        Car car = new SuperCar();


//        Process process = new Sample();
//        AddProcess addProcess = new Sample();
//
//        process.add(1);
//        addProcess.add(2);

        try{
            car.driveMe();
        }catch (Exception e){

        }
    }
}

// xyz.java -- file name

// xyz.class

//

