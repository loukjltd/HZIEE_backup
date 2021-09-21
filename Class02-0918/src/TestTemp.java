import java.util.Scanner;
public class TestTemp {
    public static void main(String[] args) {
        Scanner testTemp = new Scanner(System.in);
        double cTemp, fTemp;
        cTemp = testTemp.nextDouble();
        fTemp = cTemp * 9 / 5 + 32;
        System.out.printf("%.2f", fTemp);
    }
}
