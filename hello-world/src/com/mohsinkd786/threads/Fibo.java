package com.mohsinkd786.threads;

import java.util.*;

public class Fibo {
    public static void main(String[] args) {
        List<Integer> lls=new ArrayList<>();

        lls.add(1);

        int cap=1;

        fib ob1=new fib(lls,cap);
        sum ob2=new sum(lls);

        Thread t1=new Thread(ob1,"Thread-1");
        Thread t2=new Thread(ob2,"Thread-2");
        t1.start();
        t2.start();
    }
}

class fib implements Runnable {

    List<Integer> ls;
    int cap;
    int a = 0;
    int b = 1;

    public fib(List<Integer> ls, int cap) {
        super();
        this.ls = ls;
        this.cap = cap;
    }

    public void produce(int i) {
        synchronized (ls) {
            while (ls.size() == cap) {
                try {
                    ls.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            int c = a + b;
            ls.add(c);
            a = b;
            b = c;
            ls.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            int i = 0;
            produce(i++);
        }
    }
}

class sum implements Runnable{

    List<Integer> ls;
    int sum=0;
    public void consume() {
        synchronized(ls) {
            while(ls.size()==0) {
                try {
                    ls.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            int t=ls.remove(0);
            System.out.println(sum+" + "+t+" = "+(sum+t));
            sum=sum+t;
            ls.notify();
        }
    }
    public sum(List<Integer> ls) {
        super();
        this.ls = ls;
    }
    @Override
    public void run() {
        while(true) {
            consume();
        }

    }

}
