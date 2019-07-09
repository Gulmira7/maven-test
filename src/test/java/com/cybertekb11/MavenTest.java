package com.cybertekb11;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenTest {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();
            Faker faker = new Faker();
            driver.get("https://google.com");

            driver.findElement(By.name("q")).
                    sendKeys(faker.name().name() + Keys.ENTER);



            Thread.sleep(60000);
            driver.close();
        }
    }

