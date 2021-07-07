package com.mohsinkd786.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        //
        List<Integer> nums = Arrays.asList(1,2,5,6,10);
        //List<Integer> evenNums = new ArrayList<>();

        // filter out the even numbers from the actual list
//        for(int i: nums){
//            if(i % 2 ==0){
//                evenNums.add(i);
//            }
//        }

        // Streams
        // created a stream
//        Stream<Integer> integerStream = nums.stream();
//        // compute the stream
//        Stream<Integer> streamOfEvenNums = integerStream.filter(new FilterEvenNums());
//
//        List<Integer> evenList = streamOfEvenNums.collect(Collectors.toList());
//
//        for(int i: evenList){
//            System.out.println("Streamed Nums "+i);
//        }

//        List<Integer> evenList = nums
//                                    .stream()
//                                    .filter(n-> n % 2 == 0)
//                                    .collect(Collectors.toList());

        nums
                .stream()
                .filter(n-> n%2 ==0)
                //.forEach(new EvenConsumer()); // traverse the newly filtered records
                .sorted((i,j)-> j-i)
                //.sorted(new MyComparator())
                //.sorted(Comparator.comparingInt(Integer::intValue)) // int comparator
                .forEach(n-> System.out.println("EvenConsumer : "+n));

        List<String> msgs = Arrays.asList("10","12","13","35","42");

        List<Integer> msgNums = msgs
                    .stream()
                    .filter(s -> s.startsWith("1"))
                    .map(e -> new Integer(e))
                .distinct()
                    .collect(Collectors.toList());

                //.forEach(num-> System.out.println("Str Values :: "+num));


        // convert users to employees
        List<User> users = Arrays.asList(
                new User(1,"User 1"),
                new User(2,"User 2"),
                new User(3,"User 3"));


        List<Employee> employees =
        users.stream()
                .map(user-> new Employee(user.id,user.name)) // transform user into employee entity
                .collect(Collectors.toList());
    }
}


class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}


class FilterEvenNums implements Predicate<Integer>{
    @Override
    public boolean test(Integer integer) {
        if(integer % 2 == 0){
            return true;
        }else {
            return false;
        }
    }
}


class EvenConsumer implements Consumer<Integer>{
    @Override
    public void accept(Integer integer) {
        System.out.println("EvenConsumer : "+integer);
    }
}


class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class Employee {
    int empId;
    String empName;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }
}
