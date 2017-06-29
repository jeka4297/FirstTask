/**
 * Created by qbolt42 on 28.06.17.
 */
public class FunctionalSum implements IFunctionalAtOneArg {

    public FunctionalSum(){}

    public double calcFunctional(IFunctionOfOneDoubleArg fun) throws OversteppingException, WrongBoardsOfIntegrationException {
        double right=fun.getRightBoard();
        double left=fun.getLeftBoard();
        double mid=(right+left)/2;
        return  fun.getFunctionValue(right) + fun.getFunctionValue(left) + fun.getFunctionValue(mid);
    }
}
