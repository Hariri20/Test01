package com.accesshq.test.strategies;

import com.accesshq.test.ui.PlanetTile;

public class NameMatch implements MatchingStrategy
{
    String name;

    public NameMatch(String name)
    {
        this.name = name;
    }
    @Override
    public Boolean match(PlanetTile planet) {
        if(planet.getPlanetName().equalsIgnoreCase(name))
        {
            return true;
        }
        return false;
    }
}
