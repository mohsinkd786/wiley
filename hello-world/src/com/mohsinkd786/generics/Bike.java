package com.mohsinkd786.generics;

public class Bike implements Vehicle {
    private double topSpeed;

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    private boolean isSports;

    public boolean isSports() {
        return isSports;
    }

    public void setSports(boolean sports) {
        isSports = sports;
    }

    public String getBikeDetails(){
        return topSpeed + "-- IsSportsBike : "+isSports;
    }

    @Override
    public String getDetails() {
        return topSpeed + "-- IsSportsBike : "+isSports;
    }
}
