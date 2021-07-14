package com.mohsinkd786.threads;

public class DeadLock {
    public static void main(String[] args) {

        // create the objects
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        // instantiate the two thread classes
        User user = new User(s1,s2);
        //
        Employee employee = new Employee(s1,s2);

        // create threads for the classes
        Thread t1 = new Thread(user,"t1");
        Thread t2 = new Thread(employee,"t2");

        // start the threads
        t1.start();
        t2.start();

    }
}

class Shared {

    synchronized void execute(Shared shared){
        System.out.println("execute method");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        //this.shared = shared;

        // call process method
        shared.process();
        System.out.println("execute method : END");
    }

    synchronized void process(){
        System.out.println("process method");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("process method : END");
    }
}

// our thread class
class User implements Runnable{

    private Shared shared1;
    private Shared shared2;

    public User(Shared s1,Shared s2){
        this.shared1 = s1;
        this.shared2 = s2;
    }

    @Override
    public void run() {
        // apply the lock on
        // call execute method using object 1
        shared1.execute(shared2);
    }
}

// our thread class

class Employee implements Runnable{

    private Shared shared1;
    private Shared shared2;

    public Employee(Shared s1,Shared s2){
        this.shared1 = s1;
        this.shared2 = s2;
    }

    @Override
    public void run() {

        // apply the lock
        // call the execute method from object 2
        shared2.execute(shared1);
    }
}

