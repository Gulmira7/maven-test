package com.cybertekb11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearLinkVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        login.click();
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of the links on the landing page: " + links.size());
        for (WebElement l: links) {
            System.out.println(l.getText());
        }

    }
  public static void loginToSmartBear(WebDriver driver){
      WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
      WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
      WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
      username.sendKeys("Tester");
      password.sendKeys("test");
      login.click();
  }

    public static void verifyNames(WebDriver driver, String givenName){
        List<WebElement> allName = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for(WebElement name: allName){
            if(name.getText().equals(givenName)){
                System.out.println(givenName + " exists in the table. Name verification PASSED!");
                return;
            }
        }
        System.out.println(givenName + " does not exist in the list. Name verification FAILED!");
    }
    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> allName = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        List<WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));
        for(int i=0; i<allCities.size(); i++){
            System.out.println(allName.get(i).getText() + "<--names, cities--> "
                    + allCities.get(i).getText());
        }
    }

}
