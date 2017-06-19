package com;

import com.helpers.WorldManager;
import com.strategy.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vasilis on 19-6-17.
 */
public class GameOfLifeTest {

    GameOfLife SUT;
    LifeForm[][] startingGrid;
    List<NextGenStrategy> rules;

    @Before
    public void setUp() throws Exception {
        startingGrid = new LifeForm[][]{
                {new LifeForm(false), new LifeForm(false), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(true), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(false), new LifeForm(false), new LifeForm(false), new LifeForm(false)}
        };

        rules = new ArrayList<NextGenStrategy>();
        rules.add(new OverCrowdingStrategy());
        rules.add(new PreserveStrategy());
        rules.add(new RebornStrategy());
        rules.add(new UnderpopulationStrategy());
    }
    @Test
    public void integration(){
        SUT = new GameOfLife(startingGrid, rules);
    }

}