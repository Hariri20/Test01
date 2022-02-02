package com.accesshq.test.WebTest2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.util.Locale;




public class WebTest {

    protected WebDriver driver;

    @BeforeEach
    public void Setup() throws MalformedURLException
    {
        /*
        //For selenium driver

        var chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        */

        //chromedriver.exe -> Chrome browser
       // System.setProperty("webdriver.chrome.driver", "C:\\IT\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        // go to the website
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();

    }


    @Test
    void TestFormsPageTest()
    {
        // click on Form Menu to go to the Forms
        driver.findElement(By.cssSelector("a[aria-label='forms']")).click();


        // act
        /*
        WebElement element = driver.findElement(By.id("name"));
        Assertions.assertEquals(element.getAttribute("name").toLowerCase(Locale.ROOT),"name");
        */

        driver.findElement(By.id("name")).sendKeys("Iman");
        driver.findElement(By.id("email")).sendKeys("iman@email.com");

        //driver.findElement(By.xpath("(//i[normalize-space()='arrow_drop_down'])[1]")).click(); //first version with arrow and xpath
        driver.findElement(By.cssSelector("div.v-select__selections")).click();



        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupted Exception Happened!!");
        }

        //Selecting VIC from Dropdown list
        //driver.findElement(By.xpath("//div[contains(text(),'VIC')]")).click();  //first version with xpath
        driver.findElement(By.id("list-item-101-1")).click();


        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();

        //driver.findElement(By.xpath("//span[text()='submit']")).click();  //first version with xpath
        driver.findElement(By.cssSelector("button[class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default']")).click();





    }


    @AfterEach
    public void cleanup()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }


}