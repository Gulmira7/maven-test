package com.cybertekb11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartbearSoftwareOrderPlacing {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        login.click();
        WebElement order = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        order.click();
    }
}
