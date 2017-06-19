package com.helpers;

import com.LifeForm;
import com.helpers.display.ConsoleRenderer;
import com.helpers.display.Renderer;
import com.strategy.NewGenerationStrategy;
import com.strategy.NextGenStrategy;

import java.awt.*;

/**
 * Created by vasilis on 14-6-17.
 */
public class WorldManager {

    private LifeForm[][] world;
    private Renderer renderer;

    public WorldManager(LifeForm[][] world){
        this.world = world;
        assignLifeFormLocations();
        renderer = new ConsoleRenderer();
    }
    private void assignLifeFormLocations(){
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                world[x][y].setLocation(new Point(x, y));
            }
        }
    }
    public final String render(){
        return renderer.renderWorld(world);
    }
    public final void createNextGeneration(java.util.List<NextGenStrategy> rules) {

        LifeForm[][] nextWorld = new LifeForm[world.length][world[0].length];
        NewGenerationStrategy newGenerationStrategy = new NewGenerationStrategy(world,rules);
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                nextWorld[x][y] = newGenerationStrategy.generateNextGen(world[x][y]);
            }
        }
        world= nextWorld;
        assignLifeFormLocations();
        renderer.renderWorld(world);
    }
}
