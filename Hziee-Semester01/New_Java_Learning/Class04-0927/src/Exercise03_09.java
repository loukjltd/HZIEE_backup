import java.util.Scanner;

public class Exercise03_09 {
    public static void main(String[] args) {
        Scanner getNum = new Scanner(System.in);
        int i;
        int getScore;
        int maxScore = 0;
        int testMaxScore;
        int minScore = 0;
        int testMinScore;
        int totalScore = 0;
        double averageScore;
        int count = getNum.nextInt();
        for (i = 0; i < count; i ++) {
            getScore = getNum.nextInt();
            testMaxScore = getScore;
            testMinScore = getScore;
            if (testMaxScore >= maxScore) {
                maxScore = testMaxScore;
            }
            if (minScore == 0) {
                minScore = testMinScore;
            } else {
                if (testMinScore <= minScore) {
                    minScore = testMinScore;
                }
            }
            totalScore = totalScore + getScore;
        }
        averageScore = (double) (totalScore - maxScore - minScore) / (count - 2);
        System.out.println(averageScore);
    }

}
