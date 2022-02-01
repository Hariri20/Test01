package strategies;

import ui.PlanetTile;

public class DistanceMatch implements MatchingStrategy
{
    long distance;

    public DistanceMatch(long distance)
    {
        this.distance = distance;
    }

    public Boolean match(PlanetTile planetTile)
    {
        if(planetTile.intDistance() == distance)
        {
            return true;
        }
        return false;
    }
}
