import java.util.Scanner;

public class TestMath {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        double lineA, lineB, lineC;
        double finalArea;
        double angleA, angleB;

        System.out.println("Please enter 2 lines: ");
        lineA = line.nextDouble();
        lineB = line.nextDouble();
        lineC = Math.sqrt(lineA * lineA + lineB * lineB);

        finalArea = lineA * lineB / 2;
        System.out.printf("The area of the triangle is: %.1f\n", finalArea);
        angleA = Math.round(Math.asin(lineA / lineC) * 180 / Math.PI);
        angleB = 90 - angleA;
        System.out.printf("Two acute angle is: %.1f & %.1f", angleA, angleB);

    }
}
