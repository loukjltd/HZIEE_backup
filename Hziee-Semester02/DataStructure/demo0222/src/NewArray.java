import java.util.Scanner;

/**
 * @author loukj
 */
public class NewArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner kb = new Scanner(System.in);
        System.out.println("这里为了方便就固定 6 7 这两个数字");
        System.out.println("位移几位。");
        int b = kb.nextInt();
        for (int i = 0; i < 5 - b; i++) {

            System.out.print(a[i]);
            System.out.print(" ");

        }
        System.out.print(a[5] + " " + a[6]);
        for (int i = 5 - b; i < 5; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        for (int i = 7; i <= 10; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }

    }
}
