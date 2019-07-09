package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void informationTest() {
         driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
         Alert alert = driver.switchTo().alert();
         alert.accept();
         String actualText = driver.findElement(By.id("result")).getText();
         String expectedText = "You successfuly clicked an alert";
        Assert.assertEquals(actualText, expectedText, "Texts in first test does not match");

    }
    @Test(priority = 1)
        public void javaConfirm() {
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            String actualText = driver.findElement(By.id("result")).getText();
            String expectedText = "You clicked: Ok";
            Assert.assertTrue(actualText.equals(expectedText), "Text in second text does not match");

        }
        @Test
    public void javaPrompt() throws InterruptedException{
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
        alert.sendKeys("hello");
        alert.accept();
        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You entered: hello";
        Assert.assertTrue(actualText.equals(expectedText), "Text in second text does not match");

        }
    }


