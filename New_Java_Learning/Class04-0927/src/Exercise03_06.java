import java.util.Scanner;

public class Exercise03_06 {
    public static void main(String[] args) {
        Scanner stuScore =new Scanner(System.in);
        double maxScore = 0;

        int nums = stuScore.nextInt();
        double [] scoresList = new double [nums];

        for (int i = 0; i < nums ; i ++) {
            scoresList[i] = stuScore.nextInt();

            if(scoresList[i] > maxScore) {
                maxScore = scoresList[i];
            }
        }
        System.out.println(maxScore);
    }
}
