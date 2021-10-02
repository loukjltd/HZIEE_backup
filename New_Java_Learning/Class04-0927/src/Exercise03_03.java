import java.util.Scanner;

public class Exercise03_03 {
    static boolean prime (int k) { //填空1
        if (k <= 1) return false;
        for (int i = 2; i < k; i ++)
            if (k % i == 0) return false; //填空2
        return true;
    }

    public static void main(String[] args) {
        int i, x, y;

        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        for (i = x; i < y; i ++) {
            if (prime(i)) { //填空3
                System.out.println(i);
            }
        }
    }
}
