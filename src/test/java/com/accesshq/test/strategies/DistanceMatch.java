package com.accesshq.test.strategies;

import com.accesshq.test.ui.PlanetTile;

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
