import java.util.Scanner;

public class AcmExercise03 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        while (getNum.hasNext()) {
            int getNum1 = getNum.nextInt();
            int getNum2 = getNum.nextInt();
            if (getNum1 == 0 && getNum2 == 0) {
                break;
            }
            System.out.println(getNum1 + getNum2);
        }

    }
}
