public class Exercise03_08 {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i < 1000; i++) {
            int sum = 0;
            for (j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            if (sum == i) {
                System.out.println(i + "\t");
            }
        }
    }
}
