import java.util.Scanner;

/**
 * @author loukj
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.print("请输入行数：");
        Scanner scanner = new Scanner(System.in);
        int kb = scanner.nextInt();
        System.out.print("请输入项数：");
        int m = scanner.nextInt();
        int number = 1;
        int j = 0;
        if (m == 1) {
            System.out.println(1);
        }
        while (j <= m) {
            number = number * (kb - j - 1) / (j + 1);
            j++;
            if (j == m - 1) {
                System.out.println(number);
            }
        }
    }
}
