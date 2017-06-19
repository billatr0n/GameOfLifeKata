package com.helpers;

import com.GameOfLife;
import com.LifeForm;
import com.helpers.WorldManager;
import com.strategy.*;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasilis on 30-5-17.
 */

@RunWith(JUnitParamsRunner.class)
public class WorldManagerTest {
    WorldManager SUT;
    LifeForm[][] startingGrid;
    LifeForm[][] wrongStartingGrid;
    List<NextGenStrategy> rules;

    @Before
    public void setUp() {
        startingGrid = new LifeForm[][]{
                {new LifeForm(false), new LifeForm(false), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(true), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(false), new LifeForm(false), new LifeForm(false)}
        };
        wrongStartingGrid = new LifeForm[][]{
                {new LifeForm(false), new LifeForm(false), new LifeForm(false), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(false), new LifeForm(false), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(false), new LifeForm(false), new LifeForm(false)}
        };

        rules = new ArrayList<NextGenStrategy>();
        rules.add(new OverCrowdingStrategy());
        rules.add(new PreserveStrategy());
        rules.add(new RebornStrategy());
        rules.add(new UnderpopulationStrategy());
        SUT = new WorldManager(startingGrid);
    }

    @Test
    public void renderWorld() {
        //Arrange
        String expected = "--*-\n" +
                "-**-\n" +
                "----\n";
        //Act
        String actual =SUT.render();

        //Assert
        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);


    }

    @Test
    public void renderSecondGenWorld() {
        //Arrange
        String expected = "-**-\n" +
                "-**-\n" +
                "----\n";
        //Act
        SUT.createNextGeneration(rules);
        String actual =SUT.render();
        //Assert

        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);



    }
}
