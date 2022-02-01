package WebTest2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;

public class WebTest02 {

    protected WebDriver driver;

    @BeforeEach
    public void Setup() throws MalformedURLException
    {
        //chromedriver.exe -> Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\IT\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        // go to the website
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();
    }

    @Test
    void TestFormsPage()
    {
        //arrange
        // click on Form Menu to go to the Forms
        driver.findElement(By.cssSelector("a[aria-label='forms']")).click();


        //act

        WebElement submitButton = null;
        var buttons = driver.findElements(By.tagName("button"));
        for(WebElement button : buttons)
        {
            if(button.getText().equalsIgnoreCase("submit"))
            {
                submitButton = button;
                break;
            }
        }
        if(submitButton != null)
        {
            submitButton.click();
        }

        //driver.findElement(By.cssSelector("button[class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default']")).click();

        // assert


        Assertions.assertEquals("Your name is required",driver.findElement(By.id("name-err")).getText());
        Assertions.assertEquals("Your email is required",driver.findElement(By.id("email-err")).getText());
        Assertions.assertEquals("You must agree to continue",driver.findElement(By.id("agree-err")).getText());
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
