package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import strategies.MatchingStrategy;

public class PlanetPage
{
    private WebDriver driver;

    public PlanetPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public PlanetTile getPlanetTile(MatchingStrategy strategy)
    {
        var planetTiles = driver.findElements(By.className("planet"));

        for(WebElement tile: planetTiles)
        {
            PlanetTile planet = new PlanetTile(tile);
            if (strategy.match(planet))
            {
                return planet;
            }
        }
        throw new NotFoundException("Planet not found!");
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

    public Boolean isPopupIsVisible()
    {
        return driver.findElement(By.cssSelector(".snackbar")).isDisplayed();
    }


    public String getExploreMessage()
    {

        return driver.findElement(By.cssSelector(".snackbar")).getText();
    }

    public PlanetTile getFurthestDistancePlanet()
    {
        PlanetTile furthestPlanet = null;
        var planets =driver.findElements(By.className("planet"));
        long furthestDistance = 0;
        for(WebElement planet: planets)
        {
            var currentPlanet = new PlanetTile(planet);

            if (currentPlanet.intDistance() > furthestDistance)
            {
                furthestPlanet = currentPlanet;
                furthestDistance = currentPlanet.intDistance();
            }
        }
        if(furthestPlanet == null){throw (new NotFoundException());}
        return furthestPlanet;
    }
}
