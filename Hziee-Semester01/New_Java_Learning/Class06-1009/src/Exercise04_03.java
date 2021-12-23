public class Exercise04_03 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {11, 22, 33, 44, 55, 66};
        int[] c = new int[a.length];
        for (int i = 0; i < c.length; i ++) {
            c[i] = a[i] * b[i];
        }
        for (int i = 0; i < c.length; i ++) {
            System.out.printf("%d ", c[i]);
        }
    }
}
