package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {
    private WebDriver driver;

    public FormsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setName(String name)
    {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String name)
    {
        driver.findElement(By.id("email")).sendKeys(name);
    }

    public void openStateComboBox()
    {
        driver.findElement(By.cssSelector("div.v-select__selections")).click();
    }

    public void SelectState(String state)
    {
        driver.findElement(By.xpath("//div[contains(text(),'"+state+"')]")).click();
    }

    public void selectAgree()
    {
        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();
    }

    public void clickSubmit()
    {
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
    }



    public String getNameErrorMessage()
    {
        return driver.findElement(By.id("name-err")).getText();
    }

    public String getEmailErrorMessage()
    {
        return driver.findElement(By.id("email-err")).getText();
    }
    public String getNameAgreeMessage()
    {
        return driver.findElement(By.id("agree-err")).getText();
    }


    public boolean isPopupIsVisible()
    {
        return driver.findElement(By.cssSelector(".snackbar")).isDisplayed();
    }

    public String getPopupMessage()
    {
        return driver.findElement(By.cssSelector(".snackbar")).getText();
    }
}
