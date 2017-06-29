import java.util.Arrays;

/**
 * Created by qbolt42 on 28.06.17.
 */
public class Matrix implements IMatrix {

    private int N; //размерность
    private double[] matrix;
    private double determin;
    private boolean flag;
    protected double[] clone;

    public Matrix(int N) {
        matrix = new double[N*N];
        clone = new double[N*N];
        this.N = N;
    }


    public Matrix(int N, double[] ar) {
        matrix = new double[N*N];
        clone = new double[N*N];
        for(int i=0; i < N*N; i++ ){
            matrix[i] =ar[i];
        }
    }


    public void setMatrix(double[] ar){
        for(int i=0; i < N; i++){
            for (int j=0; j < N; j++){
                matrix[N*i+j] = ar[N*i+j];
            }
        }
    }


    public int getSize(){
        return N;
    }


    public void setElem(int i, int j, double value) {
        int index = N*i+j;
        if (matrix[index] != value) {
            flag = false;
        }
        matrix[index] = value;
    }


    public void set(int i, double elem){
        if(matrix[i] != elem){
            flag = false;
            matrix[i]  =elem;
        }
    }

    public double get(int i, int j){
        int index = N*i+j;
        return clone[index];
    }


    public double getElem(int i, int j) {
        int index = N*i+j;
        return matrix[index];

    }


    public void copyMtr(){
        for(int i =0; i < N;  i++){
            for (int j=0; j < N; j++){
                clone[N*i+j] = getElem(i,j);
            }
        }
    }


    public void swap(int k, int l){
        double temp;
        for (int i=0; i < N; i++){
            temp = get(k,i);
            clone[N*k+i] = clone[N*l+i];
            clone[N*l+i] = temp;
        }
    }


    public void gauss(int k, int l, double a){
        for (int i =0; i <  N; i++) {
            clone[N*l+i] -= clone[N*k+i] * a;
        }

    }

    public int NonZeroFinding(int j) {
        for (int i = j + 1; i < N; i++) {
            if (Math.abs(get(i, j)) > 0) {
                return i;
            }
        }
        return -1;
    }



    private double triangle(){
        double d = 1 ;
        for (int x=0; x< N-1; x++ ){
            if(Math.abs( get(x,x) ) < 0.0001){
                int check = NonZeroFinding(x);
                if (check == -1){
                    return 0;
                }
                swap(x, check);
                d= -d;
            }
            for (int i=x+1; i < N; i++){
                double a= get(i,x) / get(x,x);
                gauss(x, i, a);
            }
        }
        return d;
    }



    public double det() {
        copyMtr();
        double d = 1;
         d *= triangle();
         for (int i = 0; i<N; i++){
             d*=get(i,i);
         }
         determin = d;
        flag = true;
        return d;
    }


    public double getDetermin(){
        return determin;
    }


    public boolean checkFalg(){
        return flag;
    }



    public void showMtr(){
        for (int i=0; i < N; i++){
            for (int j=0; j < N; j++){
                System.out.print( getElem(i,j) + " " );
            }
            System.out.println();
        }
    }


    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null || getClass() != o.getClass() ) return  false;

        Matrix mtr = (Matrix)o;

        if (N != mtr.N) return  false;

        return Arrays.equals(matrix, mtr.matrix);
    }




    @Override
    public int hashCode() {
        int result;
        long temp;

        result =  Arrays.hashCode(clone);
        result = 31 * result + Arrays.hashCode(matrix);
        result = 31 * result + N;

        temp = Double.doubleToLongBits(determin);

        result = 31 * result + (int) (temp ^ (temp >>> 32) );
        result = 31 * result + (flag ? 1 : 0);

        return result;
    }

}
