import java.util.Scanner;

public class AcmExercise07 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        while (getNum.hasNext()) {
            int num1 = getNum.nextInt();
            int num2 = getNum.nextInt();
            System.out.println(num1 + num2);
            System.out.println();
        }
    }
}
