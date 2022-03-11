import java.util.Scanner;

/**
 * @author loukj
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.print("请输入行数：");
        Scanner scanner = new Scanner(System.in);
        int kb = scanner.nextInt();
        for (int i = 0; i < kb; i++) {
            int number = 1;
            System.out.format("%" + (kb - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}


