package WebTestSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.*;
import org.openqa.selenium.By;

import java.util.List;

public class PlanetTestSuit extends BaseTestSuit{
    protected Menu menu;
    /*
    @Test
    public void test01() throws InterruptedException
    {
        menu = new Menu(driver);
        menu.clickPlanet();
        String jupiterDistance = driver.findElement(By.cssSelector("ul[class='planets'] li:nth-child(5) dd.distance")).getText();
        Assertions.assertEquals("778,500,000 km", jupiterDistance);
    }

     */

    @Test
    public void test02() throws InterruptedException
    {
        menu = new Menu(driver);
        menu.clickPlanet();

        var planetPage = new PlanetPage(driver);
        var jupiter = planetPage.getPlanetByName("Jupiter");
        //System.out.println(jupiter.getDoubleDistance());

        Assertions.assertEquals("778,500,000 km",jupiter.getDistance());
        //System.out.println(jupiter.intDistance());
        Assertions.assertEquals(778500000,jupiter.intDistance());


    }


}


