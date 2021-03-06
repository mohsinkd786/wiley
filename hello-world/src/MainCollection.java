import com.mohsinkd786.generics.*;
import com.mohsinkd786.generics.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainCollection {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.process();

        // Generics
        EmployeeType<String> employeeType = new EmployeeType();
        employeeType.setType("Hello");
        //

        // specifying custom type
        EmployeeType<User> employeeType1 = new EmployeeType<>();
        employeeType1.setType(new User(1,"usr"));

        EmployeeType employeeType2 = new EmployeeType();
        employeeType2.setType("Hi");
        employeeType2.setType(1);
        employeeType2.setType(true);
        employeeType2.setType(new User(1,"tr"));


        // bounded generics type

        // refer the child classes only
        // inheritance
        VehicleService<BMW> vehicleService = new VehicleService();

        BMW car = new BMW();
        car.setType("Luxury");
        car.setSpeed(100);

        vehicleService.getDetailsForVehicle(car);

        Harley harley = new Harley();
        harley.setTopSpeed(80);
        harley.setSports(true);

        VehicleService<Harley> vehicleService1 = new VehicleService();
        vehicleService1.getDetailsForVehicle(harley);

        //vehicleService.getBikeSpecs(harley);

        //VehicleService<Harley> vehicleService1 = new VehicleService<>();

        //List<VehicleService<BMW>> vehicleServices = Arrays.asList(vehicleService);

        // specify generic type for method
        vehicleService.<Integer>process(car,new Integer(1));

        // type inference - smart check by javac
        vehicleService1.process(harley,new Float(12.0));

        // strong type check
        vehicleService1.<Integer>process(harley,10);

        vehicleService1.<Integer,Integer>getInfo(Arrays.asList(1,2));

        //System.out.println("String return type : "+str);


        Bike bik = new Bike();

        Bike bike1 = new Harley();
        Bike harley2 = new Harley();

        List<Bike> bikes = Arrays.asList(bik,bike1,harley2);
        List<Harley> harleys = new ArrayList<>();

        for(Bike b: bikes){

            if(b instanceof Harley){
                Harley h= (Harley) b;

                System.out.println("Harley ");
            }
        }
        //
        AA aa = new AA();
        aa.index = 1;
        aa.name = "Username";

        AA.process(aa.index,aa.name);

    }
}

class AA{
    public int index;
    public String name;

    public static void process(int index,String name){
        System.out.println("Index "+index+"-- Name: -"+name);
//        AA aa= new AA();
//        aa.index = 10;
//        aa.name = "Hello";
    }
}
