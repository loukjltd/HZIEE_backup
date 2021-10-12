import java.util.Scanner;

public class AcmExercise02 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int timesNum = getNum.nextInt();
        int times = 1;
        while (times <= timesNum) {
            int getNum1 = getNum.nextInt();
            int getNum2 = getNum.nextInt();
            System.out.println(getNum1 + getNum2);
            times = times + 1;
        }
    }
}
