package com.mohsinkd786.oops;

import static java.lang.System.out;

public class Service {

    public void tryMe(){

        // method inner class
        class TryMe {
            void process(){
                out.println("Proces in Tryme");
            }
        }
        TryMe tryMe = new TryMe();
        tryMe.process();

        // create anonymous class
        IService service = new IService() {
            @Override
            public void execute() {
                out.println("Service anonymous class");
            }
        };

        service.execute();

    }

    public static class Inner{

        public void callMe(){

        }
    }
    interface IService{
        void execute();
    }

}

class SuperOuter extends Service.Inner implements Service.IService{

    @Override
    public void callMe(){

    }

    @Override
    public void execute() {

    }
}


class A{

    public void tryMe(){
        class B{
            public void innerTryMe(){
                class Local{
                    public void printMe(){
                        out.println("Print Me...");
                    }
                }
                Local local = new Local();
                local.printMe();
            }
        }
        B b = new B();
        b.innerTryMe();
    }
}
