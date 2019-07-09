package com.cybertekb11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentsDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");
        WebElement departments = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select alldepartments = new Select(departments);
        String allDepartmentsByDefault = alldepartments.getFirstSelectedOption().getText();
        System.out.println(allDepartmentsByDefault);


        List<WebElement> department = alldepartments.getOptions();
        System.out.println(department.size());


    }
}
