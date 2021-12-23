import java.util.Scanner;

public class Random10AddMathUsingBreakWithMarkNumber {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, j, getAnswer;
        int i, wrongTimes, totalTimes;
        totalTimes = 0;

        Loop01:
        for (i = 0, j = 0; i < 10; i++) {
            num1 = (int) (Math.random() * 20);
            num2 = (int) (Math.random() * 20);
            System.out.printf("%d + %d = ", num1, num2);

            Loop02:
            for (wrongTimes = 0; wrongTimes < 3; wrongTimes++) {
                getAnswer = getNum.nextInt();
                if (num1 + num2 == getAnswer) {
                    System.out.println("Good!");
                    j ++;
                    break Loop02;
                } else {
                    System.out.println("Wrong!");
                    if (++totalTimes == 10) {
                        break Loop01;
                    }
                }
            }
            if (totalTimes < 10) {
                System.out.println("Pass.");
            } else {
                System.out.println("Failed.");
            }
        }
    }
}
