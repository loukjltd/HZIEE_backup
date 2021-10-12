import java.util.Scanner;

public class AcmExercise09 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        while (getNum.hasNextInt()) {
            int num1 = getNum.nextInt();
            int num2 = 0;
            if (getNum.hasNextInt()) num2 = getNum.nextInt();
            System.out.println(num1 + num2);
        }
    }
}
