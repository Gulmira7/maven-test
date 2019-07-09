package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTestNG {

    @Test
    public void login(){
        System.out.println("logging in...");
       Assert.fail("On purpose fail");
    }
    @Test(dependsOnMethods = "login")
    public void makePurchase(){
        System.out.println("making the purchase...");
    }
    @Test
    public void homePage(){
        System.out.println("homePage tested");
    }
}
