package com.cybertekb11;

//
// I want to be able to search for vacation rentals and get a list with the available dates that im looking for.*//

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
I want to be able to search for vacation rentals and get a list with the available dates that im looking for./
 */
public class VacationRentalsByGulmiraKadyrova {
    public static void main(String[] args)  throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        vacationRentalsSearchMethod2(driver);
    }
    public static void vacationRentalsSearchMethod2(WebDriver driver)throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("https://www.expedia.com/");
        WebElement vacationRentals = driver.findElement(By.id("primary-header-vacationRental"));
        vacationRentals.click();
        WebElement destination = driver.findElement(By.id("VR-destination"));
        destination.sendKeys("Malibu, California");
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='VR-fromDate']"));
        datePicker.click();
        WebElement checkIn = driver.findElement(By.xpath("(//button[@data-day='14'])[2]"));
        checkIn.click();
        WebElement datePicker2 = driver.findElement(By.xpath("//input[@id='VR-toDate']"));
        datePicker2.click();
        WebElement checkOut = driver.findElement(By.xpath("//button[@class='datepicker-cal-date end']"));
        checkOut.click();
        WebElement search = driver.findElement(By.xpath("//button[@class='btn-primary btn-action']"));
        search.click();
        WebElement checkInDate = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[2]"));
        if (checkInDate.getText().equals("Aug 14")){
            System.out.println("Date verification is Passed");
        }else{
            System.out.println("Date verification is Failed");
        }
        Thread.sleep(3000);
        WebElement checkOutDate = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[3]"));
        if(checkOutDate.getText().equals("Aug 15")){
            System.out.println("Date verification is Passed");
        }else{
            System.out.println("Date verification is Failed");
        }
    }
}
