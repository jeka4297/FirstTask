/**
 * Created by qbolt42 on 28.06.17.
 */
public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    private double[] invMtr;
    private final int size;

    public InvertableMatrix(int n){
        super(n);
        invMtr = new double[n*n];
        size = n;
    }

    public void SetIdentityMtr(){
        for(int i = 0; i < size; i++){
            invMtr[size*i+i] = 1;
        }
    }


    public double GetEl(int i, int j){
        return invMtr[size * i + j];
    }

    public void SetEl(int i, int j, double elem){
        invMtr[size * i + j] = elem;
    }


    public int TopOnes() {

        double temp;

        for (int x = 0; x < size - 1; x++) {
            if (Math.abs(get(x, x)) < 0.0001) {
                int check = NonZeroFinding(x);
                if (check == -1) {
                    return -1;
                }
                swap(x, check);
                for (int i = 0; i < size; i++) {
                    temp = GetEl(x, i);
                    SetEl(x, i, GetEl(check, i));
                    SetEl(check, i, temp);
                }
            }
            for (int i = x + 1; i < size; i++) {
                double a = get(i, x) / get(x, x);
                gauss(x, i, a);
                for (int j = 0; j < size; j++) {
                    invMtr[size * i + j] -= invMtr[size * x + j] * a;
                }
            }
        }
        return 0;
    }


    public void BotOnes(){
        double temp;
        for (int i = 0; i < size; i++){
            if (Math.abs(get(i,i)) - 1 > 0.001 || get(i,i) < 0){
                temp = get(i,i);
                for (int j = 0; j < size; j++){
                    invMtr[size * i + j] /= temp;
                    clone[size * i + j] /= temp;
                }
            }
        }

        for (int x = size - 1; x > 0; x--){
            for (int i = x - 1; i >= 0; i--){
                double a = get(i,x) / get(x,x);
                gauss(x, i, a);
                for (int j = 0; j < size; j++){
                    invMtr[size * i + j] -= invMtr[size * x + j] * a;
                }
            }
        }
    }


    public int getInvMtr() {
        if (Math.abs(det()) <= 0.0001 ){
            return -1;
        }

        copyMtr();
        SetIdentityMtr();
        TopOnes();
        BotOnes();
        return 0;
    }


}
