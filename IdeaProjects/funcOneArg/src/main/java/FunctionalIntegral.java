/**
 * Created by qbolt42 on 28.06.17.
 */
public class FunctionalIntegral implements IFunctionalAtOneArg {

    private double l;
    private double r;
    private double count;


    public FunctionalIntegral(double l,double r,int count){
        this.l=l;
        this.r=r;
        this.count=count;
    }

    public double calcFunctional(IFunctionOfOneDoubleArg fun) throws OversteppingException, WrongBoardsOfIntegrationException {
        if (l<fun.getLeftBoard() || r>fun.getRightBoard()){ throw new WrongBoardsOfIntegrationException();}
        double result=0;
        double h=(r-l)/count;
        for(int i =0;i<count; i++){
            result+=fun.getFunctionValue(l+h*(i+0.5));
        }
        result*=h;
        return result;
    }
}
