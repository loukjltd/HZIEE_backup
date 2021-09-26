import java.util.Scanner;

public class Random10AddMathUsingContinueWithMarkNumber {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, j, getAnswer;
        int i, wrongTimes;

        Loop01:
        for (i = 0, j = 0; i < 10; i++) {
            num1 = (int) (Math.random() * 20);
            num2 = (int) (Math.random() * 20);
            System.out.printf("%d + %d = ", num1, num2);

            for (wrongTimes = 0; wrongTimes < 3; wrongTimes++) {
                getAnswer = getNum.nextInt();
                if (num1 + num2 == getAnswer) {
                    System.out.println("Good!");
                    j++;
                    continue Loop01;
                }
                System.out.println("Wrong!");
            }
        }
        System.out.printf("答对了%d题。", j);
    }
}
