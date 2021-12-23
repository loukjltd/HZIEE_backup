import java.util.Scanner;

public class Random10AddMathUsingWhile {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int num1, num2, getAnswer;
        int i, j;
        i = 0;
        j = 0;

        while (i < 10) {
            num1 = (int) (Math.random() * 20);
            num2 = (int) (Math.random() * 20);
            System.out.printf("%d + %d = ", num1, num2);
            getAnswer = getNum.nextInt();
            if (num1 + num2 == getAnswer) {
                j ++;
            }
            i ++;
        }

        System.out.printf("恭喜你！你做对了%d题！", j);
    }
}
