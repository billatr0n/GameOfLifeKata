package com;

import com.strategy.NewGenerationStrategy;
import com.strategy.NextGenStrategy;

import java.awt.*;
import java.util.List;

/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {

    private List<NextGenStrategy> rules;
    private LifeForm[][] world;

    public GameOfLife(LifeForm[][] world, List<NextGenStrategy> rules) {
        this.rules = rules;
        setWorld(world);
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                world[x][y].setLocation(new Point(x, y));
            }
        }
    }

    public String renderWorld(LifeForm[][] world) {
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                buffer.append(world[x][y].printExistence());
            }
            buffer.append("\n");
        }
        String gridString = buffer.toString();
        System.out.println(gridString);
        return gridString;

    }

    public LifeForm[][] getWorld() {
        return world;
    }

    public void createNextGeneration() {

        LifeForm[][] nextWorld = new LifeForm[getWorld().length][getWorld()[0].length];
        NewGenerationStrategy newGenerationStrategy = new NewGenerationStrategy(getWorld(), rules);
        for (int x = 0; x < getWorld().length; x++) {
            for (int y = 0; y < getWorld()[0].length; y++) {
                nextWorld[x][y] = newGenerationStrategy.generateNextGen(getWorld()[x][y]);
                nextWorld[x][y].setLocation(new Point(x,y));
            }
        }
        setWorld(nextWorld);
    }

    public void setWorld(LifeForm[][] world) {
        this.world = world;
    }

}

