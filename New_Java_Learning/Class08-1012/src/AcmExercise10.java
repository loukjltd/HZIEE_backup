import java.math.BigInteger;
import java.util.Scanner;

public class AcmExercise10 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int getInteger = getNum.nextInt();

        for (int i = 1; i <= getInteger; i ++) {
            BigInteger num1 = getNum.nextBigInteger();
            BigInteger num2 = getNum.nextBigInteger();
            System.out.println("Case " + i + ":");
            System.out.println(num1 + " + " + num2 + " = " + num1.add(num2));
            if (i < getInteger) {
                System.out.println();
            }
        }
    }
}
