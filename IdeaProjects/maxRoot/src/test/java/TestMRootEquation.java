import junit.framework.TestCase;
import junit.framework.TestSuite;
import static junit.framework.Assert.*;
import org.junit.Test;

public class TestMRootEquation {
    @Test
    public void testGetMaxRoot_oneRoot() throws NoRouteException{
        MRootOfEquation eq1 = new MRootOfEquation(1,2,1);
        assertTrue(eq1.getMaxRoot() == -1);
    }
    @Test
    public void testGetMaxRoot_twoRoots() throws NoRouteException{
        MRootOfEquation eq2 = new MRootOfEquation(1,2,-3);
        assertTrue(eq2.getMaxRoot() == 1);
    }
    @Test
    public void testGetMaxRoot_noRoots() throws NoRouteException{
        MRootOfEquation eq3 = new MRootOfEquation(1,2,3);
        try {
            eq3.getMaxRoot();
            fail();
        }
        catch (NoRouteException e)
        {
        }
    }
}
