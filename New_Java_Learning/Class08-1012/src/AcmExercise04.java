import java.util.Scanner;

public class AcmExercise04{
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);

        while (true) {
            String numString = getNum.nextLine();
            String[] numArray = numString.split(" ");
            if (Integer.parseInt(numArray[0]) == 0) {
                break;
            } else {
                int totalNum = 0;
                for (int i = 1; i < numArray.length; i++) {
                    totalNum += Integer.parseInt(numArray[i]);
                }
                System.out.println(totalNum);
            }
        }
    }
}