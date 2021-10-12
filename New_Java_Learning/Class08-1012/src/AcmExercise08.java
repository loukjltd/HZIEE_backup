import java.util.Scanner;

public class AcmExercise08 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int howManyLines, targetNum, nextNum, totalNum;
        howManyLines = getNum.nextInt();
        while(howManyLines --> 0) {
            targetNum = getNum.nextInt();
            totalNum = 0;
            for (int i = 0; i < targetNum; i ++) {
                nextNum = getNum.nextInt();
                totalNum = totalNum + nextNum;
            }
            System.out.println(totalNum);
            if (howManyLines != 0) {
                System.out.println();
            }
        }
    }
}
