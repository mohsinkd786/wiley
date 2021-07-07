package com.mohsinkd786.lambdas;

@FunctionalInterface
public interface Service {
    void process();
}


interface Calc{
    int calculate(int i,int j);
}

abstract class AbsService{
    abstract void process();
}
