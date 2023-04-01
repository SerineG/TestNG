package day03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    @Test
    void startCar(){
        System.out.println("Start this car");
        Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})
    void driveCar(){
        System.out.println("Drive this car");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"})
    void parkCar(){
        System.out.println("Park this car");
    }
    @Test(dependsOnMethods = {"parkCar","startCar","driveCar"})
    void stopCar(){
        System.out.println("Stop this car");
    }
}
