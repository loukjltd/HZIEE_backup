import java.util.Scanner;

public class ExerciseElephant {
    public static void main(String[] args) {
        Scanner inputH = new Scanner(System.in);
        Scanner inputS = new Scanner(System.in);
        int getH, getS, getV, totalNum, finalNum = 0;

        getH = inputH.nextInt();
        getS = inputS.nextInt();

        getV = getH * getS;

        totalNum = getV / 20;
        if (getV % 20 == 0) {
            finalNum = totalNum;
        } else if (getV % 20 == 1) {
            finalNum = totalNum + 1;
        }
        System.out.println(finalNum);
    }
}
