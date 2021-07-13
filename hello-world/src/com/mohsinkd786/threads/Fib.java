package com.mohsinkd786.threads;

import java.util.ArrayList;
import java.util.List;

public class Fib{
    List<String> ls = new ArrayList<String>();
    int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Fib ob = new Fib();
        DoYourThing ob1 = new DoYourThing();
        ob1.start();

        for(int x=1;x<=10;x++) {

            String st=ob.sum+" + "+ob1.b+" = "+(ob1.b+ob.sum);
            ob.ls.add(st);
            ob.sum+=ob1.b;

            Thread.sleep(500);
        }
        Thread.sleep(1000);
        System.out.println(ob.ls);

    }
}

class DoYourThing extends Thread {
    int a = 0, b = 1;

    public void run() {

        for (int x = 1; x <= 10; x++) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
