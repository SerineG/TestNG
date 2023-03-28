package day01;

import org.testng.annotations.*;

public class _02_Annotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod is working");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method is working");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class is working");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class is working");
    }
    @Test
     void test1(){
        System.out.println("Test 1 is successful");
    }
    @Test
   void test2() {
        System.out.println("Test 2 is successful");
    }


}
