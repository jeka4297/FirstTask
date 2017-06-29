/**
 * Created by qbolt42 on 28.06.17.
 */
public class Sinus implements IFunctionOfOneDoubleArg {

    private double a;
    private double b;
    private double left;
    private double right;

    public Sinus(double a, double b, double left, double right) {
        this.a = a;
        this.b = b;
        this.left = left;
        this.right = right;
    }

    public double getFunctionValue(double x) throws OversteppingException {
        if (x>=left && x<=right){
            return a*Math.sin(b*x);}
        else {throw new OversteppingException();}
    }

    public double getLeftBoard() {
        return left;
    }

    public double getRightBoard() {
        return right;
    }
}
