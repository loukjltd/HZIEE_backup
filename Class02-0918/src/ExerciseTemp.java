import java.util.Scanner;
public class ExerciseTemp {
    public static void main(String[] args) {
        Scanner inputTemp = new Scanner(System.in);
        double cTemp, fTemp;
        cTemp = inputTemp.nextDouble();
        fTemp = cTemp * 9 / 5 + 32;
        System.out.printf("%.2f", fTemp);


    }
}
