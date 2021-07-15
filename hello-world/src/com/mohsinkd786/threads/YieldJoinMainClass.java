package com.mohsinkd786.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class YieldJoinMainClass {

    public static void main(String[] args) {

        // Producer
        MyProducer producer = new MyProducer();
        // Consumer
        MyConsumer consumer = new MyConsumer();

        // create threads

//        Thread t1 = new Thread(producer);
//        t1.setPriority(Thread.MAX_PRIORITY);
//        Thread t2 = new Thread(producer);
        //Thread t2 = new Thread(consumer);

//        // start the 2 threads
//        t1.start();
//        try{
//            t1.join();
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//        t2.start();

//        t1.start();
//        Thread.yield();
//
//        t2.start();


        //
        List<YieldJoinMainClass.User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();

        users.add(user1);
        users.add(user2);

        FirstName firstName = new FirstName();
        firstName.setUsers(users);



        FullName fullName = new FullName();
        fullName.setUsers(users);


        //users.forEach(u-> System.out.println(u.id + " "+u.fullName));

        Completion completion = new Completion();
        completion.setUsers(users);

        Thread t11 = new Thread(firstName,"Name");
        t11.setPriority(3);
        Thread t12 = new Thread(fullName,"Full Name");
        t12.setPriority(3);
        Thread t13 = new Thread(completion,"Completion");
        t13.setPriority(3);

        // using time based joins
        try {
            t11.start();
            t11.join();
            t12.start();
            // use timed join
            t12.join(5000);
            t13.start();

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    static class User {
        public String firstName;
        public String id;
        public String fullName;

    }
}

class MyProducer implements Runnable{

    @Override
    public void run() {
        //try{
            //Thread.sleep(1000);
            for(int i=0;i<5;i++){
                System.out.println("PRIORITY : "+Thread.currentThread().getPriority()+" " + Thread.currentThread().getName() +" --"+i);
            }
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
    }
}

class MyConsumer implements Runnable{
    @Override
    public void run() {
        System.out.println("My Consumer Run ");
    }
}


// Execution flow for 2 threads

//My Producer Run
//Time out
//My Consumer Run
//Thread-0 --0
//Thread-0 --1
//Thread-0 --2
//Thread-0 --3
//Thread-0 --4



class FirstName implements Runnable{

    private List<YieldJoinMainClass.User> users;

    public void setUsers(List<YieldJoinMainClass.User> users) {
        this.users = users;
    }

    @Override
    public void run() {
        users.forEach(u-> {
            u.firstName = "User";
            u.id = UUID.randomUUID().toString();
            System.out.println(Thread.currentThread().getName() );
            //Thread.yield();
        });
    }
}

class FullName implements Runnable{

    private List<YieldJoinMainClass.User> users;

    public void setUsers(List<YieldJoinMainClass.User> users) {
        this.users = users;
    }

    @Override
    public void run() {
        users.forEach(u->{
            u.fullName = u.firstName + "_";
            System.out.println(Thread.currentThread().getName());
            //Thread.yield();
        });
    }
}

class Completion implements Runnable{

    private List<YieldJoinMainClass.User> users;

    public void setUsers(List<YieldJoinMainClass.User> users) {
        this.users = users;
    }
    @Override
    public void run() {
        users.forEach(u->{
            System.out.println(Thread.currentThread().getName()+" " + u.fullName + " "+ u.id);
            //Thread.yield();
        });
    }
}
