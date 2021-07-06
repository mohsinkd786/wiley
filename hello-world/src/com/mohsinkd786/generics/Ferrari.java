package com.mohsinkd786.generics;

public class Ferrari extends Car {
    @Override
    public String getCarDetails(){
        return getSpeed() + "--" + getType() + "Ferrari";
    }
}
