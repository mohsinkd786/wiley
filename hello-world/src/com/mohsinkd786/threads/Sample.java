package com.mohsinkd786.threads;

public class Sample {
    public static void main(String[] args) {

        Sample sample = new Sample();
        AA aa = new AA();
        aa.i = 1;

        sample.updateMe(aa);
        System.out.println(aa);

    }
    void updateMe(AA aa){
       aa.i = 8;
    }
}

class AA{
    public int i;
}


