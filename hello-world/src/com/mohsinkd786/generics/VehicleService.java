package com.mohsinkd786.generics;

import java.util.List;

public class VehicleService<T extends Vehicle> {

//    public void getCarSpecs(T t){
//        System.out.println(t.getCarDetails());
//    }
//
//    public void getBikeSpecs(K t){
//        System.out.println(t.getBikeDetails());
//    }

    public void getDetailsForVehicle(T t){
        System.out.println(t.getDetails());
    }

    public <K> void process(T t1,K k){
        System.out.println(t1.getDetails());
        System.out.println(k);
    }

    // lower bound - e.g. <? super Number>
    // unbound - e.g. <?>
    public void execute(List<?> list){
        for (Object i:list) {
            System.out.println(i);
        }
    }

    // return generic type
    public <M,L> M getInfo(List<L> ts){

     return (M)ts.toString();
    }
}
