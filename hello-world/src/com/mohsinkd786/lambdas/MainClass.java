package com.mohsinkd786.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) {

        // anonymous class
        Service service = new Service() {
            @Override
            public void process() {
                out.println("Anonymous Service ..");
            }
        };

//        Service service2 = new Service() {
//            @Override
//            public void process() {
//                out.println("Anonymous Service ..");
//            }
//        };


        service.process();

        // replacing with lambdas
        Service service1 = ()->out.println("Lambda");

        service1.process();

        AbsService absService = new AbsService() {
            @Override
            void process() {

            }
        };

        Calc calc = (i,j)-> i+j;
//        {
//            int a = i+j / 12;
//            return a;
//        };

        int sum = calc.calculate(10,2);
        out.println("SUM : "+sum);

        List<Emp> emps = Arrays.asList(new Emp(1),new Emp(10),new Emp(2));

        //Comparator<Emp> empComparator = (emp1,emp2) -> emp1.id - emp2.id;

        Collections.sort(emps,(emp1,emp2) -> emp1.id - emp2.id);

        //emps.forEach(e-> out.println(e.id));
        for (Emp emp:emps) {
            out.println(emp.id);
        }
    }
}

class Emp {
    public int id;

    public Emp(int id){
        this.id = id;
    }
}

