package com.mohsinkd786.generics;

public class Harley extends Bike{

    @Override
    public String getBikeDetails(){
        return getTopSpeed() + "--Harley is a Sports Bike : " + isSports();
    }
}
