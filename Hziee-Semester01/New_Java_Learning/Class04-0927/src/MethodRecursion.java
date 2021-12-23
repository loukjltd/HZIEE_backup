import java.util.Scanner;

public class MethodRecursion {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num = getNum.nextInt();
        System.out.printf("Fac of 4 is %d", fact(num));
    }

    static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }
}
