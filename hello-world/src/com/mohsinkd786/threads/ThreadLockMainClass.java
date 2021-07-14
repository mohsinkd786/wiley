package com.mohsinkd786.threads;

public class ThreadLockMainClass {
    public static void main(String[] args) {

        A aa = new A();
        B bb = new B();

        // create Thread 1
        Runnable t1 = ()-> {
                synchronized (aa){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    // assume somehow A uses / needs B as well
                    synchronized (bb){
                        System.out.println(Thread.currentThread().getName() +" t1 ");
                    }
                }
            };
        // create Thread 2
        Runnable t2 = ()-> {
                synchronized (bb) {
//                    try{
//                        Thread.sleep(200);
//                    }catch (InterruptedException ex){
//                        ex.printStackTrace();
//                    }
                    // assume class B needs A as well
                    synchronized (aa){
                        System.out.println(Thread.currentThread().getName() + " t2");
                    }
                }
        };

        Thread thread1 = new Thread(t1,"thread-A");
        Thread thread2 = new Thread(t2,"thread-B");

        // start both threads
        thread2.start();
        thread1.start();
    }
}

/*
*  t1 ->
*           obj A
*           obj B
*  t2 ->
*
* */


class A{
    private int i =10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class B{
    private int i=15;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
