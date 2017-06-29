/**
 * Created by qbolt42 on 28.06.17.
 */
public class QuadraticFunction implements IFunctionOfOneDoubleArg {

    private double a;
    private double b;
    private double c;
    private double d;
    private double left;
    private double right;

    public QuadraticFunction(double a, double b, double c, double d, double left, double right) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.left = left;
        this.right = right;
    }

    public double getFunctionValue(double x) throws OversteppingException {
        if (x>=left && x<=right){
            return (a*x+b)*(c*x+d);}
        else {throw new OversteppingException();}
    }

    public double getLeftBoard() {
        return left;
    }

    public double getRightBoard() {
        return right;
    }
}
