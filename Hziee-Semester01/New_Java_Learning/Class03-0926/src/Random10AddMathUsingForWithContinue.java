import java.util.Scanner;

public class Random10AddMathUsingForWithContinue {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, getAnswer = 0;
        int i, j, flag;
        flag = 1;
        i = 0;

        while (i < 10) {
            num1 = (int) (Math.random() * 20);
            num2 = (int) (Math.random() * 20);
            if (num1 + num2 < 10) {
                continue;
            }
            System.out.printf("%d + %d = ", num1, num2);
            if (num1 + num2 != getAnswer) {
                flag = 0;
                break;
            }
            i ++;
        }
        if (flag == 1) {
            System.out.println("Congratulation!");
        } else {
            System.out.println("Failed!");
        }
    }
}
