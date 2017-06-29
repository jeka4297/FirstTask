
public class MRootOfEquation {

    private  StorageQuPol equ;

    public MRootOfEquation(double i, double i1, double i2) {
        equ=new StorageQuPol(i,i1,i2);
    }

    public double getMaxRoot() throws NoRouteException {
        Double[] res = equ.solveEquation();
        if (res[1] == null) {
            return res[0];
        }
        else {
            if (res[1]>=res[0]) {
                return res[1];
            }
            else {
                return res[0];
            }

        }
    }

}