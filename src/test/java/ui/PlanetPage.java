package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanetPage
{
    private WebDriver driver;

    public PlanetPage(WebDriver driver)
    {
        this.driver = driver;
    }

   public PlanetTile getPlanetByName(String planetName)
   {
       PlanetTile foundPlanet = null;

       var planets =driver.findElements(By.className("planet"));

       for(WebElement planet: planets)
       {
           var currentPlanet = new PlanetTile(planet);
           if (currentPlanet.getPlanetName().equalsIgnoreCase(planetName))
           {
               foundPlanet = currentPlanet;
               break;
           }
       }

       if(foundPlanet == null){throw (new NotFoundException());}
           return foundPlanet;

   }

}
