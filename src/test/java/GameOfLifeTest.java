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
    int[][] startingGrid;
    int[][] wrongStartingGrid;

    @Before
    public void setUp() {
        startingGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        wrongStartingGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        SUT = new GameOfLife(startingGrid);
        //Provide the two-dimensional world;
    }

    @Test
    public void renderWorld() {
        //Arrange
        String expected = "----------\n" +
                          "----------\n" +
                          "------*---\n" +
                          "-----**---\n" +
                          "----------\n";
        //Act
        String actual = SUT.renderGrid(startingGrid);

        //Assert
        Assert.assertEquals("The world needs to be rendered properly.", expected, actual);
    }

    @Test(expected=NumberFormatException.class)
    public void renderWorldCatchExceptionsForInputOtherThanZerosAndOnes() {
        //Arrange

        //Act
        String actual = SUT.renderGrid(wrongStartingGrid);
    }
}
