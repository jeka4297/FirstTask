/**
 /**
 * Created by user on 5/2/17.
 */
import static junit.framework.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class TestLinearFunction {
    @Test
    public void TestGetFunctionValue_normal() throws OversteppingException {
        LinearFunction x1 = new LinearFunction(4,5,2,5);


        assertTrue( Math.abs(21-x1.getFunctionValue(4))< 0.0025);
    }
    @Test
    public void TestGetFunctionValue_outofboards() throws OversteppingException {
        LinearFunction x2 = new LinearFunction(4,5,2,5);


        try{ x2.getFunctionValue(1);
            fail();
        }
        catch (OversteppingException e){

        }
    }
}
