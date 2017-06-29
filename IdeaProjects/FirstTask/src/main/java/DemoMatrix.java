import java.io.*;

/**
 * Created by qbolt42 on 28.06.17.
 */
public class DemoMatrix {

    public void newMatrix(Matrix n) throws IOException{
        DataOutputStream file = new DataOutputStream(new FileOutputStream("/home/qbolt42/jojka") );
        for (int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){
                file.writeDouble(n.getElem(i,j));
            }
        }
    }


    public void editFile(Matrix n) throws IOException{
        FileWriter writer = new FileWriter("/home/qbolt42/jojka", false);
        for (int i=0; i < n.getSize(); i++){
            for (int j=0; j < n.getSize(); j++){

                writer.write( String.valueOf( n.getElem(i,j) ) );
                writer.write(" ");
            }
            writer.write("\n");
        }
        writer.flush(); //flush -
    }


    public void readFile(Matrix n) throws IOException{
        String str = "";
        Reader reader = new FileReader( "/home/qbolt42/jojka");
        int data = reader.read();
        int c = 0;
        while (data != -1){
            if (c == 0){
                c++;
                str += (char)data;
            }
            data = reader.read();
            str += (char)data;
        }
        String[] arr = str.split("\n");
        str= "";
        for (int i=0; i < arr.length; i++){
            str += arr[i];
        }
        String[] parts = str.split(" ");
        double temp;
        for (int i = 0; i < parts.length - 1; i++){
            temp = Double.parseDouble( parts[i] );
            n.set(i, temp);
        }
    }


    public double sumElem (Matrix n){
        double sum = 0;
        for (int i=0; i < n.getSize(); i++){
            for (int j=0; j <n.getSize(); j++){
                sum += n.getElem(i,j);
            }
        }
        return sum;
    }



    public void serializable (Matrix n) throws IOException{
        FileOutputStream ash = new FileOutputStream( "tmp.out");
        ObjectOutputStream oos = new ObjectOutputStream(ash);
        oos.writeObject(n);
        oos.flush();
        oos.close();
    }


    public Matrix unSerializable() throws ClassNotFoundException, IOException{
        FileInputStream dek = new FileInputStream("tmp.out");
        ObjectInputStream oi = new ObjectInputStream(dek);
        Matrix m = (Matrix)oi.readObject();
        return m;
    }


    public static void main(String[] args) throws ClassNotFoundException,IOException{
        DemoMatrix demo = new DemoMatrix();
        Matrix mtr = new Matrix(3);
        Matrix mat;
        double[] ar = {1,2,3,4,5,6,7,8,9};
        Matrix mttr = new Matrix(3, ar);
        demo.editFile(mttr);
        demo.readFile(mtr);
        mtr.showMtr();
        mttr.det();
        System.out.println( mttr.getDetermin() );
        //demo.serializable(mttr);
        //mat = demo.unSerializable();
        //mat.showMtr();

    }
}
