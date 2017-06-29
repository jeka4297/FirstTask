/**
 * Created by qbolt42 on 28.06.17.
 */
public class LinearFunction implements IFunctionOfOneDoubleArg {

    private double a =3;
    private double b =8;
    private double left;
    private double right;

    public LinearFunction(double a, double b,double left,double right) {
        this.a=a;
        this.b=b;
        this.left=left;
        this.right=right;
    }

    public double getFunctionValue(double x) throws OversteppingException {
        if (x>=left && x<=right){
            return a*x+b;}
        else {throw new OversteppingException();}
    }

    public double getLeftBoard() {
        return left;
    }

    public double getRightBoard() {
        return right;
    }
}
