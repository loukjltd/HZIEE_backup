import java.util.Random;

/**
 * @author loukj
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[10];
        boolean bFind = false;
        Random r = new Random();
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] = r.nextInt(90) + 10;
            System.out.print(a[i] + "");
        }
        System.out.println();
        for (int j = 1; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        System.out.println("排序:");
        for (int x : a) {
            System.out.print(x + "");
        }
    }
}
