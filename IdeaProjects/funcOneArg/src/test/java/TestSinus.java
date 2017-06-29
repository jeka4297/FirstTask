import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class TestSinus {
    @Test
    public void TestGetFunctionValue_normal() throws OversteppingException {
        Sinus x1 = new Sinus(4,5,2,5);


        assertTrue( Math.abs(3.6517810029-x1.getFunctionValue(4))< 0.0025);
    }
    @Test
    public void TestGetFunctionValue_outofboards() throws OversteppingException {
        Sinus x2 = new Sinus(4,5,2,5);


        try{ x2.getFunctionValue(1);
            fail();
        }
        catch (OversteppingException e){

        }
    }
}