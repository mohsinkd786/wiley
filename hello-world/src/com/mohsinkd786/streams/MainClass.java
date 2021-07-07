package com.mohsinkd786.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        //
        List<Integer> nums = Arrays.asList(1,2,5,6,10);

        Optional<Integer> result = nums.stream()
                //.reduce((n, a)-> Math.max(n,a));
                  .reduce(Math::max);
                //.ifPresent(System.out::println);

        System.out.println("result "+result.get());

        List<String> strings = Arrays.asList("one","two","three");

        //UserString userString = new UserString();

        List<String> sortedStrings = strings.
                                            stream().
                                            //sorted((s1,s2)-> s1.compareTo(s2)).
                                            sorted(String::compareTo).
                                            collect(Collectors.toList());
                                            //forEach(System.out::println);

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
                    //.map(e -> new Integer(e))
                    .map(Integer::new)
                    //.distinct()
                    .collect(Collectors.toList());
                    //.forEach(num-> System.out.println("Str Values :: "+num));

        // convert users to employees
        List<User> users = Arrays.asList(
                new User(1,"User 1"),
                new User(22,"User 22"),
                new User(3,"User 3"));


        EmployeeComparator comparator = new EmployeeComparator();

//        List<Employee> employees =
        users.stream()
                //.map(user-> new Employee(user)) // transform user into employee entity
                .map(Employee::new)
                .sorted((e1,e2)-> e1.empId - e2.empId)
               // X //.sorted(comparator::compare)
                //.sorted((e1,e2)-> comparator.compare(e1,e2))
                .collect(Collectors.toList()).forEach(System.out::println);

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

    public Employee(User user){
        this.empId = user.id;
        this.empName = user.name;
    }


    @Override
    public String toString() {
        return "[ Emp: "+empId +" Name: "+empName +"]";
    }
}

class UserString implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.empId - o2.empId;
    }
}

class EmployeeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.empId - o2.empId;
    }
}

/**
 * Method References
 *
 * 1. calling the static methods
 * 2. calling the constructor
 * 3. calling instance method
 * 4. calling instance method from type of class
 * */


/*
*
* Intermediate Operators
*
* map -> transformer
* filter -> perform filteration of data
* sorted -> sort based on comparator
* flatMap -> flatten the nested lists -> list<list<string>> --> list<string>
* peek -> perform a specific operation e.g. change the state of the current object
* min / max -> get a specific value
* distinct -> remove duplication
* allMatch / anyMatch / noneMatch -> matchers somewhat similar to filter
* average /sum / range - aggregate operations
* generators -> generate / iterator
* takeWhile -> perform while loop
* limit ->
* skip ->
* findFirst ->
*
*
* Terminal Operators

*
* collect - accumulate the result from stream - e.g. toList(), toSet() , joining(joiners), partitionBy / GroupingBy
* forEach -> traverse on the stream
* reduce -> reduce the stream to a single value
* toArray -> convert to array
* */
