import java.util.Scanner;

public class AddSubMultiMathUsingSwitch {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, test, option, getAnswer, realAnswer;
        num1 = (int) (Math.random() * 20);
        num2 = (int) (Math.random() * 20);
        option = (int) (Math.random() * 3);

        switch (option) {
            case 1:
                System.out.printf("%d + %d = ", num1, num2);
                realAnswer = num1 + num2;
                break;
            default:
                switch (option) {
                    case 2:
                        if (num1 < num2) {
                            test = num1;
                            num1 = num2;
                            num2 = test;
                        }
                        System.out.printf("%d - %d = ", num1, num2);
                        realAnswer = num1 - num2;
                        break;
                    default:
                        System.out.printf("%d * %d = ", num1, num2);
                        realAnswer = num1 * num2;
                }
        }

        getAnswer = getNum.nextInt();
        if (realAnswer == getAnswer) {
            System.out.println("Good!");
        } else {
            System.out.println("Wrong!");
            System.out.printf("The right answer is %d", realAnswer);
        }
    }
}
