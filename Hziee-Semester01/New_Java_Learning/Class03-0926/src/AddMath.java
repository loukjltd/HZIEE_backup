import java.util.Scanner;

public class AddMath {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2;
        num1 = (int)(Math.random()*20);
        num2 = (int)(Math.random()*20);
        System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
    }
}
