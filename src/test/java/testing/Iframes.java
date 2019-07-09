package testing;
//1.Create	a	new	class	called:	IframePractice
// 2.Create	new	test	and	make	set	ups
// 3.Go	to	:http://practice.cybertekschool.com/iframe
// 4.Assert:“Your	content	goes	here.”Text	is	displayed.
// 5.Assert:“An	iFrame	containingthe	TinyMCE	WYSIWYG	Edit*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }
    @Test
    public void iframeTest(){
        driver.switchTo().frame("mce_0_ifr");
        String actualTextInsideIframe = driver.findElement(By.xpath("//p")).getText();
        String expectedtext = "Your content goes here.";
        Assert.assertEquals(actualTextInsideIframe,expectedtext);
        driver.switchTo().parentFrame();
        String actualHeadertext = driver.findElement(By.xpath("//h3")).getText();
        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeadertext,expectedHeaderText, "header text is not matching");
    }
}
