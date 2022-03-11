/**
 * @author loukj
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[10];
        int minIndex;
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.printf("%d", a[i]);
        }
        System.out.println();
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
        System.out.println("排序:");
        for (int x : a) {
            System.out.printf("%d", x);
        }
    }
}
