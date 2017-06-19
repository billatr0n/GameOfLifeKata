package com.strategy;

import com.LifeForm;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by vasilis on 7-6-17.
 */
@RunWith(JUnitParamsRunner.class)
public class PreserveStrategyTest {

    PreserveStrategy SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new PreserveStrategy();

    }
    private static Object[] strategySuccessfulLocations() {
        LifeForm[][] initialWorld = new LifeForm[][]{
                {new LifeForm(false), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(true), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(true), new LifeForm(true), new LifeForm(false)}
        };

        return new Object[]{
                new Object[]{initialWorld, 2,0},
        };
    }

    private static Object[] nonStrategySuccessfulLocations() {
        LifeForm[][] initialWorld = new LifeForm[][]{
                {new LifeForm(false), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(true), new LifeForm(true), new LifeForm(false)},
                {new LifeForm(true), new LifeForm(true), new LifeForm(false)}
        };

        return new Object[]{

                new Object[]{initialWorld, 0,0},
                new Object[]{initialWorld, 0,2},
                new Object[]{initialWorld, 2,2},
                new Object[]{initialWorld, 1,2},
        };
    }

    @Test
    @Parameters(method="strategySuccessfulLocations")
    public void strategyApplies(LifeForm[][] grid, int posX , int posY){
        //arrange
        final boolean expected = true;

        //act
        final boolean actual = SUT.strategyApplies(grid,posX, posY);

        //assert
        Assert.assertEquals("Not the same",expected, actual);

    }
    @Test
    @Parameters(method="nonStrategySuccessfulLocations")
    public void strategyDoesNoApply(LifeForm[][] grid, int posX , int posY){
        //arrange
        final boolean expected = false;

        //act
        final boolean actual = SUT.strategyApplies(grid,posX, posY);

        //assert
        Assert.assertEquals("Not the same",expected, actual);

    }

}