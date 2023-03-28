package day01;

import org.testng.annotations.Test;

public class _03_Enable {
    @Test
    public void test1() {
        System.out.println("Test 1 is successful");
    }
    @Test(enabled = false)
    public void test2(){
        System.out.println("Test 2 is successful");
    }
    @Test
    public void test3(){
        System.out.println("Test 3 is successful");
    }

}
