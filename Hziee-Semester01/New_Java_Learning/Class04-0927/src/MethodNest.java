import java.util.Scanner;

public class MethodNest {
    static double fact(int n) {
        double f = 1;
        for (int i = 1; i <= n; i++)
            f = f * i;
            return f;
    }
    static double comb(int m, int n) {
        return fact(m) / fact(n) / fact(m - n);
    }

    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2;
        num1 = getNum.nextInt();
        num2 = getNum.nextInt();
        System.out.printf("%.0f", comb(num1, num2));
    }
}
