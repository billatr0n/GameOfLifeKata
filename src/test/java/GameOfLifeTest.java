import com.GameOfLife;
import com.LifeForm;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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

        SUT = new GameOfLife(startingGrid);
        //Provide the two-dimensional world;
    }
    @Test
    public void renderWorld() {
        //Arrange
        String expected = "--*-\n" +
                "-**-\n" +
                "----\n";
        //Act
        String actual = SUT.renderGrid(startingGrid);

        //Assert
        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);
    }
}
