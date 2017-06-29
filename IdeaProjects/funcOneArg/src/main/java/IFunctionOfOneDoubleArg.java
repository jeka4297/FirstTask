/**
 * Created by qbolt42 on 28.06.17.
 */
public interface IFunctionOfOneDoubleArg {
    double getFunctionValue(double x) throws OversteppingException;
    double getLeftBoard();
    double getRightBoard();
}
