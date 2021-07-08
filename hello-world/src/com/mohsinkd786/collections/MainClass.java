package com.mohsinkd786.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {

        //
        //UserSet set = new UserSet();
        //set.main();


        // i,acc -> i = null + (1.0,6.6)-> { acc = 1.0+6.6 };
        // acc, "two" -> { acc = acc + two }

        List<Integer> str= Arrays.asList(5,10,2,10);

//        double total = str.stream().reduce((a,b)-> a + b);

        System.out.println(str.stream().filter(i->i%5==0).map(i->i*2.0).reduce(Double::sum).get());



       // String total = Stream.of("one","two","three").reduce(,(String a, String b)->a+b);
       //System.out.println("Normal Stream : "+total);
        System.out.println("------");
        //double total2 = Stream.of(6.6,7.0,5.2,2.8).reduce(0.0,Double::sum);

        String string = null;

        Optional<String> stringOptional = Optional.ofNullable(string);

        //String subStr = process(stringOptional);
       // System.out.println(subStr);

//        System.out.println("Hello");
//
//        MyOptional<String> optional = MyOptional.of("");
//
//        optional.setUserId("10");
//
//        System.out.println("OBJ 1 "+optional.getUserId());
//
//        MyOptional<String> optional1 = MyOptional.of("");
//        System.out.println("OBJ 2 "+optional1.getUserId());

        Optional<String> empty = Optional.empty();
        boolean isPresent = empty.isPresent();
        System.out.println(isPresent);

        Optional<String> sampleStr = Optional.of("str");
        isPresent = sampleStr.isPresent();
        System.out.println(isPresent);

        sampleStr = Optional.ofNullable("str");
        isPresent = sampleStr.isPresent();
        System.out.println(isPresent);

    }

    public static String process(String str){
        return str !=null ? str.concat(str) : str; //: str.get();
    }

    public static String parseStr(String str){
        return str != null ? str.substring(1) : process(str) ;
    }
}

class MyOptional<T> {
    private static MyOptional OBJ = new MyOptional<>();

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private MyOptional(){

    }

    public static <T> MyOptional of(T t){
        return OBJ;
    }

}
