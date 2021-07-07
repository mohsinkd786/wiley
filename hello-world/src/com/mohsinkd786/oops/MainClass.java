package com.mohsinkd786.oops;

import java.util.Collections;

public class MainClass {
    public static void main(String[] args) {

        //
        //User user;
        User user = new User();
        User user1 = new User();
        // instance members
        user.process();
        user.userId = 10;

        // static member
        User.userName ="techmomo";
        //User.execute(user);

        //Collections.sort();

        // class names - PascalCasing
        // variables / methods - camelCasing

        System.out.println(String.class.getClassLoader());
        // custom class
        System.out.println(User.class.getClassLoader());

        //
        //Class clasz =

        //static inner class create the object directly via new keyword
        User.EmailMessage emailMessage = new User.EmailMessage();
        emailMessage.getMessageId();

        // inner class
        User user2 = new User();
        User.Address address =  user2.new Address();

    }
}

/**
 *
 * Boostrap = jre/lib/rt.jar
 *
 * Extension = jre/lib/ext
 *
 * System / Application
 *
 *
 *
 *  // loads the class in JVM ->
 *
 *      1.loading of .class ->
 *      2.linking (verify the class) ->
 *      3.initialise the variables / members (will load static first) ->
 *      4.JVM memory Allocation happens now
 *              a.Method Area - stores static variables / class info
 *              b.Heap - stores instances / objects
 *              c.Stack - Thread class / runtime stack for methods aka method executions
 *              d.Native Stack - stores native method calls e.g. call to C/ C++
 *      5.Executing the bytecode files - JIT is called here / GC executions happen here
 *
 * **/
