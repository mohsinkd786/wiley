package com.mohsinkd786.generics;

public class Car implements Vehicle{
    private double speed;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public String getCarDetails(){
        return speed + "--" + type;
    }

    @Override
    public String getDetails() {
        return speed + "--" + type;
    }
}
