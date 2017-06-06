import com.LifeForm;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by vasilis on 6-6-17.
 */

@RunWith(JUnitParamsRunner.class)
public class LifeFormTest {
    LifeForm ALIVE_SUT;
    LifeForm DEAD_SUT;
    public static final String DEAD_STRING ="-";
    public static final String ALIVE_STRING ="*";

    @Before
    public void setUp() {
        ALIVE_SUT = new LifeForm(true,ALIVE_STRING, DEAD_STRING);
        DEAD_SUT = new LifeForm(false,ALIVE_STRING, DEAD_STRING);

    }

    @Test
    public void renderAliveLifeForm() {
        //Prepare
        String expected =  ALIVE_STRING;

        //act
        String actual = ALIVE_SUT.printExistence();

        //Assert
        Assert.assertEquals("Alive form should reply with *", expected, actual);

    }
    @Test
    public void renderDeadLifeForm() {
        //Prepare
        String expected =  DEAD_STRING;

        //act
        String actual = DEAD_SUT.printExistence();

        //Assert
        Assert.assertEquals("Dead form should reply with *", expected, actual);

    }
}
