import com.oracle.jrockit.jfr.InvalidValueException;
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
    FormOfLife[][] startingGrid;
    FormOfLife[][] wrongStartingGrid;


    @Before
    public void setUp() {
        startingGrid = new FormOfLife[][]{
                {new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(true, "*", "_"), new FormOfLife(false, "*", "-")},
                {new FormOfLife(false, "*", "-"), new FormOfLife(true, "*", "_"), new FormOfLife(true, "*", "_"), new FormOfLife(false, "*", "-")},
                {new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-")}
        };
        wrongStartingGrid = new FormOfLife[][]{
                {new FormOfLife(false, "-", "8"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-")},
                {new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-")},
                {new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-"), new FormOfLife(false, "*", "-")}
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
