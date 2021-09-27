import java.util.Scanner;
import java.util.zip.CRC32;

public class Exercise03_01 {
    public static void main(String[] args) {
        double fahr = 0;
        double celsius;
        System.out.println("华氏温度   摄氏温度");
        while (fahr >= 0 && fahr <= 80) {
            celsius = (fahr - 32) * 5 / 9;
            System.out.printf("%3.0f   %6.1f\n", fahr, celsius);
            fahr = fahr + 20;
        }
    }
}
