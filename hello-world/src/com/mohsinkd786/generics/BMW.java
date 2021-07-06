package com.mohsinkd786.generics;

public class BMW extends Car {

    @Override
    public String getCarDetails(){
        return getSpeed() + "--" + getType() + "BMW";
    }
}
