package com.mohsinkd786.threads;

import java.util.ArrayList;
import java.util.List;

public class NotifierMainClass {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        int size = 10;

        Producer producer = new Producer(integers,size);
        // create the thread
        Thread t1 = new Thread(producer,"Producer1");
        Thread t2 = new Thread(producer,"Producer2");
        Consumer consumer = new Consumer(integers);
        // create the Thread
        Thread consumer1 = new Thread(consumer,"Consumer1");
        Thread consumer2 = new Thread(consumer,"Consumer2");
        Thread consumer3 = new Thread(consumer,"Consumer3");
        consumer1.setPriority(10);
        consumer2.setPriority(7);
        consumer3.setPriority(2);

        // start the thread
        t1.start();
        t2.start();
        //
        consumer1.start();
        //
        consumer2.start();
        //
        consumer3.start();
    }
}

class Producer implements Runnable {

    private volatile List<Integer> nums;
    private int CAPACITY;
    private volatile int i;

    public Producer(List<Integer> nums, int size){
        this.nums = nums;
        this.CAPACITY = size;
    }

    @Override
    public void run() {
        synchronized (this) {
            i = 0;
            // call the producer
            while (true) {
                try {
                    produce(i++);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    void produce(int i) throws InterruptedException {

        synchronized (nums){
            while(nums.size() == CAPACITY){
                System.out.println("List is full "+Thread.currentThread().getName() + " size is : "+ nums.size());
                nums.wait();
            }
            Thread.sleep(1000);
            nums.add(i);
            System.out.println("Produced:: "+Thread.currentThread().getName()+"  -- " +i);
            nums.notifyAll();
        }
    }
}

class Consumer implements Runnable{

    private List<Integer> nums;

    public Consumer(List<Integer> nums){
        this.nums = nums;
    }

    void consume() throws InterruptedException{

        synchronized (nums){
            while(nums.isEmpty()){
                System.out.println("List is empty "+Thread.currentThread().getName() + " is waiting, size is  "+nums.size());
                nums.wait();
            }
            Thread.sleep(500);
            // consumer-1 -- waiting / blocking
            // consumer-2 -- waiting /
            // consumer-3 -- running
            // allow to apply the lock - on the object

            // monitor in case of threads - nums

            // always remove from first index in case the value exists, i.e. the list isnt empty
            int num = (Integer)nums.remove(0);
            System.out.println("Consumed Thread :: "+Thread.currentThread().getName() + " --- " +num);
            nums.notifyAll();
            //nums.notify();
        }
    }

    @Override
    public void run() {

        while (true){
            try{
                consume();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
