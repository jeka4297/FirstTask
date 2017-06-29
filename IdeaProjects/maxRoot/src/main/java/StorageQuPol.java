/**
 * Created by qbolt42 on 28.06.17.
 */
public class StorageQuPol {

    private double a;
    private double b;
    private double c;
    private int countOfRoots=2;

    public StorageQuPol(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double[] solveEquation() throws NoRouteException {

        Double[] solutions = new Double[countOfRoots];

        double D = b * b - 4 * a * c;

        if (a != 0) {
            if (D > 0) {
                solutions[0] = (-b - Math.sqrt(D)) / (2 * a);
                solutions[1] = (-b + Math.sqrt(D)) / (2 * a);
            } else {
                if (D == 0) {
                    solutions[0] = (-b / (2 * a));
                    solutions[1] = null;
                } else {
                    throw new NoRouteException("No roots");
                }
            }
        } else {
            if (b != 0) {
                solutions[0] = (-c / b);
                solutions[1] = null;
            } else {
                throw new NoRouteException("No roots, oops :<");
            }

        }
        return solutions;
    }


}
