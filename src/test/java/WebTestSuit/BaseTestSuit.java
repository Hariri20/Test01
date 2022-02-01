package WebTestSuit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class BaseTestSuit
{
    protected WebDriver driver;

    @BeforeEach
    public void Setup() throws MalformedURLException
    {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\IT\\chromedriver_win32\\chromedriver.exe");
        // go to the website
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
