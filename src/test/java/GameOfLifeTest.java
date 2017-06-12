import com.GameOfLife;
import com.LifeForm;
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
public class GameOfLifeTest {
    GameOfLife SUT;
    LifeForm[][] startingGrid;
    LifeForm[][] wrongStartingGrid;


    @Before
    public void setUp() {
        startingGrid = new LifeForm[][]{
                {new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(true, "*", "_"), new LifeForm(false, "*", "-")},
                {new LifeForm(false, "*", "-"), new LifeForm(true, "*", "_"), new LifeForm(true, "*", "_"), new LifeForm(false, "*", "-")},
                {new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-")}
        };
        wrongStartingGrid = new LifeForm[][]{
                {new LifeForm(false, "-", "8"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-")},
                {new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-")},
                {new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-"), new LifeForm(false, "*", "-")}
        };

        List<NextGenStrategy> rules = new ArrayList<NextGenStrategy>();
        rules.add(new OverCrowdingStrategy());
        rules.add(new PreserveStrategy());
        rules.add(new RebornStrategy());
        rules.add(new UnderpopulationStrategy());
        SUT = new GameOfLife(startingGrid, rules);
        //Provide the two-dimensional world;
    }

    @Test
    public void renderWorld() {
        //Arrange
        String expected = "--*-\n" +
                "-**-\n" +
                "----\n";
        //Act
        String actual = SUT.renderWorld(startingGrid);

        //Assert
        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);

        SUT.createNextGeneration();
        SUT.renderWorld(SUT.getWorld());
    }

    @Test
    public void renderSecondGenWorld() {
        //Arrange
        String expected = "-**-\n" +
                "-**-\n" +
                "----\n";
        //Act
        SUT.createNextGeneration();
        String actual = SUT.renderWorld(SUT.getWorld());
        //Assert

        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);



    }
}
