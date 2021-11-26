public class Equation {
    double a, b, c;
    int rootType;
    double root1, root2;

    public Equation(double floatA, double floatB, double floatC) {
        a = floatA;
        b = floatB;
        c = floatC;
    }

    public void Solving() {
        root1 = ((0 - b) + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        root2 = ((0 - b) - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        System.out.println(root1);
        System.out.println(root2);
    }

    public static void main(String[] args) {
        Equation e01 = new Equation(1, 2, 3);
        e01.Solving();
    }
}
