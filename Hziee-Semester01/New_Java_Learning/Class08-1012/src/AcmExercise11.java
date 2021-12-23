import java.math.BigInteger;
import java.util.Scanner;

public class AcmExercise11 {
    public static void main(String[] args) {
        BigInteger[] num1 = new BigInteger[2];
        num1[0] = BigInteger.ONE;
        num1[1] = num1[0].add(num1[0]);
        Scanner getNum = new Scanner(System.in);
        while(getNum.hasNext())
        {
            BigInteger num2 = getNum.nextBigInteger();
            num2 = num2.multiply(num2.add(num1[0]));
            num2 = num2.divide(num1[1]);
            System.out.println(num2);
            System.out.println();
        }
    }
}
