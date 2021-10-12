import java.util.Scanner;

public class AcmExercise01 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);

        while (num.hasNext()) {
            int getNum1 = num.nextInt();
            int getNum2 = num.nextInt();
            System.out.println(getNum1 + getNum2);
        }
    }
}
