
import static junit.framework.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
public class TestFunctionalSum {

    @Test
    public void TestCalcFunctional_exponential() throws OversteppingException, WrongBoardsOfIntegrationException {
        IFunctionOfOneDoubleArg fun = new Exponential(4,5,2,5);
        FunctionalSum fu =new FunctionalSum();

        assertTrue(Math.abs(770.6706686407982-fu.calcFunctional(fun))<=0.00025);
    }




}
