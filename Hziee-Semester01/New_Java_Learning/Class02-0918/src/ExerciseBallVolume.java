import java.util.Scanner;

public class ExerciseBallVolume {
    public static void main(String[] args) {
        Scanner inputR = new Scanner(System.in);
        int finalR = inputR.nextInt();
        float ballVolume;
        ballVolume = (float) (4 / 3 * 3.1416 * (finalR ^ 3));
        System.out.printf("%.3f", ballVolume);

    }
}
