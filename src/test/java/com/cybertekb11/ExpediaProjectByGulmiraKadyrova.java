package com.cybertekb11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpediaProjectByGulmiraKadyrova  {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        SortHotelPriceByGulmiraKadyrova.sortHotelPriceMethod1(driver);
        VacationRentalsByGulmiraKadyrova.vacationRentalsSearchMethod2(driver);
        HotelReviewsAndRatingByGulmiraKadyrova.hotelReviewAndRatingMethod3(driver);
    }
}
