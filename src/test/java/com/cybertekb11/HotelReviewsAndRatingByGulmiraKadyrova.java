package com.cybertekb11;

/*
I want to see the number of reviews and rating of each hotel/
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HotelReviewsAndRatingByGulmiraKadyrova {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        hotelReviewAndRatingMethod3(driver);
    }
    public static void hotelReviewAndRatingMethod3(WebDriver driver)throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("https://www.expedia.com/");
        WebElement hotels = driver.findElement(By.cssSelector("#tab-hotel-tab-hp"));
        hotels.click();
        Thread.sleep(3000);
        WebElement goingTo = driver.findElement(By.xpath("//input[@data-city_element='hotel-destination-hp-hotel-city']"));
        goingTo.sendKeys("Chicago, Illinois");
        WebElement checkIn = driver.findElement(By.id("hotel-checkin-hp-hotel"));
        checkIn.click();
        Thread.sleep(3000);
        WebElement checkInDate = driver.findElement(By.xpath("//button[@data-day='31'][1]"));
        checkInDate.click();
        Thread.sleep(3000);
        WebElement checkOut = driver.findElement(By.id("hotel-checkout-hp-hotel"));
        checkOut.click();
        Thread.sleep(3000);
        WebElement checkOutDate = driver.findElement(By.xpath("//button[@data-day='3']"));
        checkOutDate.click();
        WebElement search = driver.findElement(By.xpath("//button[@class='btn-primary btn-action  gcw-submit'][1]"));
        search.click();
        Thread.sleep(3000);
        List<WebElement> listReviewAndRating = driver.findElements(By.cssSelector(".listing__reviews"));
        boolean check = false;
        for (WebElement list: listReviewAndRating) {
            if (!list.isDisplayed()) {
                System.out.println("List of Reviews and Ratings are Failed");
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("List of Reviews and Ratings are Passed");
        }
    }
}
