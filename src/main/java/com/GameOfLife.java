package com;

import com.helpers.WorldManager;
import com.strategy.NextGenStrategy;

import java.util.List;

/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {

    private WorldManager worldManager;

    public GameOfLife(LifeForm[][] world, List<NextGenStrategy> rules) {
        worldManager = new WorldManager(world);
        worldManager.createNextGeneration(rules);

    }
}

