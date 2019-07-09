package com.cybertekb11;

/*/
I want to be able to sort my hotels by the price.
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortHotelPriceByGulmiraKadyrova {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        sortHotelPriceMethod1(driver);
    }

    public static void sortHotelPriceMethod1(WebDriver driver) throws InterruptedException{
        driver.manage().window().fullscreen();
        driver.get("https://www.expedia.com/");
        WebElement hotels = driver.findElement(By.cssSelector("#tab-hotel-tab-hp"));
        hotels.click();
        WebElement goingTo = driver.findElement(By.xpath("//input[@data-city_element='hotel-destination-hp-hotel-city']"));
        goingTo.sendKeys("Chicago, Illinois");
        WebElement checkIn = driver.findElement(By.id("hotel-checkin-hp-hotel"));
        checkIn.click();
        WebElement checkInDate = driver.findElement(By.xpath("//button[@data-day='31'][1]"));
        checkInDate.click();
        WebElement checkOut = driver.findElement(By.id("hotel-checkout-hp-hotel"));
        checkOut.click();
        WebElement checkOutDate = driver.findElement(By.xpath("//button[@data-day='3']"));
        checkOutDate.click();
        WebElement search = driver.findElement(By.xpath("//button[@class='btn-primary btn-action  gcw-submit'][1]"));
        search.click();
        WebElement sortBy = driver.findElement(By.xpath("//input[@id='radio-sort-price']"));
        sortBy.click();
        if(sortBy.isSelected()){
            System.out.println("Sort by button verification is Passes");
        }else{
            System.out.println("Sort by button verification is Failed");
        }
        Thread.sleep(3000);
        WebElement sortByPrice = driver.findElement(By.xpath("//label[@for='radio-sort-price']"));
        if(sortByPrice.isDisplayed()){
            System.out.println("Price verification is Passed");
        }else{
            System.out.println("Price verification is Failed");
        }
    }
}
