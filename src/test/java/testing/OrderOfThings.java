package testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running");
    }
    @Ignore
    @Test(priority = 1, dependsOnMethods = "secondTest")
    public void cfirstTest(){
        System.out.println("First test is running");
    }
    @Test(priority = 2)
    public void dsecondTest(){
        System.out.println("Second test is running");
    }
    @Test(priority = 3)
    public void athirdTest(){
        System.out.println("Third test is running");
    }

}
