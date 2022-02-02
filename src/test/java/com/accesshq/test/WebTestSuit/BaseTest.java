package com.accesshq.test.WebTestSuit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeEach
    public void Setup() throws MalformedURLException
    {
        /*
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\IT\\chromedriver_win32\\chromedriver.exe");
        // go to the website
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();
    */
        var chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"),chromeOptions);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();
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
