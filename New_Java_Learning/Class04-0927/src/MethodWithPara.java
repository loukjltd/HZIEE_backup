import java.util.Scanner;

public class MethodWithPara {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2;
        double result;
        num1 = getNum.nextInt();
        num2 = getNum.nextInt();
        result = fact(num1) / (fact(num2) * fact(num1 - num2));
        System.out.printf("%.0f\n", result);
    }

    static double fact(int j) {
        double randomNum = 1;
        for (int i = 1; i <= j; i ++) {
            randomNum = randomNum * i;
        }
        return randomNum;
    }
}
