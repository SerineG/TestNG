package day01;

import org.testng.annotations.Test;

public class _01_Intro {
//    public static void main(String[] args) {
//
//    }


    @Test(priority=1)
    public void loginTest() {
        System.out.println("Login Test is successful");
    }
    @Test(priority=2)
    public void addToCardTest(){
        System.out.println("Add to Card test is successful");
    }
    @Test(priority=3)
    public void checkOutTest(){
        System.out.println("Checkout test is successful");
    }

}
