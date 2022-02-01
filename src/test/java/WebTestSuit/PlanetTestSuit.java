package WebTestSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import strategies.DistanceMatch;
import strategies.NameMatch;
import ui.*;

public class PlanetTestSuit extends BaseTestSuit{
    protected Menu menu;


    @Test
    public void test02() throws InterruptedException
    {
        menu = new Menu(driver);
        menu.clickPlanet();

        var planetPage = new PlanetPage(driver);
        var jupiter = planetPage.getPlanetByName("Jupiter");

        Assertions.assertEquals("778,500,000 km",jupiter.getDistance());
        Assertions.assertEquals(778500000,jupiter.intDistance());

    }

    @Test
    public void NameTest()
    {
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        PlanetTile planet = planetPage.getPlanetTile(new NameMatch("Jupiter"));

        //assert
        Assertions.assertEquals(778500000,planet.intDistance());
        Assertions.assertEquals("Jupiter", planet.getPlanetName());

    }

    @Test
    public void DistanceMatchTest()
    {
        //Arrange
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        //Act
        PlanetTile planet = planetPage.getPlanetTile(new DistanceMatch(108_200_000));
        planet.ClickExploreButton();
        String planetName = planet.getPlanetName();
        String expected = "Exploring " +planetName;
        new WebDriverWait(driver,10).until(d -> planetPage.isPopupIsVisible());

        //Assert
        Assertions.assertEquals(expected, planetPage.getExploreMessage());

    }

    @Test
    public void Furthest()
    {
        //Arrange
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        //Act
        PlanetTile planet = planetPage.getFurthestDistancePlanet();

        //Assert
        Assertions.assertEquals("Uranus",planet.getPlanetName());

    }










}


