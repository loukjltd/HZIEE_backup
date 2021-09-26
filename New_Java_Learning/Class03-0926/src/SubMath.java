import java.util.Scanner;

public class SubMath {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, num3;
        num1 = (int)(Math.random() * 20);
        num2 = (int)(Math.random() * 20);
        if (num1 < num2) {
            num3 = num1;
            num1 = num2;
            num2 = num3;
        }
        System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
    }
}
