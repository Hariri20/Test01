package com.accesshq.test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile {
    protected WebElement element;

    public PlanetTile(WebElement el)
    {
        this.element = el;
    }

    public String getPlanetName()
    {

       return element.findElement(By.tagName("h2")).getText();

    }

    public String getDistance()
    {
        return element.findElement(By.cssSelector(".distance")).getText();
    }

    public Long intDistance()
    {
        String distance = element.findElement(By.cssSelector(".distance")).getText();
        String[] distanceText = distance.split("k");

        //int intDistance = Integer.parseInt((distanceText[0].replace(",","").trim()));
        Long intDistance = Long.parseLong((distanceText[0].replace(",","").trim()));
        return intDistance;
    }

    public void ClickExploreButton()
    {
        element.findElement(By.tagName("button")).click();

    }
}
