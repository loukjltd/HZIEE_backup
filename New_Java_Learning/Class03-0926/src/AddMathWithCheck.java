import java.util.Scanner;

public class AddMathWithCheck {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, result;
        num1 = (int)(Math.random() * 20);
        num2 = (int)(Math.random() * 20);
        System.out.printf("%d + %d = ", num1, num2);
        result = getNum.nextInt();
        if (num1 + num2 == result) {
            System.out.println("Good!");
        } else {
            System.out.println("Wrong!");
            System.out.printf("The right answer is %d !", num1 + num2);
        }
    }
}
