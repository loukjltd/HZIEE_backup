import java.util.Scanner;

public class TestStuScore {
    public static void main(String[] args) {
        Scanner getScore = new Scanner(System.in);
        double[] stuScore = new double[10];
        double totalScore = 0;
        for (int i = 0; i < stuScore.length; i++) {
            stuScore[i] = getScore.nextDouble();
        }
        for (double v : stuScore) {
            totalScore = totalScore + v;
        }
        System.out.println(totalScore / stuScore.length);
    }
}
