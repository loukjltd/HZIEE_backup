import java.util.Scanner;

public class Random10AddMathUsingForWithBreak {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, getAnswer;
        int i, flag;
        flag = 1;

        for (i = 0; i < 10; i++) {
            num1 = (int) (Math.random() * 20);
            num2 = (int) (Math.random() * 20);
            System.out.printf("%d + %d = ", num1, num2);
            getAnswer = getNum.nextInt();
            if (num1 + num2 != getAnswer) {
                flag = 0;
                break;
            }
        }
        if (flag == 1){
            System.out.println("Congratulation!");
        } else {
            System.out.println("Failed!");
        }
    }
}
